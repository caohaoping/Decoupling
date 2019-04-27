package com.peedeep.library.util;

/**
 * Created by rick on 2019/3/30.
 * 转换工具
 */
public class Transition {

    public static <T, X> X switchOrNull(T t, Class<X> clazz) {
        if (t != null && clazz != null) {
            return map(t, clazz);
        } else {
            return null;
        }
    }

    public static <T, X, R> R switchOrNull(Body<T, X, R> body, Func<T, X> func) {
        if (body.hasReturn) {
            X x = func.apply(body.paramData);
            if (x != null && body.func != null) {
                return body.func.apply(x);
            } else if (body.returnData != null && body.func != null) {
                return body.func.apply(body.returnData);
            }
            return null;
        } else {
            func.apply(body.paramData);
            return null;
        }
    }

    public static <T, R> R map(T t, Class<R> clazz) {
        if (clazz.isInstance(t)) {
            return clazz.cast(t);
        }
        return null;
    }

}
