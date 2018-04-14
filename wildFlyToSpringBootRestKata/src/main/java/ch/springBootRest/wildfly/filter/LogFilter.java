package ch.springBootRest.wildfly.filter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
class LogFilter implements Filter {

    private final Log log = LogFactory.getLog(getClass());
    private final Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
            .create();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init : App is running " + filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("doFilter : }"+ gson.toJson(request.getServletContext().getServletContextName())+", "+ gson.toJson(response.getLocale())+"}");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("destroy : App is down");
    }
}
