package com.apin.qunar.order.service.common;

import com.apin.qunar.order.domain.common.sign.SignParam;

public interface SignService {
    String sign(SignParam signParam);
}
