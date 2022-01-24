package com.bolsadeideas.springboot.app.filters;







import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class ClientFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(ClientFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       logger.info("starting filter logger");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
                if (servletRequest.getContentType().equalsIgnoreCase("application/json"))
                    logger.info("request is type json");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
