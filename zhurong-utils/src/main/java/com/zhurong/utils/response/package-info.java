package com.zhurong.utils.response;

/**
 InfoCoinResponse和EdopCoinResponse的区别

 应用场景：
 1、InfoCoinResponse为互联网项目，zshy公司资讯金币项目的统一响应实体。

 2、EdopResponse为产品线项目（传统项目），e公司edop产品线的统一响应实体。


 响应码和响应信息：
 1、InfoCoinResponse的响应码和响应信息，都封装在ResponseEnum里，需要整理成册。
 2、EdopResponse的响应码只分成功和失败，响应信息封装在各个Controller或Service类里面。


 如果选择：
 具体项目具体分析

 */