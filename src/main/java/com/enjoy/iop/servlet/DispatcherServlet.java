package com.enjoy.iop.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * <b>Author</b>: Hsiang Leekwok<br/>
 * <b>Date</b>: 2019/04/07 21:08<br/>
 * <b>Version</b>: v1.0<br/>
 * <b>Description</b>:
 */
public class DispatcherServlet extends HttpServlet {

    private final Map<String, Method> handlerMap=new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI(); // get path of: /project_path/controller/method
        String context = request.getContextPath(); // get path of /project_path
        String path = uri.replace(context, ""); // replace /project_path to ""

        Method method=handlerMap.get(path);
    }
}
