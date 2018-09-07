package com.apin.qunar.order.domain.national.searchRefundChangeSign;

import lombok.Data;

import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-27 17:18
 */
@Data
public class SearchRefundChangeSignResult {
    private List<TgqPointCharge> tgqPointCharges;
    private int tgqForm;
    private String returnRule;
    private boolean allowChange;
    private boolean canCharge;
    private boolean canrefund;
    private String tgqText;
    private String childTgqtext;
    private boolean airlineTgq;
    private String signText;
    private boolean hasTime;
    private float basePrice;
    private String tgqCabin;
    private int viewType;
    private String tgqPercentText;
    private String tgqProduct;
    private String returnText;
    private String changeText;
    private String changeRule;

    @Data
    public static class TgqPointCharge{
        private int time;
        private String timeText;
        private int returnFee;
        private int changeFee;
    }
}
