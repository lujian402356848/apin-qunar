package com.apin.qunar.app.common.fliter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * TODO: 第三方加密工具类非补偿性加密<aes加密></>
 *
 * @author fy
 * @version 1.0
 * @date 2018/8/14 22:28
 */
@Slf4j
class Aes {

    /**
     * 加密
     *
     * @param encryptedData 需要加密的对象
     * @param secretKey     商户号的秘钥
     * @return 明文加密后的密文
     * @throws Exception 异常
     */
    private static String encrypt(String encryptedData, String secretKey) throws Exception {

        int numLength = 32;
        if (secretKey == null) {
            log.error("商户申请的secretKey不能为空，请核实");
            return null;
        }

        // 判断Key是否为32位
        if (secretKey.length() != numLength) {
            log.error("商户申请的secretKey长度不是32位，请核实");
            return null;
        }

        byte[] raw = secretKey.getBytes("utf-8");
        SecretKeySpec sKeySpec = new SecretKeySpec(raw, "AES");

        //"算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, sKeySpec);
        byte[] encrypted = cipher.doFinal(encryptedData.getBytes("utf-8"));

        //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return new Base64().encodeToString(encrypted);
    }

    /**
     * 解密
     *
     * @param sign      需要解密的对象
     * @param secretKey 商户号的秘钥
     * @return 解密后的明文
     * @throws Exception 异常抛出
     */
    static String decrypt(String sign, String secretKey) throws Exception {
        try {
            byte[] raw = secretKey.getBytes("utf-8");
            SecretKeySpec sKeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, sKeySpec);
            //先用base64解密
            byte[] encrypted = new Base64().decode(sign);
            byte[] original = cipher.doFinal(encrypted);
            return new String(original, "utf-8");
        } catch (Exception e) {
            log.error("解密异常{}", e.toString(), e);
            return null;
        }
    }

}
