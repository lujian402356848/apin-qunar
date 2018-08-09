package com.apin.qunar.common.utils;

import java.util.UUID;

/**
 * @outhor lujian
 * @create 2018-06-24 18:19
 */
public class UUIDUtil {
    /**
     * 产生一个无横线的小写UUID
     *
     * @return
     */
    public static String getUUID() {
        String uuid = UUID.randomUUID().toString().toLowerCase();
        return uuid.replaceAll("-", "");
    }
}
