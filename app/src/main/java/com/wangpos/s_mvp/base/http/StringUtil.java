package com.wangpos.s_mvp.base.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StringUtil {


    public static boolean isEmpty(String value) {
        return isEmpty(value, null);
    }

    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    public static boolean isEmpty(String value, String ignore) {
        if (value == null || value.trim().length() == 0) {
            return true;
        } else {
            if (ignore != null && value.equalsIgnoreCase(ignore)) {
                return true;
            }
        }

        return false;
    }

    public static String inToString(InputStream inputStream) {

        String result = "";
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        try {
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
