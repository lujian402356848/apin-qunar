package com.apin.qunar.order.domain.national.booking;

import java.io.Serializable;

/**
 * Created by stanley on 15-11-20 At 11:42
 */
public class BookingFlightInfo implements Serializable {
    private static final long serialVersionUID = 7631365763477467714L;
    /**
     * 起飞城市
     */
    private String dptCity = "";
    /**
     * 到达城市
     */
    private String arrCity = "";
    /**
     * 起飞机场三字码
     */
    private String dpt = "";
    /**
     * 到达机场三字码
     */
    private String arr = "";
    /**
     * 起飞机场名
     */
    private String dptAirport = "";
    /**
     * 到达机场名
     */
    private String arrAirport = "";
    /**
     * 起飞机场航站楼
     */
    private String dptTerminal = "";
    /**
     * 到达机场航站楼
     */
    private String arrTerminal = "";
    /**
     * 起飞时间
     */
    private String dptTime = "";
    /**
     * 到达时间
     */
    private String arrTime = "";
    /**
     * 起飞日期
     */
    private String dptDate = "";
    /**
     * 到达日期
     */
    private String arrDate = "";
    /**
     * 起飞航班号
     */
    private String flightNum = "";
    /**
     * 航司名
     */
    private String carrierName = "";
    /**
     * 舱位
     */
    private String cabin = "";
    /**
     * 航司二字码
     */
    private String carrier = "";
    /**
     * 经停次数
     */
    private int stops;
    /**
     * 是否共享
     */
    private boolean codeShare;
    /**
     * 儿童舱位
     */
    private String childCabin = "";
    /**
     * 婴儿舱位
     */
    private String babyCabin = "";
    /**
     * 燃油
     */
    private String tof;
    /**
     * 机建
     */
    private String arf;
    /**
     * 儿童燃油
     */
    private String ctof;
    /**
     * 主飞航班
     */
    private String actFlightNum = "";
    /**
     * 成人舱位中文
     */
    private String cbcn = "";
    /**
     * 儿童舱位中文
     */
    private String ccbcn = "";
    /**
     * 婴儿舱位中文
     */
    private String bcbcn = "";
    /**
     * 经停机场三字码
     */
    private String stopAirport = "";
    /**
     * 经停城市
     */
    private String stopCity = "";
    /**
     * 主飞航司二字码
     */
    private String actCarrier = "";
    /**
     * 主飞航司名
     */
    private String actCarrierName = "";
    /**
     * 主飞机型
     */
    private String actPlaneType = "";
    /**
     * 机型代码
     */
    private String planeCode = "";
    /**
     * 飞行时间
     */
    private String flightTimes = "";

    public String getDptCity() {
        return dptCity;
    }

    public void setDptCity(String dptCity) {
        this.dptCity = dptCity;
    }

    public String getArrCity() {
        return arrCity;
    }

    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
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

    public String getDptAirport() {
        return dptAirport;
    }

