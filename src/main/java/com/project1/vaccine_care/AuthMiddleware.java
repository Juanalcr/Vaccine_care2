/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Filter;
import java.util.logging.LogRecord;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *
 * @author user
 */
@Component
@Order(1)
public class AuthMiddleware implements Filter {

    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        System.out.println("Sending request to: " + req.getRequestURI());
        String[] urls = {"/loginuser", "/register"};
        boolean contains = Arrays.stream(urls)
                .anyMatch(req.getRequestURI()::equals);

        HttpSession session = req.getSession(true);

        Pattern pattern = Pattern.compile("(png|jpg|images|css|js|ico)");
        Matcher matcher = pattern.matcher(req.getRequestURI());
        boolean matchFound = matcher.find();

        if (!matchFound) {
            if (!contains && (session.getAttribute("loggedIn") == null)) {
                System.out.println("User should be logged in!");
                res.sendRedirect("/loginuser");
            } else if (contains && (session.getAttribute("loggedIn") != null)) {
                System.out.println("User has been logged in!");
                res.sendRedirect("/");
            } else {
                chain.doFilter(request, response);
            }
        } else {
            chain.doFilter(request, response);
        }

        System.out.println("Finishing request from: " + req.getRequestURI());
    }

    @Override
    public boolean isLoggable(LogRecord lr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
