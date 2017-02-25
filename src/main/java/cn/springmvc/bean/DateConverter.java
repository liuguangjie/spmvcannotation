package cn.springmvc.bean;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by free on 17-2-25.
 *
 */
public class DateConverter implements Converter {
    private final  DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        writer.setValue(dateFormat.format(source));

    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        String ss=reader.getValue();
        try {
            return dateFormat.parse(ss);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public boolean canConvert(Class type) {
        return Date.class.isAssignableFrom(type);
    }
}
