package com.apin.qunar.app.international.request;

import com.apin.qunar.app.common.domain.BaseRequest;
import com.apin.qunar.order.domain.international.createOrder.Contact;
import com.apin.qunar.order.domain.international.createOrder.Passenger;
import com.apin.qunar.order.domain.international.createOrder.Xcd;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-22 21:04
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NtsCreateOrderRequest extends BaseRequest {
    @NotEmpty(message = "bookingTagKey不能为空")
    private String bookingTagKey;
    private List<Passenger> passengerList;
    private Contact contact;
    private Xcd xcd;
    @NotEmpty(message = "account不能为空")
    private String account;
}
