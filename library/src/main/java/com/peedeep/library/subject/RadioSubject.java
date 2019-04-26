package com.peedeep.library.subject;

import com.peedeep.library.util.Body;

/**
 * Created by rick  2019/4/1.
 * TODO
 */
public interface RadioSubject {

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