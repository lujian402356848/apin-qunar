package com.apin.qunar.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取本机服务器ip
 */
@Slf4j
public class HostUtil {
    private static String ipAddress;

    static {
        ipAddress = locaLoaclIp();
        log.info("本机外网ip:{}", ipAddress);
    }

    public static String getLocalIp() {
        return ipAddress;
    }

    /**
     * 取本机地址
     */
    private static String locaLoaclIp() {
        InetAddress result = null;
        try {
            int lowest = Integer.MAX_VALUE;
            for (Enumeration<NetworkInterface> nics = NetworkInterface.getNetworkInterfaces(); nics.hasMoreElements(); ) {
                NetworkInterface ifc = nics.nextElement();
                if (ifc.isUp()) {

                    if (ifc.getIndex() < lowest || result == null) {
                        lowest = ifc.getIndex();
                    } else if (result != null) {
                        continue;
                    }
                    for (Enumeration<InetAddress> addrs = ifc.getInetAddresses(); addrs.hasMoreElements(); ) {
                        InetAddress address = addrs.nextElement();
                        if (address instanceof Inet4Address && !address.isLoopbackAddress()) {
                            result = address;
                        }
                    }
                }
            }
        } catch (Exception ex) {
        }
        if (result != null) {
            return result.getHostAddress();
        }
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
        }
        return "127.0.0.1";
    }
}
