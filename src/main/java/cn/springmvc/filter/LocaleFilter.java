package cn.springmvc.filter;

import cn.springmvc.util.RequestWrapperUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by free on 17-2-11.
 * 优雅的方式
 */
public class LocaleFilter extends OncePerRequestFilter {


    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //设置body体的 inputStream 为UTF-8
        String type = request.getHeader("Content-Type");
        if (type != null && (type.contains("xml") || type.contains("json"))) {

            doWrapper(request, response, filterChain);

        } else {
            filterChain.doFilter(request, response);
        }


    }

    protected void doWrapper(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest requestWrapper = RequestWrapperUtils.requestChange(request);

        filterChain.doFilter(requestWrapper, response);

    }


}
