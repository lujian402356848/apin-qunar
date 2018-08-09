package com.apin.qunar.order.service.international.impl;

import com.apin.qunar.basic.domain.ExecuteResult;
import com.apin.qunar.common.ids.IDGenerator;
import com.apin.qunar.common.utils.BeanUtil;
import com.apin.qunar.order.dao.impl.InternationalRegularPassengerDaoImpl;
import com.apin.qunar.order.dao.model.InternationalRegularPassenger;
import com.apin.qunar.order.domain.international.regularPassenger.NtsRegularPassengerBO;
import com.apin.qunar.order.domain.international.regularPassenger.NtsRegularPassengerVO;
import com.apin.qunar.order.service.international.NtsRegularPassengerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor ligang
 * @create 2018-08-07 09:51
 * 国内常旅客管理
 */
@Slf4j
@Service
public class NtsRegularPassengerServiceImpl implements NtsRegularPassengerService {
    @Autowired
    private InternationalRegularPassengerDaoImpl internationalRegularPassengerDao;

    @Override
    public ExecuteResult create(NtsRegularPassengerBO ntsRegularPassengerBO) {
        ExecuteResult result = new ExecuteResult();
        boolean isExist = internationalRegularPassengerDao.isExistCardNo(ntsRegularPassengerBO.getCardNo());
        if (isExist) {
            result.setDesc("该用户证件号已存在，请核对后重新输入");
            return result;
        }
        InternationalRegularPassenger passenger = buildRegularPassenger(ntsRegularPassengerBO);
        try {
            boolean insertResult = internationalRegularPassengerDao.insert(passenger);
            result.setSuccess(insertResult);
        } catch (Exception e) {
            log.error("创建常用联系人异常,param:{}", ntsRegularPassengerBO, e);
        }
        return result;
    }

    private InternationalRegularPassenger buildRegularPassenger(NtsRegularPassengerBO ntsRegularPassengerBO) {
        InternationalRegularPassenger ntsRegularPassenger = new InternationalRegularPassenger();
        ntsRegularPassenger.setId(IDGenerator.getUniqueId());
        ntsRegularPassenger.setAgeType(ntsRegularPassengerBO.getAgeType());
        ntsRegularPassenger.setBirthday(ntsRegularPassengerBO.getBirthday());
        ntsRegularPassenger.setCardNo(ntsRegularPassengerBO.getCardNo());
        ntsRegularPassenger.setCardType(ntsRegularPassengerBO.getCardType());
        ntsRegularPassenger.setGender(ntsRegularPassengerBO.getGender());
        ntsRegularPassenger.setMobileNo(ntsRegularPassengerBO.getMobileNo());
        ntsRegularPassenger.setName(ntsRegularPassengerBO.getName());
        ntsRegularPassenger.setCardExpired(ntsRegularPassengerBO.getCardExpired());
        ntsRegularPassenger.setCardIssueplace(ntsRegularPassengerBO.getCardIssuePlace());
        ntsRegularPassenger.setNationality(ntsRegularPassengerBO.getNationality());
        ntsRegularPassenger.setOperator(ntsRegularPassengerBO.getOperator());
        return ntsRegularPassenger;
    }

    @Override
    public boolean change(NtsRegularPassengerBO ntsRegularPassengerBO) {
        InternationalRegularPassenger ntsRegularPassenger = buildRegularPassenger(ntsRegularPassengerBO);
        ntsRegularPassenger.setId(ntsRegularPassengerBO.getId());
        return internationalRegularPassengerDao.update(ntsRegularPassenger);
    }

    @Override
    public boolean remove(Long id) {
        return internationalRegularPassengerDao.deletePassenger(id);
    }

    @Override
    public List<NtsRegularPassengerVO> queryPageListBy(String account, String name, Integer offset, Integer limit) {
        List<InternationalRegularPassenger> regularPassengers = internationalRegularPassengerDao.queryPageListBy(account, name, offset, limit);
        List<NtsRegularPassengerVO> ntsRegularPassengerVOS = new ArrayList<>();
        if (CollectionUtils.isEmpty(regularPassengers)) {
            return ntsRegularPassengerVOS;
        }
        NtsRegularPassengerVO ntsRegularPassengerVO = null;
        for (InternationalRegularPassenger regularPassenger : regularPassengers) {
            ntsRegularPassengerVO = BeanUtil.copyProperties(regularPassenger, NtsRegularPassengerVO.class);
            ntsRegularPassengerVO.setId(regularPassenger.getId().toString());
            String[] nameList = regularPassenger.getName().split("/");
            ntsRegularPassengerVO.setFirstName(nameList[0]);
            ntsRegularPassengerVO.setLastName(nameList[1]);
            ntsRegularPassengerVO.setGender(regularPassenger.getGender() == 0 ? "M" : "F");
            ntsRegularPassengerVOS.add(ntsRegularPassengerVO);
        }
        return ntsRegularPassengerVOS;
    }
}
