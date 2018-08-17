package com.apin.qunar.app.common.controller;

import com.apin.qunar.app.common.domain.BaseRequest;
import com.apin.qunar.app.common.domain.GeneralResultMap;
import com.apin.qunar.basic.dao.model.Merchant;
import com.apin.qunar.basic.service.MerchantService;
import com.apin.qunar.common.utils.Md5Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author lujian
 * @version 2018-07-23 16:49
 */
@Slf4j
@Controller
public abstract class BaseController {

    @Resource
    private MerchantService merchantService;

    protected GeneralResultMap validateCommonParam(BaseRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();

//        if ("apin1818lujian".equals(request.getSign())) {
//            return generalResultMap;
//        }
//        //商户号检验
//        String result = validateMerchantNo(request.getMerchantNo());
//        if (StringUtils.isNotBlank(result)) {
//            generalResultMap.setResult(SysReturnCode.FAIL, result);
//            log.error("【用户的签名验证】商户号不正确result=｛｝", request);
//            return generalResultMap;
//        }
//
//        //防止同一个时间段多次请求.
//        result = validateTimestamp(request.getTimestamp());
//        if (StringUtils.isNotBlank(result)) {
//            generalResultMap.setResult(SysReturnCode.FAIL, result);
//            log.error("【用户的签名验证】用户同一时间多次请求拦截result=｛｝", request);
//            return generalResultMap;
//        }
//
//        //签名加密检验
//        result = validateSign(request);
//        if (StringUtils.isNotBlank(result)) {
//            generalResultMap.setResult(SysReturnCode.FAIL, result);
//            log.error("【用户的签名验证】加密方式不对result=｛｝", request);
//            return generalResultMap;
//        }

        return generalResultMap;
    }

    /**
     * 页面请求时间验证<防止重复请求></>
     *
     * @param timestamp 页面传过来的时间戳
     * @return 返回 ""
     */
    private String validateTimestamp(long timestamp) {

        String result = "";
        if (timestamp <= 0) {
            result = "timestamp不能为空";
            return result;
        }

        long currTimestamp = System.currentTimeMillis();

        long expiryTime = 20000;
        int time = 1000;
        if ((currTimestamp - timestamp) / time > expiryTime) {
            result = "该请求超过10秒，做无效处理";
        }

        return result;
    }

    /**
     * 页面商户号检验.
     *
     * @param merchantNo 商户号
     * @return 商户号判断合法返回为""
     */
    private String validateMerchantNo(String merchantNo) {
        String result = "";

        if (StringUtils.isBlank(merchantNo)) {
            result = "商户号不能为空";
            log.error("【用户的签名验证】merchantNo为空");
            return result;
        }

        Merchant merchant = merchantService.queryByAccount(merchantNo);
        if (merchant == null) {
            result = "没有该商户或该商户未审核通过,merchantNo:" + merchantNo;
        }

        return result;
    }


    /**
     * 签名验证
     *
     * @param request 页面请求
     * @return 用户的签名的检验
     */
    private String validateSign(BaseRequest request) {

        String result = "";
        if (StringUtils.isBlank(request.getSign())) {
            result = "签名不能为空";
            return result;
        }

        SortedMap<String, Object> sortedMap = getSortedMap(request);
        String data = getSignData(sortedMap);
        Merchant merchant = merchantService.queryByAccount(request.getMerchantNo());

        String newSign = Md5Util.encrypt(data + merchant.getSecretKey());
        if (newSign != null && !newSign.equalsIgnoreCase(request.getSign())) {
            result = "签名不正确,merchantNo:" + request.getMerchantNo();
        }
        return result;
    }

    /**
     * @param sortedMap 时间戳,商户号的map.
     * @return 商户号+请求时间戳
     */
    private String getSignData(SortedMap<String, Object> sortedMap) {

        StringBuilder sb = new StringBuilder(sortedMap.size() * 10);

        Set<Map.Entry<String, Object>> entrySet = sortedMap.entrySet();

        for (Map.Entry<String, Object> entry : entrySet) {
            if (entry.getValue() != null) {
                sb.append(entry.getValue());
            }
        }

        return sb.toString();
    }

    /**
     * @param request 页面请求对象
     * @return 用户的商户号，请求的时间戳放在一个有序的集合中返回
     */
    private SortedMap<String, Object> getSortedMap(BaseRequest request) {

        SortedMap<String, Object> fieldNames = new TreeMap<>();
        if (request == null) {
            return fieldNames;
        }

        try {
            //获取此类中的所有字段
            Field[] fields = request.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (!"serialVersionUID".equals(field.getName()) && !"passengers".equals(field.getName())) {
                    field.setAccessible(true);
                    fieldNames.put(field.getName(), field.get(request));
                }
            }

            fieldNames.put("merchantNo", request.getMerchantNo());
            fieldNames.put("timestamp", request.getTimestamp());
        } catch (Exception e) {
            fieldNames.clear();
            log.error("设置SortedMap异常,request:{}", request, e);
        }
        return fieldNames;
    }
}