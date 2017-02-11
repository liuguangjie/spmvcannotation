package cn.springmvc.bean;

import cn.springmvc.util.UtilMessage;
import org.codehaus.jackson.annotate.JsonIgnore;

import java.util.Locale;

/**
 * Created by free on 17-2-10.
 */
public class ResultList {
    private String code;
    private String message;
    private Object data;
    @JsonIgnore
    private Locale locale;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        if(locale==null){
            return this.message;
        }
        String returnMsg="";

        returnMsg= UtilMessage.getMessage(this.getCode(), locale);

        if(returnMsg==null||"".equals(returnMsg)){
            returnMsg=this.message;
        }
        return returnMsg;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
