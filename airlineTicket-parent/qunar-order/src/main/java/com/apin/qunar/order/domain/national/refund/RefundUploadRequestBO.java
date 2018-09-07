package com.apin.qunar.order.domain.national.refund;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by l on 17-8-29.
 */
@Data
public class RefundUploadRequestBO {
    private MultipartFile file;
    private String orderNo;
    private String passengerIds;
}
