package com.apin.qunar.app.common.fliter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.*;
import java.nio.charset.Charset;

/**
 * TODO: HttpServletRequestWrapper继承类描述
 *
 * @author fy
 * @version 1.0
 * @date 2018/8/15 9:44
 */
@Slf4j
public class BodyReaderHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private final byte[] body;

    /**
     * @param userSecretKey 商户的秘钥
     * @param request       请求头数据
     * @throws Exception 异常抛出
     */
    BodyReaderHttpServletRequestWrapper(final String userSecretKey, HttpServletRequest request) throws Exception {
        super(request);
        String sessionStream = getBodyString(userSecretKey, request);
        body = sessionStream.getBytes(Charset.forName("UTF-8"));
    }

    /**
     * description: 获取请求Body
     *
     * @param userSecretKey 商户秘钥
     * @param request       请求实体的数据解析
     * @return String 解密数据
     */
    private String getBodyString(final String userSecretKey, final ServletRequest request) throws Exception {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = cloneInputStream(request.getInputStream());
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //得到前段传递的json的字符串，进行截取
        JSONObject parseObject = JSON.parseObject(sb.toString());
        String sign = parseObject.getString("sign");
        return Aes.decrypt(sign, userSecretKey);
    }


    /**
     * description: 复制输入流</br>
     *
     * @param inputStream 输入流
     * @return InputStream
     */
    private InputStream cloneInputStream(ServletInputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        try {
            while ((len = inputStream.read(buffer)) > -1) {
                byteArrayOutputStream.write(buffer, 0, len);
            }
            byteArrayOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(getInputStream()));
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {

        final ByteArrayInputStream bAis = new ByteArrayInputStream(body);

        return new ServletInputStream() {

            @Override
            public int read() throws IOException {
                return bAis.read();
            }

            @Override
            public boolean isFinished() {
                return false;
            }

            @Override
            public boolean isReady() {
                return false;
            }

            @Override
            public void setReadListener(ReadListener readListener) {
            }
        };
    }
}
