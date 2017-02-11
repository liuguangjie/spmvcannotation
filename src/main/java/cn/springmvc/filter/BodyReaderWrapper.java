package cn.springmvc.filter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;

/**
 * Created by free on 17-2-11.
 */
public class BodyReaderWrapper extends HttpServletRequestWrapper {

    private static String ENCODING="UTF-8";
    private final byte[] body;

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request
     * @throws IllegalArgumentException if the request is null
     */
    public BodyReaderWrapper(HttpServletRequest request,String encoding) throws IOException{
        super(request);
        if(encoding!=null){
            ENCODING=encoding;
        }
        String sb= readStream(request.getInputStream());
        body=sb.getBytes(ENCODING);
    }

    protected String readStream(InputStream iStream) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(iStream,ENCODING));
        String line=null;
        while((line = reader.readLine())!=null){
            buffer.append(line);
        }
        return buffer.toString();
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        final ByteArrayInputStream bais = new ByteArrayInputStream(body);
        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bais.read();
            }
        };
    }



}
