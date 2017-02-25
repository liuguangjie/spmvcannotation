package cn.springmvc.test;

import cn.springmvc.bean.DateConverter;
import cn.springmvc.bean.FlightBean;
import cn.springmvc.bean.Student;
import cn.springmvc.service.StudentService;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Date;

/**
 * Created by free on 17-2-7.
 */
public class BaseTest {

    @Test
    public void testStudentList() {

        ApplicationContext app = new ClassPathXmlApplicationContext("classpath:applicationcontext.xml");
        StudentService service = app.getBean(StudentService.class);
        System.out.println(service.getStudents());
    }

    /**  xml 和 javabean之间的转换  配合spring Mvc**/

    @Test
    public void testBean2Xml() throws Exception{
        Mapping mapping =new Mapping();
        mapping.loadMapping("src/main/resources/castor/mapping.xml");
        Student student=new Student();
        student.setAge(11);
        student.setId(23);
        student.setName("haha");
        Writer writer = new FileWriter("src/main/resources/castor/test1.xml");
        Marshaller marshaller=new Marshaller(writer);
        marshaller.setMapping(mapping);
        marshaller.marshal(student);


        Reader reader = new FileReader("src/main/resources/castor/test1.xml");
        Unmarshaller unmarshaller = new Unmarshaller(mapping);
        Student stu= (Student) unmarshaller.unmarshal(reader);
        System.out.println(stu);

    }

    @Test
    public void testJavaBean2Xml() {
        // build a test bean
        FlightBean bean = new FlightBean();
        bean.setCarrier("AR");
        bean.setNumber(426);
        bean.setDepartureTime("6:23a");
        bean.setArrivalTime("8:42a");
        try {
            // write it out as XML
            File file = new File("src/main/resources/castor/test.xml");
            Writer writer = new FileWriter(file);
            Marshaller.marshal(bean, writer);
            // now restore the value and list what we get
            Reader reader = new FileReader(file);
            FlightBean read = (FlightBean)
                    Unmarshaller.unmarshal(FlightBean.class, reader);
            System.out.println("Flight " + read.getCarrier() +
                    read.getNumber() + " departing at " +
                    read.getDepartureTime() +
                    " and arriving at " + read.getArrivalTime());
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        } catch (MarshalException ex) {
            ex.printStackTrace(System.err);
        } catch (ValidationException ex) {
            ex.printStackTrace(System.err);
        }
    }

    @Test
    public void testMappingXml() throws  Exception{
        // build a test bean
        FlightBean bean = new FlightBean();
        bean.setCarrier("AR");
        bean.setNumber(426);
        bean.setDepartureTime("6:23a");
        bean.setArrivalTime("8:42a");
        // write it out as XML (if not already present)
        Mapping map = new Mapping();
        map.loadMapping("src/main/resources/castor/mapping.xml");
        File file = new File("src/main/resources/castor/test.xml");
        Writer writer = new FileWriter(file);
        Marshaller marshaller = new Marshaller(writer);
        marshaller.setMapping(map);
        marshaller.marshal(bean);
        // now restore the value and list what we get
        Reader reader = new FileReader(file);
        Unmarshaller unmarshaller = new Unmarshaller(map);
        FlightBean read = (FlightBean)unmarshaller.unmarshal(reader);
        System.out.println("Flight " + read.getCarrier() +
                read.getNumber() + " departing at " +
                read.getDepartureTime() +
                " and arriving at " + read.getArrivalTime());
    }

    @Test
    public void testXStream(){
        XStream xStream=new XStream(new StaxDriver());
        xStream.registerConverter(new DateConverter());
        Student student=new Student();
        student.setId(1);
        student.setName("ss");
        student.setAge(33);
        student.setBirthday(new Date());
        String s=xStream.toXML(student);
        System.out.println(s);
    }
}
