package com.apin.qunar.order.common.utils;

import com.apin.qunar.common.utils.SpringContextUtil;
import com.apin.qunar.order.common.config.WeChatPayConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.ssl.SSLContexts;
import org.springframework.beans.factory.annotation.Autowired;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.security.KeyStore;

/**
 * 加载证书的类
 *
 * @author
 * @since 2017/08/16
 */

@Slf4j
public class CertUtil {
    @Autowired
    private static WeChatPayConfig weChatPayConfig;

    static {
        weChatPayConfig = SpringContextUtil.getBean(WeChatPayConfig.class);
    }

    /**
     * 加载证书
     */
    public static SSLConnectionSocketFactory initCert() throws Exception {
        String filePath = System.getProperty("user.dir");//获取当前项目的路径
        log.info("user.dir=" + filePath);
        FileInputStream instream = null;
        try {
            KeyStore keyStore = KeyStore.getInstance("pkcs12");
            instream = new FileInputStream(new File(filePath + weChatPayConfig.getCertPath()));
            keyStore.load(instream, weChatPayConfig.getMerchantId().toCharArray());
            if (null != instream) {
                instream.close();
            }
            SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore, weChatPayConfig.getMerchantId().toCharArray()).build();
            return new SSLConnectionSocketFactory(sslcontext, new String[]{"TLSv1"}, null, SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
        } catch (Exception e) {
            log.error("初始化微信支付证书异常", e);
        }
        return null;
    }
}