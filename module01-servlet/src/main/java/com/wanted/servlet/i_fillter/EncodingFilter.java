package com.wanted.servlet.i_fillter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/*im.
*  Filter 는 Servlet Container 에서 제공하는 특별한 기능이다.
*   HttpRequest / Httpresponse 가 발생할 때
*   가장 먼저    /    가장 나중에
*   동작하는 기능이다.
*   Filter적용하는 방식은 크게 2가지가 있다.
*   1. XML 방식의 등록
*   2. 어노테이션 방식의 등록
* */

@WebServlet
public class EncodingFilter implements Filter {

    //XML방식의 필터 사용하기
    private String encodingType;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("incoding Filter의 init()메서드 동작함..");
        encodingType = filterConfig.getInitParameter("encoding-type");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /*im.
        *  필터의 핵심 메서드
        *   요청/응답 시 수행해야 하는 일들을 해당 메서드에서 처리한다
        *   FilterChain은 다음 필터 혹은 필터가 더 이상 없다면 요청을 처리할
        *   Servlet으로 향하게 된다.
        * */
        response.setContentType(encodingType);
        //다음 필터를 호출 or 없다면 Servlet 호출
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        System.out.println("encoding filter  파괴됨..");
    }
}
