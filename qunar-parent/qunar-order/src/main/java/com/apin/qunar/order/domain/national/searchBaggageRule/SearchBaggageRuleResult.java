package com.apin.qunar.order.domain.national.searchBaggageRule;

import lombok.Data;

import java.util.List;

@Data
public class SearchBaggageRuleResult {
    /**
     * 特殊票务说明
     */
    private List<String> specialRules;
}
