package com.zhurong.utils.TheOthers;

import com.zhurong.utils.common.StringUtil;
import com.zhurong.utils.json.JsonUtil;
import com.zhurong.utils.response.InfoCoinResponse;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * jsonp 的写法和用法
 * 2018/8/27
 */
public class JsonpController {

    // jsonp第1种实现方式
    @RequestMapping(value = "/register", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object register(@RequestParam String userMail, @RequestParam String vCodeToken, @RequestParam String validateCode,
        @RequestParam String confirmUrl, @RequestParam String signInfo, String callback) {

        //InfoCoinResponse infoCoinResponse = merchUserService.merchUserRegister(userMail, vCodeToken, validateCode, confirmUrl, signInfo);
        InfoCoinResponse responseVO = null;
        if (StringUtil.isBlank(callback)) {
            return responseVO;
        }

        //把 pojo 转换成 json
        String json = JsonUtil.objectToJson(responseVO);
        //拼装返回值
        String result = callback + "(" + json + ");";

        return result;
    }

    // jsonp第2种实现方式
    @RequestMapping(value = "/register2", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Object register2(@RequestParam String userMail, @RequestParam String vCodeToken, @RequestParam String validateCode,
        @RequestParam String confirmUrl, @RequestParam String signInfo, String callback) {

        //InfoCoinResponse infoCoinResponse = merchUserService.merchUserRegister(userMail, vCodeToken, validateCode, confirmUrl, signInfo);
        InfoCoinResponse infoCoinResponse = null;
        if (StringUtil.isBlank(callback)) {
            return infoCoinResponse;
        }

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(infoCoinResponse);
        //setJsopFunction方法被移除了？
        //mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

}