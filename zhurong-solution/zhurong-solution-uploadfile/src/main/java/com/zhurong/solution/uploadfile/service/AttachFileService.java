package com.zhurong.solution.uploadfile.service;

import com.zhurong.db.persistence.domain.AttachFile;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AttachFileService {

    /**
     * 上传文件
     * @return int 执行成功的数量
     */
    public List<AttachFile> uploadFile(String groupId, MultipartFile[] files);

    /**
     * 下载文件
     */
    public void downloadFile(HttpServletRequest request, HttpServletResponse response, String id, String pre) throws IOException;

    /**
     * 添加一条新记录
     * @param elemType 添加的对象
     * @return int 执行成功的数量
     */
    public AttachFile insertFile(AttachFile elemType);

    /**
     * 根据主键删除一条新记录
     */
    public void deleteFile(String id);

    /**
     * 根据主键更新一条新记录
     * @return int 执行成功的数量
     */
    public AttachFile updateFile(String groupId, String fileId, MultipartFile file);

    /**
     * 根据主键查询一条新记录
     * @param key 主键值
     * @return File 查询到的对象
     */
    public AttachFile queryFile(String key);

    /**
     *查询所有File记录
     * @return List<File> 对象集
     */
    public List<AttachFile> queryFileList();

    /**
     * 根据附件组编号删除多个附件表记录
     * @param groupId Object
     */
    public void deleteFileByGroupId(String groupId);
    public List<AttachFile> findByGroupId(String groupId);

    public void previewFile(HttpServletRequest request, HttpServletResponse response, String id) throws IOException;

    public void previewFile(HttpServletRequest request, HttpServletResponse response, String id, String size, boolean cut)
        throws IOException;

}
