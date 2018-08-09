package com.apin.qunar.app.natioanl.controller;

import com.apin.qunar.app.common.constant.AppConstants;
import com.apin.qunar.app.common.controller.BaseController;
import com.apin.qunar.app.natioanl.request.RefundUploadRequest;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.domain.national.refund.RefundUploadRequestBO;
import com.apin.qunar.order.service.national.RefundUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @outhor lujian
 * @create 2018-06-27 16:34
 * 退款上传证件
 */
@RestController
@RequestMapping((AppConstants.ROOT_URL))
public class RefundUploadController extends BaseController {
    @Autowired
    private RefundUploadService refundUploadService;

    @PostMapping(value = "/order/refundUpload")
    public String uploadPage() {
        return "refundUpload";
    }

    @PostMapping(value = "/refundUpload", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String upload(RefundUploadRequest refundUploadRequest) {
        RefundUploadRequestBO refundUploadRequestBO = BeanUtil.copyProperties(refundUploadRequest, RefundUploadRequestBO.class);
        return refundUploadService.upload(refundUploadRequestBO);
    }
}
