package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.common.constant.Constants;
import com.apin.qunar.order.domain.national.refund.RefundUploadRequestBO;
import com.apin.qunar.order.service.national.RefundUploadService;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

;

/**
 * Created by wangliang.wang on 2018/6/8.
 */
@Slf4j
@Service
public class RefundUploadServiceImpl implements RefundUploadService {

    private final String TAG = "flight.national.supply.sl.tpUpload";
    private final Joiner.MapJoiner MAP_JOINER = Joiner.on("&").withKeyValueSeparator("=");
    private static final CloseableHttpClient HTTP_CLIENT = HttpClients.createDefault();

    @Autowired
    private RequestServiceImpl requestService;

    @Override
    public String upload(final RefundUploadRequestBO refundUploadRequest) {
        return doPost(refundUploadRequest);
    }

    private String doPost(RefundUploadRequestBO refundUploadRequest) {
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            // 创建Http Post请求
            String url = buildUrl(refundUploadRequest);
            Preconditions.checkState(StringUtils.isNotBlank(url));
            HttpPost httpPost = new HttpPost(url);
            HttpEntity httpEntity = buildHttpEntity(refundUploadRequest);
            Preconditions.checkNotNull(httpEntity);
            httpPost.setEntity(httpEntity);
            // 执行http请求
            response = HTTP_CLIENT.execute(httpPost);
            resultString = EntityUtils.toString(response.getEntity(), "utf-8");
        } catch (Exception e) {
            log.error("发起post请求失败", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                log.error("关闭Response失败", e);
            }
        }
        return resultString;
    }

    private String buildUrl(RefundUploadRequestBO refundUploadRequest) {
        try {
            //直接将orderNo和passengerIds放到url后面
            StringBuilder urlBuilder = new StringBuilder(Constants.BASE_URL);
            Map<String, String> paramsMap = requestService.buildParamMap(TAG, "{}");
            urlBuilder.append(MAP_JOINER.join(paramsMap));

            urlBuilder.append("&orderNo=")
                    .append(refundUploadRequest.getOrderNo())
                    .append("&passengerIds=")
                    .append(refundUploadRequest.getPassengerIds());
            return urlBuilder.toString();
        } catch (Exception e) {
            log.error("build url error", e);
        }

        return null;
    }

    private HttpEntity buildHttpEntity(RefundUploadRequestBO refundUploadRequest) {
        try {
            MultipartEntityBuilder builder = MultipartEntityBuilder.create();
            // 上传的文件
            builder.addBinaryBody("file", refundUploadRequest.getFile().getInputStream(), ContentType.create("image/*"), refundUploadRequest.getFile().getOriginalFilename());
            return builder.build();
        } catch (Exception e) {
            log.error("build http entity error", e);
        }
        return null;
    }
}
