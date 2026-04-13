package com.wanted.servlet.b_service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = "/request-service")
public class ServiceMethodServlet extends HttpServlet {

    //에러를 웹서버로 던져 보여줌
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /* comment.
         *   a 태그에 작성한 href 속성은 화면의 url 을 변경하는 속성이다.
         *   url 이 변경되는 방식은 GET 방식의 요청에 해당한다.
         *  */

        //사용자의 요청 방식에 따라 String 으로 다르게 저장됨
        String httpMethod = req.getMethod();
        System.out.println("httpMethod = " + httpMethod);

        if(("GET").equals(httpMethod)) {
            doGet(req, resp);
        } else if(("POST").equals(httpMethod)) {
            doPost(req, resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET 요청을 처리할 메서드 호출됨...");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST 요청을 처리할 메서드 호출됨...");
    }

}