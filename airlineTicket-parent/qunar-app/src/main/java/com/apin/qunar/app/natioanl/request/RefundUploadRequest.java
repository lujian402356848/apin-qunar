package com.apin.qunar.app.natioanl.request;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by l on 17-8-29.
 */
@Data
public class RefundUploadRequest {
    private MultipartFile file;
    private String orderNo;
    private String passengerIds;
}
