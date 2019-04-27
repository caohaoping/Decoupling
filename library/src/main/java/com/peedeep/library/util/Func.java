package com.peedeep.library.util;

/**
 * Created by rick on 2019/3/29.
 * 钩子函数
 */
public interface Func<T, R> {

    R apply(T t);
}
