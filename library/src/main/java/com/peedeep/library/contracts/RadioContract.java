package com.peedeep.library.contracts;

import com.peedeep.library.util.Body;

/**
 * Created by rick 2019/4/1.
 * 类型契约，
 * Middle表示返回中间类型，
 * Final表示返回最终类型。
 */
public interface RadioContract {

    interface Middle {
        <T, X, R> X openRadio(Body<T, X, R> body);

        <T, X, R> X closeRadio(Body<T, X, R> body);

        <T, X, R> X nextRadio(Body<T, X, R> body);

        <T, X, R> X previousRadio(Body<T, X, R> body);

        <T, X, R> X setAmFrequency(Body<T, X, R> body);

        <T, X, R> X setFmFrequency(Body<T, X, R> body);
    }

    interface Final {
        <T, X, R> R openRadio(Body<T, X, R> body);

        <T, X, R> R closeRadio(Body<T, X, R> body);

        <T, X, R> R nextRadio(Body<T, X, R> body);

        <T, X, R> R previousRadio(Body<T, X, R> body);

        <T, X, R> R setAmFrequency(Body<T, X, R> body);

        <T, X, R> R setFmFrequency(Body<T, X, R> body);
    }
}