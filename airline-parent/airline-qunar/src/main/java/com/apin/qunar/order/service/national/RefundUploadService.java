package com.apin.qunar.order.service.national;


import com.apin.qunar.order.domain.national.refund.RefundUploadRequestBO;

/**
 * @outhor lujian
 * @create 2018-07-02 11:08
 */
public interface RefundUploadService {
    String upload(final RefundUploadRequestBO refundUploadRequest);
}