    public void setDptAirport(String dptAirport) {
        this.dptAirport = dptAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public String getDptTerminal() {
        return dptTerminal;
    }

    public void setDptTerminal(String dptTerminal) {
        this.dptTerminal = dptTerminal;
    }

    public String getArrTerminal() {
        return arrTerminal;
    }

    public void setArrTerminal(String arrTerminal) {
        this.arrTerminal = arrTerminal;
    }

    public String getDptTime() {
        return dptTime;
    }

    public void setDptTime(String dptTime) {
        this.dptTime = dptTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public String getDptDate() {
        return dptDate;
    }

    public void setDptDate(String dptDate) {
        this.dptDate = dptDate;
    }

    public String getArrDate() {
        return arrDate;
    }

    public void setArrDate(String arrDate) {
        this.arrDate = arrDate;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(String flightNum) {
        this.flightNum = flightNum;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getCabin() {
        return cabin;
    }

    public void setCabin(String cabin) {
        this.cabin = cabin;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public int getStops() {
        return stops;
    }

    public void setStops(int stops) {
        this.stops = stops;
    }

    public boolean isCodeShare() {
        return codeShare;
    }

    public void setCodeShare(boolean codeShare) {
        this.codeShare = codeShare;
    }

    public String getChildCabin() {
        return childCabin;
    }

    public void setChildCabin(String childCabin) {
        this.childCabin = childCabin;
    }

    public String getBabyCabin() {
        return babyCabin;
    }

    public void setBabyCabin(String babyCabin) {
        this.babyCabin = babyCabin;
    }

    public String getTof() {
        return tof;
    }

    public void setTof(String tof) {
        this.tof = tof;
    }

    public String getArf() {
        return arf;
    }

    public void setArf(String arf) {
        this.arf = arf;
    }

    public String getCtof() {
        return ctof;
    }

    public void setCtof(String ctof) {
        this.ctof = ctof;
    }

    public String getActFlightNum() {
        return actFlightNum;
    }

    public void setActFlightNum(String actFlightNum) {
        this.actFlightNum = actFlightNum;
    }

    public String getCbcn() {
        return cbcn;
    }

    public void setCbcn(String cbcn) {
        this.cbcn = cbcn;
    }

    public String getCcbcn() {
        return ccbcn;
    }

    public void setCcbcn(String ccbcn) {
        this.ccbcn = ccbcn;
    }

    public String getBcbcn() {
        return bcbcn;
    }

    public void setBcbcn(String bcbcn) {
        this.bcbcn = bcbcn;
    }

    public String getStopAirport() {
        return stopAirport;
    }

    public void setStopAirport(String stopAirport) {
        this.stopAirport = stopAirport;
    }

    public String getStopCity() {
        return stopCity;
    }

    public void setStopCity(String stopCity) {
        this.stopCity = stopCity;
    }

    public String getActCarrier() {
        return actCarrier;
    }

    public void setActCarrier(String actCarrier) {
        this.actCarrier = actCarrier;
    }

    public String getActCarrierName() {
        return actCarrierName;
    }

    public void setActCarrierName(String actCarrierName) {
        this.actCarrierName = actCarrierName;
    }

    public String getActPlaneType() {
        return actPlaneType;
    }

    public void setActPlaneType(String actPlaneType) {
        this.actPlaneType = actPlaneType;
    }

    public String getPlaneCode() {
        return planeCode;
    }

    public void setPlaneCode(String planeCode) {
        this.planeCode = planeCode;
    }

    public String getFlightTimes() {
        return flightTimes;
    }

    public void setFlightTimes(String flightTimes) {
        this.flightTimes = flightTimes;
    }

    @Override
    public String toString() {
        return "BookingFlightInfo{" +
                "dptCity='" + dptCity + '\'' +
                ", arrCity='" + arrCity + '\'' +
                ", dpt='" + dpt + '\'' +
                ", arr='" + arr + '\'' +
                ", dptAirport='" + dptAirport + '\'' +
                ", arrAirport='" + arrAirport + '\'' +
                ", dptTerminal='" + dptTerminal + '\'' +
                ", arrTerminal='" + arrTerminal + '\'' +
                ", dptTime='" + dptTime + '\'' +
                ", arrTime='" + arrTime + '\'' +
                ", dptDate='" + dptDate + '\'' +
                ", arrDate='" + arrDate + '\'' +
                ", flightNum='" + flightNum + '\'' +
                ", carrierName='" + carrierName + '\'' +
                ", cabin='" + cabin + '\'' +
                ", carrier='" + carrier + '\'' +
                ", stops=" + stops +
                ", codeShare=" + codeShare +
                ", childCabin='" + childCabin + '\'' +
                ", babyCabin='" + babyCabin + '\'' +
                ", tof='" + tof + '\'' +
                ", arf='" + arf + '\'' +
                ", ctof='" + ctof + '\'' +
                ", actFlightNum='" + actFlightNum + '\'' +
                ", cbcn='" + cbcn + '\'' +
                ", ccbcn='" + ccbcn + '\'' +
                ", bcbcn='" + bcbcn + '\'' +
                ", stopAirport='" + stopAirport + '\'' +
                ", stopCity='" + stopCity + '\'' +
                ", actCarrier='" + actCarrier + '\'' +
                ", actCarrierName='" + actCarrierName + '\'' +
                ", actPlaneType='" + actPlaneType + '\'' +
                ", planeCode='" + planeCode + '\'' +
                ", flightTimes='" + flightTimes + '\'' +
                '}';
    }
}
