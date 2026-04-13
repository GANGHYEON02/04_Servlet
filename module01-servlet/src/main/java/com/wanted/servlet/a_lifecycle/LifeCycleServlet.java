package com.wanted.servlet.a_lifecycle;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
/* comment.
 *   @WebServlet 어노테이션은 해당 클래스가 Servlet 임을
 *   명시하는 어노테이션이다.
 *   value 속성은 서블릿이 매핑 될 url 패턴을 지정하며,
 *   해당 클래스는 /life-cycle 요청이 들어오면 처리를 한다.
 *  */

@WebServlet(value = "/life-cycle")
public class LifeCycleServlet extends HttpServlet {

    private int initCount = 1;
    private int serviceCount = 1;
    private int destroyCount = 1;

    //Servlet 객체가 메모리 공간에 만들어질때 가장 먼저 딱 한번 호출된다.
    //URL로 최초 요청을 보낼 때 웹 서버(WAS)가 이 생성자를 통해 객체를 인스턴스화 한다.
    public LifeCycleServlet() {
        System.out.println("기본 생성자 호출됨..");
    }

    //호출될 때마다 갯수 증가
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init() 호출됨... : " + initCount++);
    }

    //클라이언트의 요청이 올 때마다 매번 호출되는 아주 핵심적인 메서드
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        System.out.println("service() 호출됨... : " + serviceCount++);
    }

    //서버(WAS)가 정상적으로 종료되거나 서블릿 코드가 수정되어 재적재(Reloading)될 때,
    // 서블릿 객체를 메모리에서 내리기 직전 딱 한 번 호출
    @Override
    public void destroy() {
        System.out.println("destory() 호출됨... : " + destroyCount++);
    }
}