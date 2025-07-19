/**   
 * @Title: MacAddressUtil.java
 * @Package: com.zhurong.utils.system
 * @author LZG, liuzhongguochn@gmail.com  
 * Copyright (c) 2018 https://onezg.cnblogs.com
 */
package com.zhurong.utils.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * @description: 获取服务器mac地址的工具类
 * @author LZG
 * @date 2018/10/29
 */
public class MacAddressUtil {

    /**
     * @Description: get os name
     * @return java.lang.String
     * @author LZG
     * @date 2018/10/29
     */
    public static String getOSName() {
        return System.getProperty("os.name").toLowerCase();
    }

    /**
     * @Description: 获取linux网卡的mac地址. 非windows的系统默认调用本方法获取.
     * @return java.lang.String
     * @author LZG
     * @date 2018/10/29
     */
    public static String getLinuxMACAddress() {
        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;

        try {
            // linux下的命令，一般取eth0作为本地主网卡
            process = Runtime.getRuntime().exec("ifconfig eth0");
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            int index = -1;

            while ((line = bufferedReader.readLine()) != null) {
                index = line.toLowerCase().indexOf("hwaddr");
                if (index >= 0) {
                    mac = line.substring(index + "hwaddr".length() + 1).trim();
                    break;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            bufferedReader = null;
            process = null;
        }
        return mac;
    }

    /**
     * @Description: 获取Windows网卡的mac地址
     * @return java.lang.String
     * @author LZG
     * @date 2018/10/29
     */
    public static String getWindowsMACAddress() {
        String mac = null;
        BufferedReader bufferedReader = null;
        Process process = null;

        try {
            // windows下的命令，显示信息中包含有mac地址信息
            process = Runtime.getRuntime().exec("ipconfig /all");
            bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            int index = -1;
            int index1 = -1;

            while ((line = bufferedReader.readLine()) != null) {
                index = line.toLowerCase().indexOf("physical address");
                index1 = line.indexOf("物理地址");

                if (index >= 0 || index1 >= 0) {
                    index = line.indexOf(":");
                    index1 = line.indexOf(":");
                    if (index >= 0) {
                        mac = line.substring(index + 1).trim();
                        break;
                    }
                    if (index1 >= 0) {
                        mac = line.substring(index1 + 1).trim();
                        break;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            bufferedReader = null;
            process = null;
        }
        if (mac != null) {
            return mac.toUpperCase().replace("-", ":");
        } else {
            return "";
        }
    }

    /**
     * @Description: windows 7 专用 获取MAC地址
     * @return java.lang.String
     * @author LZG
     * @date 2018/10/29
     */
    public static String getWin7MACAddress() throws Exception {

        // 获取本地IP对象
        InetAddress ia = InetAddress.getLocalHost();
        // 获得网络接口对象（即网卡），并得到mac地址，mac地址存在于一个byte数组中。
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        // 下面代码是把mac地址拼装成String
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < mac.length; i++) {
            if (i != 0) {
                sb.append("-");
            }

            // mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(mac[i] & 0xFF);
            sb.append(s.length() == 1 ? 0 + s : s);
        }

        // 把字符串所有小写字母改为大写成为正规的mac地址并返回
        return sb.toString().toUpperCase().replace("-", ":");
    }

    /**
     * @Description: 获取服务器的mac地址
     * @return java.lang.String
     * @author LZG
     * @date 2018/10/29
     */
    public static String getDishInfo() throws Exception {

        String mac = null;
        String os = getOSName().toLowerCase();

        if (os.startsWith("windows 7")) {
            mac = getWin7MACAddress();
        } else if (os.startsWith("window")) {
            mac = getWindowsMACAddress();
        } else {
            mac = getLinuxMACAddress();
        }

        if(null == null)
            return "暂不支持win10系统mac地址的获取";

        return mac.toUpperCase();
    }

    //测试方法
    public static void main(String[] argc) throws Exception {
        String mac = getDishInfo();
        System.out.println(mac);
    }

}