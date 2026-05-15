package jp.co.sss.shop.filter;

//11章 ソースコード11-2,3 作成

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
public class Message02Filter extends HttpFilter {
    @Override
    public void doFilter(
     HttpServletRequest request, HttpServletResponse response, FilterChain chain)
     throws IOException, ServletException {
        System.out.println("Done Message02Filter");
        chain.doFilter(request, response);
    }
}
