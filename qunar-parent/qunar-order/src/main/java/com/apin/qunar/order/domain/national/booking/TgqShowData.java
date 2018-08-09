package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;
import java.util.List;

/**
 * Created by deli.shen on 15-11-27 At 18:19
 */
public class TgqShowData implements Serializable {
    private static final long serialVersionUID = -3397675061286986282L;
    /**
     * 所有时间点的退改签费用
     */
    private List<TgqPointCharge> tgqPointCharges;
    /**
     * 退改签匹配类型
     */
    private int tgqFrom;

    /**
     * 退票规则
     */
    private String returnRule = "";

    /**
     * 改签规则
     */
    private String changeRule = "";

    /**
     * 是否允许改签
     */
    private boolean allowChange;

    /**
     * 是否允许签转
     */
    private boolean canCharge;

    /**
     * 是否允许退票
     */
    private boolean canRefund;

    /**
     * 退改签文本
     */
    private String tgqText = "";

    /**
     * 儿童退改签文本
     */
    private String childTgqText = "";

    /**
     * 是否执行航司退改签规则
     */
    private boolean airlineTgq;

    /**
     * 是否允许签转文本.
     */
    private String signText;

    /**
     * 是否有变价时间点. true：有,false：无
     */
    private boolean hasTime = false;

    /**
     * 计算退改签的基准价.
     */
    private float basePrice;

    /**
     * 退改签计价仓位
     *
     * @return
     */
    private String tgqCabin;

    /**
     * 退改签显示类型. 默认显示文本
     */
    private int viewType = 2;

    /**
     * 退改签百分比文本
     *
     * @return
     */
    private String tgqPercentText;

    /**
     * 退改签匹配到的产品
     */
    private String tgqProduct;

    /**
     * 退票文本.
     */
    private String returnText;

    /**
     * 改签文本.
     */
    private String changeText;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {

        this.viewType = viewType;
    }

    public void setSignText(String signText) {
        this.signText = signText;
    }

    public void setHasTime(boolean hasTime) {
        this.hasTime = hasTime;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }

    public void setTgqCabin(String tgqCabin) {
        this.tgqCabin = tgqCabin;
    }

    public void setTgqProduct(String tgqProduct) {
        this.tgqProduct = tgqProduct;
    }

    public void setReturnText(String returnText) {
        this.returnText = returnText;
    }

    public void setChangeText(String changeText) {
        this.changeText = changeText;
    }

    public void setTgqPercentText(String tgqPercentText) {
        this.tgqPercentText = tgqPercentText;
    }

    public String getSignText() {
        return signText;
    }

    public boolean isHasTime() {
        return hasTime;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public String getTgqCabin() {
        return tgqCabin;
    }

    public String getTgqProduct() {
        return tgqProduct;
    }

    public String getTgqPercentText() {
        return tgqPercentText;
    }

    public String getReturnText() {
        return returnText;
    }

    public String getChangeText() {
        return changeText;
    }

    public List<TgqPointCharge> getTgqPointCharges() {
        return tgqPointCharges;
    }

    public void setTgqPointCharges(List<TgqPointCharge> tgqPointCharges) {
        this.tgqPointCharges = tgqPointCharges;
    }

    public int getTgqFrom() {
        return tgqFrom;
    }

    public void setTgqFrom(int tgqFrom) {
        this.tgqFrom = tgqFrom;
    }

    public String getReturnRule() {
        return returnRule;
    }

    public void setReturnRule(String returnRule) {
        this.returnRule = returnRule;
    }

    public String getChangeRule() {
        return changeRule;
    }

    public void setChangeRule(String changeRule) {
        this.changeRule = changeRule;
    }

    public boolean isAllowChange() {
        return allowChange;
    }

    public void setAllowChange(boolean allowChange) {
        this.allowChange = allowChange;
    }

    public boolean isCanCharge() {
        return canCharge;
    }

    public void setCanCharge(boolean canCharge) {
        this.canCharge = canCharge;
    }

    public boolean isCanRefund() {
        return canRefund;
    }

    public void setCanRefund(boolean canRefund) {
        this.canRefund = canRefund;
    }

    public String getTgqText() {
        return tgqText;
    }

    public void setTgqText(String tgqText) {
        this.tgqText = tgqText;
    }

    public String getChildTgqText() {
        return childTgqText;
    }

    public void setChildTgqText(String childTgqText) {
        this.childTgqText = childTgqText;
    }

    public boolean isAirlineTgq() {
        return airlineTgq;
    }

    public void setAirlineTgq(boolean airlineTgq) {
        this.airlineTgq = airlineTgq;
    }

    @Override
    public String toString() {
        return "TgqShowData{" + "tgqPointCharges=" + tgqPointCharges + ", tgqFrom=" + tgqFrom + ", returnRule='"
                + returnRule + '\'' + ", changeRule='" + changeRule + '\'' + ", allowChange=" + allowChange
                + ", canCharge=" + canCharge + ", canRefund=" + canRefund + ", tgqText='" + tgqText + '\''
                + ", childTgqText='" + childTgqText + '\'' + ", airlineTgq=" + airlineTgq + '}';
    }
}
