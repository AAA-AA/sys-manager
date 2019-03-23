package com.github.sys.utils;


import org.springframework.util.Assert;

/**
 * Created by renhongqiang on 2019-03-22 21:50
 */
public final class QueryUtils {
    private QueryUtils() {

    }

    public static String fullLike(String source) {
        Assert.isTrue(source != null && source.length() > 0, "source can not be blank");
        return "%" + source + "%";
    }

    public static String rightLike(String source) {
        Assert.isTrue(source != null && source.length() > 0, "source can not be blank");
        return source + "%";
    }

    public static String LeftLike(String source) {
        Assert.isTrue(source != null && source.length() > 0, "source can not be blank");
        return "%" + source;
    }


}
