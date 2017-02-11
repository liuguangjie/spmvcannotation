package cn.springmvc.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Vector;

/**
 * Created by free on 17-2-11.
 */
public class LocaleRequestWrapper extends HttpServletRequestWrapper {
    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public LocaleRequestWrapper(HttpServletRequest request) {
        super(request);
    }
    @Override
    public Enumeration getLocales() {
        Vector v = new Vector(1);
        v.add(getLocale());
        return v.elements();
    }

    @Override
    public Locale getLocale() {
        HttpServletRequest request = (HttpServletRequest) getRequest();

        String language=request.getParameter("language");
        if(request.getHeader("language")!=null&&!"".equals(request.getHeader("language"))){
            language=request.getHeader("language");
        }
        Locale locale=new Locale("zh","CN");//默认中文
        if(null!=language&&!"".equals(language)&&language.indexOf("_")!=-1){
            locale=new Locale(language.split("_")[0],language.split("_")[1]);
        }
        return locale;
    }
}
