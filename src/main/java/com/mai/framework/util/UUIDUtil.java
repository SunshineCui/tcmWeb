package com.mai.framework.util;

import java.util.UUID;

public class UUIDUtil {
    public UUIDUtil() {
    }

    public static String getUUID() {
        long uuid;
        do {
            uuid = UUID.randomUUID().getMostSignificantBits();
        } while (uuid <= 0L);

        return uuid + "";
    }
}
