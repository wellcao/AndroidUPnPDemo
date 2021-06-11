package com.zane.androidupnpdemo.util;

import android.util.Log;


/**
 * log打印
 * @date 2019-06-28
 */

public final class DeLog {
    private static final boolean DEBUG = true;

    private static String mClassName;//类名
    private static String mMethodName;//方法名
    private static int mLineNumber;//行数

    private static String createLog(String log) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(mMethodName);
        buffer.append("(").append(mClassName).append(":").append(mLineNumber).append(")");
        buffer.append(log);
        return buffer.toString();
    }

    private static void getMethodNames(StackTraceElement[] sElements) {
        mClassName = sElements[1].getFileName();
        mMethodName = sElements[1].getMethodName();
        mLineNumber = sElements[1].getLineNumber();
    }


    public static void d(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.d(mClassName, createLog(message));
        }
    }

    public static void d(String tag, String msg) {
        if (DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void e(String message) {
        if (DEBUG) {
            getMethodNames(new Throwable().getStackTrace());
            Log.e(mClassName, createLog(message));
        }
    }

    public static void e(String tag, String msg) {
        if (DEBUG) {
            Log.e(tag, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }
}
