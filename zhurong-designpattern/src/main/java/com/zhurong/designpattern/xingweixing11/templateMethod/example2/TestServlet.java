package com.zhurong.designpattern.xingweixing11.templateMethod.example2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、HttpServlet是抽象类，骨架方法是service()
 * 2、HttpServelt本身是模板方法模式的一个应用
 * 2019/3/18
 */
public class TestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("invoked TestServlet doGet Method");
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("invoked TestServlet doPost Method");
        super.doPost(req, resp);
    }

}