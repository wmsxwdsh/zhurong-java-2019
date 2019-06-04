/**
 * @Title: AttachFileController.java
 * @Package: com.zhurong.solution.uploadfile.controller
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2019 北京艾森思科技有限公司
 */
package com.zhurong.solution.uploadfile.controller;

import com.zhurong.db.persistence.domain.AttachFile;
import com.zhurong.solution.uploadfile.service.AttachFileService;
import com.zhurong.utils.general.StringUtil;
import com.zhurong.utils.response.InfoCoinResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description: 摘自hdawi项目AttachFileAction
 * @author LZG
 * @date 2019/6/3
 */
@Controller
@RequestMapping("/AttachFileController")
public class AttachFileController {

    @Autowired
    private AttachFileService attachFileService;

    /**
     * @Description: 上传文件（支持多文件上传）
     * @param groupId
     * @param files
     * @param request
     * @param response
     * @return com.zhurong.utils.response.InfoCoinResponse
     * @author LZG
     * @date 2019/6/3
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public InfoCoinResponse upload(@RequestParam String groupId, @RequestParam MultipartFile[] files, HttpServletResponse response) {
        List<AttachFile> list = null;
        if (null != files && files.length > 0) {
            list = attachFileService.uploadFile(groupId, files);
        }

        InfoCoinResponse infoCoinResponse = new InfoCoinResponse();
        if (list.size() > 0) {
            infoCoinResponse.setStatusCode("ok");
            infoCoinResponse.setMsg("上传完成！");
            infoCoinResponse.setData(list);
        } else {
            infoCoinResponse.setStatusCode("error");
            infoCoinResponse.setMsg("上传失败！");
        }

        response.setContentType("text/html;charset=UTF-8");
        return infoCoinResponse;
    }

    /**
     * @Description: 更新文件（限制单文件上传）
     * @param groupId
     * @param id
     * @param files
     * @param response
     * @return com.zhurong.utils.response.InfoCoinResponse
     * @author LZG
     * @date 2019/6/3
     */
    @RequestMapping(value = "/update/{groupId}/{id}", method = RequestMethod.POST)
    public InfoCoinResponse update(@PathVariable(value = "groupId") String groupId, @PathVariable(value = "id") String id,
        @RequestParam MultipartFile files, HttpServletResponse response) {
        InfoCoinResponse infoCoinResponse = new InfoCoinResponse();
        if (attachFileService.updateFile(groupId, id, files) != null) {
            infoCoinResponse.setStatusCode("ok");
            infoCoinResponse.setMsg("上传完成!");
        } else {
            infoCoinResponse.setStatusCode("error");
            infoCoinResponse.setMsg("上传失败！");
        }
        response.setContentType("text/html;charset=UTF-8");
        return infoCoinResponse;
    }

    /**
     * @Description: 下载文件，并自动拼装上格式化的文件名前缀
     * @param id
     * @param preName
     * @param request
     * @param response
     * @return void
     * @author LZG
     * @date 2019/6/3
     */
    @RequestMapping(value = "/downLoad/{id}/{preName}", method = RequestMethod.GET)
    public void downLoad(@PathVariable(value = "id") String id, @PathVariable(value = "preName") String preName, HttpServletRequest request,
        HttpServletResponse response) throws IOException {
        preName = StringUtil.unescape(preName.replaceAll("-_-_-", "%"));
        attachFileService.downloadFile(request, response, id, preName);
    }

    /**
     * @Description: 下载文件
     * @param id
     * @param request
     * @param response
     * @return void
     * @author LZG
     * @date 2019/6/3
     */
    @RequestMapping(value = "/downLoad/{id}", method = RequestMethod.GET)
    public void downLoad(@PathVariable(value = "id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        attachFileService.downloadFile(request, response, id, null);
    }

    /**
     * 删除一条记录
     * @param requestEntity
     * @return
     */
    @RequestMapping(value = "/deleteFile/{id}", method = RequestMethod.GET)
    public InfoCoinResponse deleteFile(@PathVariable(value = "id") String id) {
        attachFileService.deleteFile(id);
        return InfoCoinResponse.build("ok", "删除成功！", null);
    }

    /**
     * 查询一条记录
     *
     * @param requestEntity
     * @return
     */
    @RequestMapping(value = "/queryFile/{id}", method = RequestMethod.GET)
    public InfoCoinResponse queryFile(@PathVariable(value = "id") String id) {
        AttachFile element = attachFileService.queryFile(id);
        InfoCoinResponse infoCoinResponse = new InfoCoinResponse();

        if (element != null) {
            List<AttachFile> list = new ArrayList<AttachFile>();
            list.add(element);
            infoCoinResponse.setStatusCode("ok");
            infoCoinResponse.setMsg("取数据成功！");
            infoCoinResponse.setData(list);
        } else {
            infoCoinResponse.setStatusCode("error");
            infoCoinResponse.setMsg("无数据！");
        }
        return infoCoinResponse;
    }

    /**
     * 获取一个文件组的所有记录
     * @param groupId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/getFileList/{groupId}", method = RequestMethod.GET)
    public InfoCoinResponse getFileList(@PathVariable(value = "groupId") String groupId) throws Exception {
        InfoCoinResponse infoCoinResponse = new InfoCoinResponse();

        try {
            List<AttachFile> list = attachFileService.findByGroupId(groupId);
            if (list.size() > 0) {
                infoCoinResponse.setStatusCode("ok");
                infoCoinResponse.setMsg("查询成功!");
                infoCoinResponse.setData(list);
            } else {
                infoCoinResponse.setStatusCode("ok");
                infoCoinResponse.setMsg("无数据！");
            }
        } catch (Exception e) {
            infoCoinResponse.setStatusCode("error");
            infoCoinResponse.setMsg("服务器错误！");
        }
        return infoCoinResponse;
    }

    /**
     * 打开管理附件页面
     * @param groupId
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public String listFile(String groupId, HttpServletRequest request) {
        List<AttachFile> list = attachFileService.findByGroupId(groupId);
        request.setAttribute("list", list);
        return "other/attachment";
    }

    /**
     * 打开管理附件页面，下载文件时强制重命名为预定义文件名
     * @param groupId
     * @param pre
     * @param request
     * @return
     */
    @RequestMapping("/manage")
    public String manageFile(String groupId, String pre, HttpServletRequest request) {
        List<AttachFile> list = attachFileService.findByGroupId(groupId);
        request.setAttribute("list", list);
        request.setAttribute("pre", pre);
        return "other/attachment";
    }

    /**
     * 预览文件，原文件
     * @param id
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/preview/{id}", method = RequestMethod.GET)
    public @ResponseBody
    void preview(@PathVariable(value = "id") String id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        attachFileService.previewFile(request, response, id);
    }

    /**
     * 预览文件，指定大小进行预览，支持图片
     * @param id
     * @param size 60x60
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/preview/{id}/{size}", method = RequestMethod.GET)
    public void preview(@PathVariable(value = "id") String id, @PathVariable(value = "size") String size, HttpServletRequest request,
        HttpServletResponse response) throws Exception {
        attachFileService.previewFile(request, response, id, size, true);
    }

    /**
     * 预览文件，指定大小进行预览，支持图片
     * @param id
     * @param size 60x60
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/preview/{id}/{size}/{cut}", method = RequestMethod.GET)
    public void preview(@PathVariable(value = "id") String id, @PathVariable(value = "size") String size,
        @PathVariable(value = "cut") boolean cut, HttpServletRequest request, HttpServletResponse response) throws Exception {
        attachFileService.previewFile(request, response, id, size, cut);
    }


}