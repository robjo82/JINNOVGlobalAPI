package com.jinnov.jinnovglobalapi.config.security;

import com.jinnov.jinnovglobalapi.annotation.RequireMondayToken;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;

import java.io.IOException;

public class MondayTokenFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        Object handler = request.getAttribute(HandlerMapping.BEST_MATCHING_HANDLER_ATTRIBUTE);

        if (handler instanceof HandlerMethod handlerMethod) {
            RequireMondayToken requireMondayToken = handlerMethod.getMethodAnnotation(RequireMondayToken.class);

            if (requireMondayToken != null) {
                String authHeader = request.getHeader("Authorization");
                if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return; // Stop the filter chain
                }

                String token = authHeader.substring(7);
                // TODO: Validate token

            }
        }

        filterChain.doFilter(request, response);
    }
}

