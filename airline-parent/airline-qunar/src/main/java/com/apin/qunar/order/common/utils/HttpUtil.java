package com.apin.qunar.order.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
public class HttpUtil {

    private final static int CONNECT_TIMEOUT = 5000; // in milliseconds
    private final static String DEFAULT_ENCODING = "UTF-8";

    public static String postData(String urlStr, String data) {
        return postData(urlStr, data, null);
    }

    public static String postData(String urlStr, String data, String contentType) {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlStr);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(CONNECT_TIMEOUT);
            conn.setReadTimeout(CONNECT_TIMEOUT);
            if (contentType != null)
                conn.setRequestProperty("content-type", contentType);
            OutputStreamWriter writer = new OutputStreamWriter(conn.getOutputStream(), DEFAULT_ENCODING);
            if (data == null)
                data = "";
            writer.write(data);
            writer.flush();
            writer.close();

            reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), DEFAULT_ENCODING));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append("\r\n");
            }
            return sb.toString();
        } catch (IOException e) {
            log.error("Error connecting to " + urlStr + ": " + e.getMessage());
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
            }
        }
        return null;
    }

    /**
     * 发送post请求
     *
     * @param url          请求地址
     * @param outputEntity 发送内容
     * @param isLoadCert   是否加载证书
     */
    public static CloseableHttpResponse Post(String url, String outputEntity, boolean isLoadCert) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        // 得指明使用UTF-8编码，否则到API服务器XML的中文不能被成功识别
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(new StringEntity(outputEntity, "UTF-8"));
        if (isLoadCert) {
            // 加载含有证书的http请求
            return HttpClients.custom().setSSLSocketFactory(CertUtil.initCert()).build().execute(httpPost);
        } else {
            return HttpClients.custom().build().execute(httpPost);
        }
    }
}
