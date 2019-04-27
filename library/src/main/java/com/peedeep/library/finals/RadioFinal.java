package com.peedeep.library.finals;

import com.peedeep.library.middles.RadioMiddle;
import com.peedeep.library.contracts.RadioContract;
import com.peedeep.library.util.Body;
import com.peedeep.library.util.Func;
import com.peedeep.library.util.Transition;

/**
 * Created by rick on 2019/4/26.
 * 返回第三方接口需要的最终类型，
 * 过滤不需要返回值的方法。
 */
public class RadioFinal implements RadioContract.Final {

    private final RadioMiddle radioMiddle;

    public RadioFinal(RadioMiddle radioMiddle) {
        this.radioMiddle = radioMiddle;
    }

    @Override
    public <T, X, R> R openRadio(final Body<T, X, R> body) {
        return Transition.switchOrNull(body, new Func<T, X>() {
            @Override
            public X apply(T t) {
                return radioMiddle.openRadio(body);
            }
        });
    }

    @Override
    public <T, X, R> R closeRadio(final Body<T, X, R> body) {
        return Transition.switchOrNull(body, new Func<T, X>() {
            @Override
            public X apply(T t) {
                return radioMiddle.closeRadio(body);
            }
        });
    }

    @Override
    public <T, X, R> R nextRadio(final Body<T, X, R> body) {
        return Transition.switchOrNull(body, new Func<T, X>() {
            @Override
            public X apply(T t) {
                return radioMiddle.nextRadio(body);
            }
        });
    }

    @Override
    public <T, X, R> R previousRadio(final Body<T, X, R> body) {
        return Transition.switchOrNull(body, new Func<T, X>() {
            @Override
            public X apply(T t) {
                return radioMiddle.previousRadio(body);
            }
        });
    }

    @Override
    public <T, X, R> R setAmFrequency(final Body<T, X, R> body) {
        return Transition.switchOrNull(body, new Func<T, X>() {
            @Override
            public X apply(T t) {
                return radioMiddle.setAmFrequency(body);
            }
        });
    }

    @Override
    public <T, X, R> R setFmFrequency(final Body<T, X, R> body) {
        return Transition.switchOrNull(body, new Func<T, X>() {
            @Override
            public X apply(T t) {
                return radioMiddle.setFmFrequency(body);
            }
        });
    }
}
