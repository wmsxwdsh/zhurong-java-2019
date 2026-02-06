package com.zhurong.utils.content;

import java.util.HashSet;

/**
 * 内容对比差标红工具
 * 2020年06月16日
 */
public class ContrastUtil {

    private static HashSet sameCharSet;

    public static String[] doCompare(String s1, String s2) {
        getSameChar(s1, s2);
        return new String[]{doDiffChar(s1), doDiffChar(s2)};
    }

    protected static void getSameChar(String s1, String s2) {
        int s1L = s1.length();
        int s2L = s2.length();

        char[] s1CharArr = s1.toCharArray();
        char[] s2CharArr = s2.toCharArray();

        sameCharSet = new HashSet();
        for (int i = 0; i < s1L; i++) {
            for (int j = 0; j < s2L; j++) {
                if (s1CharArr[i] == s2CharArr[j]) {
                    sameCharSet.add(s1CharArr[i]);
                }
            }
        }
    }

    protected static String doDiffChar(String s) {
        StringBuffer sBuffer = new StringBuffer();
        char[] sChar = s.toCharArray();
        int sL = s.length();

        for (int i = 0; i < sL; i++) {
            if (sameCharSet.contains(sChar[i])) {
                //<span>神</span>
                sBuffer.append("<span>").append(sChar[i]).append("</span>");
            } else {
                //<span style="color: red">州</span>
                sBuffer.append("<span style=\"color: red\">").append(sChar[i]).append("</span>");
            }
        }

        return sBuffer.toString();
    }

    public static void main(String[] args) {
        String s1 = "我有没啊";
        String s2 = "我没啊";
        String[] arr = doCompare(s1, s2);

        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }

}