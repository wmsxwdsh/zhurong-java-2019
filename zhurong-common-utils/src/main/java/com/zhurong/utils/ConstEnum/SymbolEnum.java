/**
 * @Title: SymbolEnum.java
 * @Package: com.zhurong.utils.constenum
 * @author LZG, liuzhongguo@cdvcloud.com
 * Copyright (c) 2020 https://www.yunshicloud.com
 */
package com.zhurong.utils.ConstEnum;

/**
 * @description: 标点枚举
 * @author LZG
 * @date 2020年06月15日
 */
public enum SymbolEnum {

    /**
     * 半角句号(点)
     */
    DOT("."),
    /**
     * 转义：半角句号(点)
     */
    DOT_ESCAPE("\\."),
    /**
     * 百分号
     */
    PERCENT("%"),
    /**
     * 下划线
     */
    UNDERLINE("_"),
    /**
     * 半角空格
     */
    SPACE(" "),
    /**
     * 问号
     */
    QUESTION_MARK("?"),
    /**
     * &符号
     */
    AMPERSAND("&"),
    /**
     * 等于号
     */
    EQUAL_SIGN("="),
    /**
     * 半角逗号
     */
    COMMA(","),
    /**
     * 全角逗号
     */
    FULL_COMMA("，"),
    /**
     * 半角左中括号
     */
    OPEN_BRACKET("["),
    /**
     * 半角右中括号
     */
    CLOSE_BRACKET("]"),
    /**
     * 半角右中括号
     */
    MATCH("*"),
    /**
     * 顿号
     */
    TON("、"),
    /**
     * 幂次方符号
     */
    POWER("^"),
    ;

    private String symbol;

    SymbolEnum(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }


}