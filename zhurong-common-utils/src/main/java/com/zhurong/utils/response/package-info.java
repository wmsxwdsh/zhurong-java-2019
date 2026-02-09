package com.zhurong.utils.response;

/**
 InfoCoinResponse 和 EdopCoinResponse 的区别

 应用场景：
 1、InfoCoinResponse 为互联网项目，zshy 公司资讯金币项目的统一响应实体。

 2、EdopResponse 为产品线项目（传统项目），公司 Edop 产品线的统一响应实体。


 响应码和响应信息：
 1、InfoCoinResponse 的响应码和响应信息，都封装在ResponseEnum里，需要整理成册。
 2、EdopResponse 的响应码只分成功和失败，响应信息封装在各个Controller或Service类里面。


 如果选择：
 具体项目具体分析

 */