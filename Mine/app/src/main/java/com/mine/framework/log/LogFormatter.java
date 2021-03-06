package com.mine.framework.log;

/**
 * Copyright(c) 2017. LiBing Inc. All rights reserved.
 * <p>
 * Created by Alan on 18/1/6.
 */

public final class LogFormatter {

    private LogFormatter() {

    }

    public static String logFormatter(String... messages) {
        if (messages == null) {
            throw new NullPointerException("Illegal argument exception");
        }
        StringBuilder stringBuilder = new StringBuilder("Msg : ");
        for (String msg : messages) {
            stringBuilder.append("[ ").append(msg).append(" ]");
        }
        return stringBuilder.toString();
    }

}
