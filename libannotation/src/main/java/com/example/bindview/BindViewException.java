package com.example.bindview;

/**
 * <p/>
 * Author: wenld on 2017/3/29 15:38.
 * blog: http://www.jianshu.com/u/99f514ea81b3
 * github: https://github.com/LidongWen
 */
public class BindViewException extends RuntimeException {
    private static final long serialVersionUID = -2912559384646531479L;

    public BindViewException(String detailMessage) {
        super(detailMessage);
    }

    public BindViewException(Throwable throwable) {
        super(throwable);
    }

    public BindViewException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
