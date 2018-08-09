package com.apin.qunar.order.domain.international.searchOrderDetail;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-25 14:31
 */
@Data
public class NtsSearchOrderDetailResultVO {
    private String orderNo;
    private String createTime;
    private String orderStatus;//ui需要，因此调整为string
    private ContactInfo contactInfo;
    private List<PayInfo> payInfo;
    private FlightInfo flightInfo;
    private List<Passenger> passengerInfo;
    private XcdInfo xcdInfo;
    private ExtInfo extInfo;
    private String totalPrice;//ui需要,票面总价
    private String payDeadline;//ui需要,支付时限

    @Data
    public static class ContactInfo {
        private String email;
        private String name;
        private String telephone;
        private String mobile;
    }

    @Data
    public static class PayInfo {
        private String transactionId;
        private String price;
    }

    @Data
    public static class FlightInfo {
        private PriceInfo priceInfo;
        private Tgq tgqRule;
        private List<Segment> segments;
        private int returnFee;//ui需要
        private String returnText;//ui需要
        private int changeFee;//ui需要
        private String changeText;//ui需要
        private String packName;
    }

    @JsonIgnoreProperties({"eticketNum"})
    @Data
    public static class Passenger {
        @JsonProperty("eTicketNum")
        private String eTicketNum;
        private String ticketType;
        private String name;
        private String gender;
        private String birthDay;
        private String nationality;
        private String cardType;
        private String cardNum;
        private String cardIssuePlace;
        private String pnr;
        private String productNo;
        private String cardExpired;//ui需要
    }

    @Data
    public static class XcdInfo {
        private String addressReminder;
        private String province;
        private String city;
        private String district;
        private String addressee;
        private String receiptTitle;
        private String receiptTitleType;
        private String requestType;
        private String mobile;
        private String expressFee;
    }

    @Data
    public static class ExtInfo {
        private Long lastTimeForUser;
    }

    /**
     * 这个类的cPrice和cTax属性不能用Data标签，输出的参数名称会变，导致无法赋值
     */
    public static class PriceInfo {
        private String price;
        private String tax;
        private String cPrice;
        private String cTax;

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getTax() {
            return tax;
        }

        public void setTax(String tax) {
            this.tax = tax;
        }

        public String getcPrice() {
            return cPrice;
        }

        public void setcPrice(String cPrice) {
            this.cPrice = cPrice;
        }

        public String getcTax() {
            return cTax;
        }

        public void setcTax(String cTax) {
            this.cTax = cTax;
        }
    }

    @Data
    public static class Tgq {
        private String refund;
        private String change;
        private String baggage;
        private String other;
    }

    @Data
    public static class Segment {
        private String carrier;
        private String flightNumber;
        private String cabin;
        private String depAirport;
        private String departureDate;
        private String departureTime;
        private String arrAirport;
        private String arrivalDate;
        private String arrivalTime;
        private String issueTicketChannel;

        private String flightTime;//ui需要
        private String actFlightNum;//ui需要
        private String carrierCode;//ui需要
        private String carrierName;//ui需要
        private boolean hasStop;//ui需要
        private String dptAirportName;//ui需要
        private String arrAirportName;//ui需要
        private String dptTerminal;//ui需要
        private String arrTerminal;//ui需要
        private String deptDate;//ui需要
        private String arrTime;//ui需要
    }
}
