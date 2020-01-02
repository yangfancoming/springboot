package com.goat.xml.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Administrator on 2019/11/30.
 *
 * @ Description: TODO
 * @ author  山羊来了
 * @ date 2019/11/30---11:22
 */
public class StreamUtil {

    //inputStream转outputStream
    public static ByteArrayOutputStream parse(InputStream in) throws Exception {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream;
    }

    //outputStream转inputStream
    public ByteArrayInputStream parse(OutputStream out)  {
        ByteArrayOutputStream  baos= (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }

    //inputStream转String
    public String parse_String(InputStream in) throws Exception {
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
        int ch;
        while ((ch = in.read()) != -1) {
            swapStream.write(ch);
        }
        return swapStream.toString();
    }

    //OutputStream 转String
    public String parse_String(OutputStream out) {
        ByteArrayOutputStream  baos= (ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream.toString();
    }

    //String转inputStream
    public ByteArrayInputStream parse_inputStream(String in)throws Exception {
        ByteArrayInputStream input=new ByteArrayInputStream(in.getBytes());
        return input;
    }
    //String 转outputStream
    public ByteArrayOutputStream parse_outputStream(String in)throws Exception {
        return parse(parse_inputStream(in));
    }

}
