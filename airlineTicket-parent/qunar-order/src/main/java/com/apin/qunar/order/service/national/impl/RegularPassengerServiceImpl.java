package com.apin.qunar.order.service.national.impl;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.NationalRegularPassengerDaoImpl;
import com.apin.qunar.order.dao.model.NationalRegularPassenger;
import com.apin.qunar.order.domain.national.regularPassenger.RegularPassengerBO;
import com.apin.qunar.order.domain.national.regularPassenger.RegularPassengerVO;
import com.apin.qunar.order.service.national.RegularPassengerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @outhor ligang
 * @create 2018-08-07 11:51
 * 国内常旅客管理
 */
@Slf4j
@Service
public class RegularPassengerServiceImpl implements RegularPassengerService {
    @Autowired
    private NationalRegularPassengerDaoImpl regularPassengerDao;

    @Override
    public ExecuteResult create(RegularPassengerBO regularPassengerBO) {
        ExecuteResult result = new ExecuteResult();
        boolean isExist = regularPassengerDao.isExistCardNo(regularPassengerBO.getCardNo());
        if (isExist) {
            result.setDesc("该用户证件号已存在，请核对后重新输入");
            return result;
        }
        NationalRegularPassenger passenger = buildRegularPassenger(regularPassengerBO);
        try {
            boolean insertResult = regularPassengerDao.insert(passenger);
            result.setSuccess(insertResult);
        } catch (Exception e) {
            log.error("创建常用联系人异常,param:{}", regularPassengerBO, e);
        }
        return result;
    }

    private NationalRegularPassenger buildRegularPassenger(RegularPassengerBO regularPassengerBO) {
        NationalRegularPassenger regularPassenger = new NationalRegularPassenger();
        regularPassenger.setId(IDGenerator.getUniqueId());
        regularPassenger.setAgeType(regularPassengerBO.getAgeType());
        regularPassenger.setBirthday(regularPassengerBO.getBirthday());
        regularPassenger.setCardNo(regularPassengerBO.getCardNo());
        regularPassenger.setCardType(regularPassengerBO.getCardType());
        regularPassenger.setGender(regularPassengerBO.getGender());
        regularPassenger.setMobileNo(regularPassengerBO.getMobileNo());
        regularPassenger.setName(regularPassengerBO.getName());
        regularPassenger.setOperator(regularPassengerBO.getOperator());
        return regularPassenger;
    }

    @Override
    public boolean change(RegularPassengerBO regularPassengerBO) {
        NationalRegularPassenger passenger = buildRegularPassenger(regularPassengerBO);
        passenger.setId(regularPassengerBO.getId());
        return regularPassengerDao.update(passenger);
    }

    @Override
    public boolean delete(Long id) {
        return regularPassengerDao.deletePassenger(id);
    }

    @Override
    public List<RegularPassengerVO> queryPageListBy(String account, String name, Integer offset, Integer limit) {
        List<NationalRegularPassenger> regularPassengers = regularPassengerDao.queryPageListBy(account, name, offset, limit);
        List<RegularPassengerVO> regularPassengerVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(regularPassengers)) {
            return regularPassengerVOS;
        }
        RegularPassengerVO regularPassengerVO = null;
        for (NationalRegularPassenger regularPassenger : regularPassengers) {
            regularPassengerVO = BeanUtil.copyProperties(regularPassenger, RegularPassengerVO.class);
            regularPassengerVO.setId(regularPassenger.getId().toString());
            String[] nameList = regularPassenger.getName().split("/");
            if (nameList.length > 1) {
                regularPassengerVO.setFirstName(nameList[0]);
                regularPassengerVO.setLastName(nameList[1]);
            }
            regularPassengerVOS.add(regularPassengerVO);
        }
        return regularPassengerVOS;
    }

    @Override
    public Integer queryCount(final String account, final String name) {
        return regularPassengerDao.queryCount(account, name);
    }
}
