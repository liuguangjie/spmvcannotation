package cn.springmvc.util;

import cn.springmvc.filter.BodyReaderWrapper;
import cn.springmvc.filter.LocaleRequestWrapper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

/**
 * Created by free on 17-2-11.
 */
public class RequestWrapperUtils {

    public static HttpServletRequest requestChange(HttpServletRequest request) throws IOException {
        HttpServletRequestWrapper requestWrapper=new BodyReaderWrapper(request,null);

        return new LocaleRequestWrapper(requestWrapper);
    }
}
