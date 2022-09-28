package se.salt.jfs.kanyeapi.controller;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogIncomingTimeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        request.setAttribute("createdAt", LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        filterChain.doFilter(request, response);
    }
    @Override
    protected boolean shouldNotFilter (HttpServletRequest request) {
        return !request.getMethod().equals("PUT");
    }
}
