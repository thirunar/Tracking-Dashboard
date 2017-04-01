package com.balajigrp.util;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.apache.commons.collections.CollectionUtils.isNotEmpty;


public class CastUtil {

    private CastUtil() {
        //  Overriding the default constructor
    }

    public static BigDecimal getBigDecimal(Map map, String key) {
        Object value = map.get(key);
        return getBigDecimal(value);

    }

    public static BigDecimal getBigDecimal(Object value) {
        String stringValue = getString(value);
        if (StringUtils.isBlank(stringValue)) {
            return null;
        }
        return new BigDecimal(stringValue.replaceAll(",", ""));
    }

    public static BigInteger getBigInteger(Object value) {
        String stringValue = getString(value);
        if (StringUtils.isBlank(stringValue)) {
            return null;
        }
        return new BigInteger(stringValue.replaceAll(",", ""));
    }

    public static String getString(Map map, String key) {
        return getString(map.get(key));
    }

    public static String getString(Object value) {
        if (value == null) {
            return null;
        }
        String stringValue = value.toString();
        return StringUtils.trim(stringValue);
    }

    public static Long getLong(Map map, String key) {
        Object value = map.get(key);
        return getLong(value);
    }

    public static Integer getInteger(Map map, String key) {
        Object value = map.get(key);
        return getInteger(value);
    }

    private static Long getLong(Object value) {
        String stringValue = getString(value);
        if (StringUtils.isBlank(stringValue)) {
            return null;
        }
        return Long.valueOf(stringValue);
    }

    private static Integer getInteger(Object value) {
        String stringValue = getString(value);
        if (StringUtils.isBlank(stringValue)) {
            return null;
        }
        return Integer.valueOf(stringValue);
    }



    private static Date getDate(Object object) {
        if (object instanceof Date) {
            return (Date) object;
        }
        return getDate(getString(object));
    }

    public static Date getDateTime(Object object) {
        if (object instanceof Date) {
            return (Date) object;
        }
        return getDateTime(getString(object));
    }


    public static ZonedDateTime getZonedDateTime(String dateTimeString) {
        return ZonedDateTime.parse(dateTimeString, DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static String dateToString(Date date) {
        return date == null ? null : DateFormatUtils.format(date, DateFormatUtils.ISO_DATE_FORMAT.getPattern());
    }

    public static String dateTimeToString(Date date) {
        return date == null ? null : DateFormatUtils.format(date, DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern());
    }

    public static String dateTimeToString(ZonedDateTime date) {
        return date == null ? null : date.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    public static boolean getBoolean(Map map, String key) {
        return getBoolean(map.get(key));
    }

    public static boolean getBoolean(Map map, String key, boolean defaultValue) {
        return getBoolean(map.get(key), defaultValue);
    }

    public static boolean getBoolean(Object value) {
        if (value == null) {
            return false;
        }
        return BooleanUtils.toBoolean(value.toString());
    }

    public static boolean getBoolean(Object value, boolean defaultValue) {
        if (value == null) {
            return defaultValue;
        }
        return BooleanUtils.toBoolean(value.toString());
    }

    private static boolean isNotListOfString(Object value) {
        if (isNotAList(value)) {
            return true;
        }
        List valueAsList = (List) value;
        return isNotEmpty(valueAsList) && !(valueAsList.get(0) instanceof String);
    }

    private static boolean isNotListOfMap(Object value) {
        if (isNotAList(value)) {
            return true;
        }
        List valueAsList = (List) value;
        return isNotEmpty(valueAsList) && !(valueAsList.get(0) instanceof Map);
    }

    private static boolean isNotAList(Object value) {
        if (!(value instanceof List)) {
            return true;
        }
        return false;
    }
}