package com.apin.qunar.order.domain.national.searchRefundChangeSign;

/**
 * @outhor lujian
 * @create 2018-06-27 17:14
 */
public class SearchRefundChangeSignParam {
    private String flightNum;
    private String cabin;
    private String dpt;
    private String arr;
    private String dptDate;
    private String dptTime;
    private long policyId;
    private float maxSellPrice;
    private float minSellPrice;
    private float printPrice;
    private String tagName;
    private boolean translate;
    private int sfid;
    private boolean needPercentTgqText;
    private String businessExt;
    private String client;

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getDpt() {
        return dpt;
    }

    public void setDpt(String dpt) {
        this.dpt = dpt;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getDptDate() {
        return dptDate;
    }

    public void setDptDate(String dptDate) {
        this.dptDate = dptDate;
    }

    public String getDptTime() {
        return dptTime;
    }

    public void setDptTime(String dptTime) {
        this.dptTime = dptTime;
    }

    public long getPolicyId() {
        return policyId;
    }

    public void setPolicyId(long policyId) {
        this.policyId = policyId;
    }

    public float getMaxSellPrice() {
        return maxSellPrice;
    }

    public void setMaxSellPrice(float maxSellPrice) {
        this.maxSellPrice = maxSellPrice;
    }

    public float getMinSellPrice() {
        return minSellPrice;
    }

    public void setMinSellPrice(float minSellPrice) {
        this.minSellPrice = minSellPrice;
    }

    public float getPrintPrice() {
        return printPrice;
    }

    public void setPrintPrice(float printPrice) {
        this.printPrice = printPrice;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public boolean getTranslate() {
        return translate;
    }

    public void setTranslate(boolean translate) {
        this.translate = translate;
    }

    public int getSfid() {
        return sfid;
    }

    public void setSfid(int sfid) {
        this.sfid = sfid;
    }

    public boolean getNeedPercentTgqText() {
        return needPercentTgqText;
    }

    public void setNeedPercentTgqText(boolean needPercentTgqText) {
        this.needPercentTgqText = needPercentTgqText;
    }

    public String getBusinessExt() {
        return businessExt;
    }

    public void setBusinessExt(String businessExt) {
        this.businessExt = businessExt;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }
}
