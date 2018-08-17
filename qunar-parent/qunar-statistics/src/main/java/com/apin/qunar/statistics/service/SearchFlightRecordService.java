package com.apin.qunar.statistics.service;

public interface SearchFlightRecordService {
    void create(String account, boolean hasInternal, String deptCity, String arriCity);
}