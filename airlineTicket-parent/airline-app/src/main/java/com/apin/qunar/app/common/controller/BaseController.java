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
    protected GeneralResultMap validateCommonParam(BaseRequest request) {
        GeneralResultMap generalResultMap = new GeneralResultMap();
        return generalResultMap;
    }
}