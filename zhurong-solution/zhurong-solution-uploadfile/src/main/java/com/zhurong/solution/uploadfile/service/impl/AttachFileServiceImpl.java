package com.zhurong.solution.uploadfile.service.impl;

import com.zhurong.db.persistence.domain.AttachFile;
import com.zhurong.db.persistence.domain.AttachFileExample;
import com.zhurong.db.persistence.domain.AttachFileExample.Criteria;
import com.zhurong.db.persistence.mapper.generic.AttachFileMapper;
import com.zhurong.solution.uploadfile.service.AttachFileService;
import com.zhurong.utils.common.FileUtil;
import com.zhurong.utils.idgen.UuidUtil;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AttachFileServiceImpl implements AttachFileService {

    @Autowired
    private AttachFileMapper attachFileMapper;

    public static String basePath;
    public static String previewBasePath;

    /**
     * 不要记日志，子方法会记录
     */
    @Override
    public List<AttachFile> uploadFile(String groupid, MultipartFile[] files) {
        File group = new File(basePath + groupid);
        if (!group.exists()) {
            group.mkdir();
        }
        File[] finalFiles = new File[files.length];
        for (int i = 0; i < files.length; i++) {
            MultipartFile file = files[i];
            String filename = FileUtil.getNewFileName(basePath + groupid, file.getOriginalFilename());
            File newFile = null;
            try {
                newFile = FileUtil.getFile(file.getInputStream(), group.getAbsolutePath() + File.separator + filename);
            } catch (IOException e) {
                newFile = null;
            }
            finalFiles[i] = newFile;
        }
        return uploadFile(groupid, finalFiles);
    }

    private List<AttachFile> uploadFile(String groupid, File[] files) {
        List<AttachFile> list = new ArrayList<AttachFile>();
        File group = new File(basePath + groupid);
        if (!group.exists()) {
            group.mkdir();
        }
        for (File newFile : files) {
            if (newFile != null) {
                if (!newFile.getParentFile().getAbsolutePath().equals(group.getAbsolutePath())) {
                    String finalName = FileUtil.getNewFileName(group.getAbsolutePath(), newFile.getName());
                    File finalFile = new File(group.getAbsolutePath() + File.separator + finalName);
                    FileUtil.removeFile(newFile, finalFile, true);
                    newFile = finalFile;
                }
                AttachFile aFile = new AttachFile();
                aFile.setId(UuidUtil.get32UUIDStr());
                aFile.setGroupId(groupid);
                aFile.setName(FileUtil.getFileNameWithoutSuffix(newFile.getName()));
                aFile.setSuffix(FileUtil.getFileSuffix(newFile.getName()).toLowerCase());
                aFile.setPath(newFile.getAbsolutePath());
                aFile.setCreateTime(new Date());
                aFile.setUserid(null);
                if (insertFile(aFile) == null) {
                    FileUtil.deleteFile(newFile);
                } else {
                    list.add(aFile);
                }
            }
        }
        return list;
    }


    @Override
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String id, String pre) throws IOException {
        AttachFile rs = queryFile(id);
        File file = new File(rs.getPath());
        if (file.exists() && rs != null) {
            int length = Integer.MAX_VALUE;
            if (file.length() < length) {
                length = (int) file.length();
            }
            response.setContentLength(length);
            String fileName;
            if (null != pre && pre != "") {
                fileName = pre + "——" + rs.getName() + "." + rs.getSuffix();
            } else {
                fileName = file.getName();
            }
            //FileUtil.downloadFile(fileName, file, response);

            //禁用缓存
//        	response.setHeader("Cache-Control", "no-cache");
//			response.setHeader("Pragma", "no-cache");
//			response.setDateHeader("Expires", -1);

            FileUtil.downloadFilebBreakpoint(request, response, file, fileName);
        }
    }

    @Override
    public void previewFile(HttpServletRequest request, HttpServletResponse response, String id) throws IOException {
        previewFile(request, response, id, null, false);
    }

    @Override
    public void previewFile(HttpServletRequest request, HttpServletResponse response, String id, String size, boolean cut)
        throws IOException {
        AttachFile rs = queryFile(id);
        if (rs != null) {
            File file;
            if (size == null) {
                file = new File(rs.getPath());
            } else {
                file = FileUtil
                    .resizeImage(new File(rs.getPath()), previewBasePath + id + "-" + size + "-" + cut + "." + rs.getSuffix(), size, cut);
            }
            if (file != null && file.exists()) {
                int length = Integer.MAX_VALUE;
                if (file.length() < length) {
                    length = (int) file.length();
                }
                response.setContentLength(length);
                String fileName = file.getName();
                FileUtil.openFilebBreakpoint(request, response, file, fileName);
            }
        }
    }

    /**
     * 添加一条新记录
     * @param elemType 添加的对象
     * @return int 执行成功的数量
     */
    @Override
    public AttachFile insertFile(AttachFile elemType) {
        attachFileMapper.insert(elemType);
        return attachFileMapper.selectByPrimaryKey(elemType.getId());
    }

    /**
     * 根据主键删除一条新记录
     */
    @Override
    public void deleteFile(String id) {
        try {
            AttachFile attachFile = attachFileMapper.selectByPrimaryKey(id);
            FileUtil.deleteFile(attachFile.getPath());
            File path = new File(basePath + attachFile.getGroupId());
            if (path.exists() && path.isDirectory()) {
                String[] fileList = new File(basePath + attachFile.getGroupId()).list();
                if (fileList.length == 0) {
                    FileUtil.deleteFile(basePath + attachFile.getGroupId());
                }
            }
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

        attachFileMapper.deleteByPrimaryKey(id);
    }

    /**
     * 根据主键更新一条新记录
     */
    @Override
    public AttachFile updateFile(String groupId, String fileId, MultipartFile file) {
        AttachFile aFile = queryFile(fileId);
        if (aFile != null) {
            FileUtil.deleteFile(aFile.getPath());
            File group = new File(basePath + groupId);
            if (!group.exists()) {
                group.mkdir();
            }
            String filename = FileUtil.getNewFileName(basePath + groupId, file.getOriginalFilename());
            File newFile = null;
            try {
                newFile = FileUtil.getFile(file.getInputStream(), basePath + groupId + File.separator + filename);
                aFile.setSuffix(FileUtil.getFileSuffix(filename).toLowerCase());
                aFile.setPath(newFile.getAbsolutePath());
                aFile.setSize((int) newFile.length());
                aFile.setUserid(null);
                attachFileMapper.insert(aFile);
                return attachFileMapper.selectByPrimaryKey(aFile.getId());
            } catch (IOException e) {
                return null;
            }
        } else {
            return null;
        }
    }

    /**
     * 根据主键查询一条附件表
     * @param key 主键
     * @return 查询到的附件表对象
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public AttachFile queryFile(String key) {
        return attachFileMapper.selectByPrimaryKey(key);
    }

    /**
     *查询所有附件表记录
     * @return 附件表对象集
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public List<AttachFile> queryFileList() {
        return attachFileMapper.selectByExample(null) ;
    }

    /**
     * 根据附件组编号删除多个附件表记录
     * @param groupId Object
     */
    @Override
    public void deleteFileByGroupId(String groupId) {
        FileUtil.deleteFile(basePath + groupId);

        AttachFileExample example = new AttachFileExample();
        Criteria criteria = example.createCriteria();
        criteria.andGroupIdEqualTo(groupId);

        attachFileMapper.deleteByExample(example);
    }

    /**
     * 根据附件组编号查找多个附件表记录
     * @param groupId Object
     * @return int 执行成功的数量
     */
    @Override
    public List<AttachFile> findByGroupId(String groupId) {
        AttachFileExample example = new AttachFileExample();
        Criteria criteria = example.createCriteria();
        criteria.andGroupIdEqualTo(groupId);
        example.setOrderByClause("create_time");

        return attachFileMapper.selectByExample(example);
    }

}