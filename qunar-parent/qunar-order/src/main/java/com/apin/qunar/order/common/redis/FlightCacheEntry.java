package com.apin.qunar.order.common.redis;

import com.apin.qunar.order.domain.international.searchFlight.NtsSearchFlightResultVO;

import java.util.List;

public class FlightCacheEntry {
    private List<NtsSearchFlightResultVO> fligths;

    public FlightCacheEntry(){}
    public FlightCacheEntry(List<NtsSearchFlightResultVO> fligths) {
        this.fligths = fligths;
    }

    public List<NtsSearchFlightResultVO> getFligths() {
        return fligths;
    }

    public void setFligths(List<NtsSearchFlightResultVO> fligths) {
        this.fligths = fligths;
    }
}