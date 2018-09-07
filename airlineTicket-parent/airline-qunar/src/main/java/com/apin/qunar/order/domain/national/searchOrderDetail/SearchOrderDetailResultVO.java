package com.apin.qunar.order.domain.national.searchOrderDetail;

import lombok.Data;

import java.util.List;

@Data
public class SearchOrderDetailResultVO {
    /**
     * 订单明细
     */
    private OrderDetail detail;
    private Xcd xcd;
    private Other other;
    private ContacterInfo contacterInfo;
    private List<Passenger> passengers;
    private List<FlightInfo> flightInfo;
    private List<PassengerType> passengerTypes;

    @Data
    public class OrderDetail {
        private String clientSite;
        private long orderId;
        private String orderNo;
        private String status;
        private String pnr;
        private String siblingOrderNo;
        private String siblingOrderStatus;
        private String orderSelfStatus;
        private String parentOrderStatus;
        private String parentOrderNo;
        private String agentLastTicketTime;
        private CashBack cashBack;
        private boolean codeShare;

        @Data
        public class CashBack {
            private String cashBackTiime;
            private int cashBackStatus;
            private int cashBackPriceSum;
            private int cashBackPrice;
            private String endorseTime;
            private String endorsePrice;
        }
    }

    @Data
    public static class Xcd {
        private String company;
        private String orderNumber;
        private String sjr;
        private String address;
        private String isPosted;
        private String sendtime;
    }

    @Data
    public static class Other {
        /**
         * 退改签信息节点
         */
        private String tgqMsg;
    }

    @Data
    public static class ContacterInfo {
        private String email;
        private String name;
        private String telephone;
        private String mobile;
    }

    @Data
    public static class Passenger {
        private String name;
        private String type;
        private String cardNum;
        private String cardType;
        private String insuranceNo;
        private String ticketNo;
        private int gender;//ui需要
        private String mobileNo;//ui需要
        private String birthday;//出生年月(yyyy-MM-dd) ui需要
    }

    @Data
    public static class FlightInfo {
        private String dptCity;
        private String dptAirportCode;
        private String arrCity;
        private String arrAirportCode;
        private String deptTime;
        private String flightNum;
        private String cabin;
        private String flightTime;//ui需要
        private String carrierCode;//ui需要
        private String carrierName;//ui需要
        private boolean hasStop;//ui需要
        private String dptAirportName;//ui需要
        private String arrAirportName;//ui需要
        private String dptTerminal;//ui需要
        private String arrTerminal;//ui需要
        private String deptDate;//ui需要
        private String arrTime;//ui需要
        private int returnFee;//ui需要
        private String returnText;//ui需要
        private int changeFee;//ui需要
        private String changeText;//ui需要
        private String actFlightNum;//ui需要
        private String tag;
        private String searchDptAirportCode;//ui需要
        private String searchArrAirportCode;//ui需要
    }

    @Data
    public static class PassengerType {
        private String ageType;
        private int insurance;
        private int insuranceCount;
        private int printPrice;
        private int realPrice;
        private int constructionFee;
        private int fuelTax;
        private int allPrices;
        private int refundPrices;
    }
}
