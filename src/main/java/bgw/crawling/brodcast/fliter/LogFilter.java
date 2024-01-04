package bgw.crawling.brodcast.fliter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Slf4j
@Component
public class LogFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("log filterInit");

        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        
        String uuid = UUID.randomUUID().toString().substring(0,8);
        startTimeLog(httpServletRequest, uuid);
        uriLog(httpServletRequest, uuid);

        chain.doFilter(request,response);
        endTimeLog(httpServletRequest, uuid);
        
    }

    private static void uriLog(HttpServletRequest httpServletRequest, String uuid) {
        StringBuilder builder = new StringBuilder();
        String uri = httpServletRequest.getRequestURI();
        builder.append("[").append(uuid).append("] URI : ").append(uri);
        log.info(builder.toString());
    }

    private static void startTimeLog(HttpServletRequest httpServletRequest, String uuid) {
        StringBuilder builder = new StringBuilder();
        builder.append("[").append(uuid).append("] ip : ").append(httpServletRequest.getRemoteAddr());
        builder.append(": start : ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        log.info(builder.toString());
    }

    private void endTimeLog(HttpServletRequest httpServletRequest, String uuid) {
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("[").append(uuid).append("] ip : ").append(httpServletRequest.getRemoteAddr());
        builder.append(": end : ").append(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        log.info(builder.toString());
    }


    @Override
    public void destroy() {
        log.info("log destroy");
        Filter.super.destroy();
    }





}
