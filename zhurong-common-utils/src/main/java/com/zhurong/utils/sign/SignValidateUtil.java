package com.zhurong.utils.sign;

import com.zhurong.utils.common.LinkStrUtil;
import com.zhurong.utils.common.StringUtil;
import com.zhurong.utils.response.InfoCoinResponse;
import com.zhurong.utils.response.ResponseEnum;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * 验签工具总入口
 * （结合 http 请求对 Md5SignUtil、RsaSignUtil 的再次封装。）
 * 2018/10/19
 */
public class SignValidateUtil {

    /**
     * md5 加签
     */
    public static void md5Sign(Map<String, Object> paramMap) {
        //一般从配置文件拿，或者从数据库拿，我这写在类里
        String md5SignKey = Md5SignUtil.md5SignKey;

        String paramJsonStr = LinkStrUtil.createLinkString(paramMap, true);
        String signInfo = Md5SignUtil.sign(paramJsonStr, md5SignKey);
        paramMap.put("signInfo", signInfo);
    }

    /**
     * md5 验签
     * @return com.zhurong.utils.response.InfoCoinResponse 这里也可以用boolean接收
     */
    public static InfoCoinResponse md5Verify(HttpServletRequest request) {
        String md5SignKey = Md5SignUtil.md5SignKey;

        //签名验空
        String clientSignInfo = request.getParameter("signInfo");
        if (StringUtil.isBlank(clientSignInfo)) {
            return InfoCoinResponse.build(ResponseEnum.param_blank, "signInfo");
        }

        Map<String, Object> paraMap = new HashMap<String, Object>();

        //获取所有参数
        Enumeration enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            if (paraName.equals("signInfo")) {
                continue;
            }

            paraMap.put(paraName, request.getParameter(paraName));

        }

        String paraJson = LinkStrUtil.createLinkString(paraMap, true);
        boolean verifyResult = Md5SignUtil.verify(paraJson, clientSignInfo, md5SignKey);

        if (!verifyResult) {
            return InfoCoinResponse.build(ResponseEnum.sign_fail);
        }
        return InfoCoinResponse.build(ResponseEnum.success);
    }

}