package com.apin.qunar.statistics.service;

public interface SearchFlightRecordService {
    void create(String merchantNo, boolean hasInternal, String deptCity, String arriCity);
}