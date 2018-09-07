package com.apin.qunar.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm";

    public static final String DEFAULT_DATE_DAYPATTERN = "yyyy-MM-dd";

    public static final String DATE_FORMAT_24HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_FORMAT_24HOUR_PATTERN1 = "yyyyMMddHHmmss";

    public static final SimpleDateFormat DEFAULT_FORMAT = new SimpleDateFormat(DATE_FORMAT_24HOUR_PATTERN);

    public static final SimpleDateFormat DEFAULT_24HOUR_FORMAT = new SimpleDateFormat(DEFAULT_DATE_PATTERN);

    public static final SimpleDateFormat DEFAULT_DAY_FORMAT = new SimpleDateFormat(DEFAULT_DATE_DAYPATTERN);

    public static final SimpleDateFormat DEFAULT_DAY_FORMAT1 = new SimpleDateFormat(DATE_FORMAT_24HOUR_PATTERN1);

    public static String getDatePattern() {
        return DEFAULT_DATE_PATTERN;
    }

    public static String formatYYYYMM(Date date) {
        return DEFAULT_FORMAT.format(date);
    }

    public static String format(Date date) {
        return date == null ? "" : format(date, getDatePattern());
    }

    public static String format(Date date, String pattern) {
        return date == null ? "" : new SimpleDateFormat(pattern).format(date);
    }

    public static String formatDate(String date) {
        String dateStr = "";
        try {
            Date d = DEFAULT_DAY_FORMAT.parse(date);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(d);
            dateStr = (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    public static String formatDate(long date) {
        String dateStr = "";
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(date);
            dateStr = (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }


    public static String getCurrDate() {
        String formatDate = null;
        try {
            formatDate = DEFAULT_FORMAT.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public static Date getDate(String date, String time) {
        Date formatDate = null;
        try {
            formatDate = DEFAULT_24HOUR_FORMAT.parse(date + " " + time);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formatDate;
    }

    public static String getDate(String date) {
        Date formatDate = null;
        try {
            formatDate = DEFAULT_DAY_FORMAT1.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return DEFAULT_FORMAT.format(formatDate);
    }

    public static Date getDateByYYYYMMDD(String dateStr) {
        Date date = null;
        try {
            date = DEFAULT_DAY_FORMAT.parse(dateStr);
        } catch (Exception e) {
        }
        return date;
    }
}
