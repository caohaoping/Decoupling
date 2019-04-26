package com.peedeep.library.middles;

import com.peedeep.library.finals.RadioFinal;
import com.peedeep.library.proxys.RadioProxy;
import com.peedeep.library.subject.RadioSubject;
import com.peedeep.library.thirdpart.RadioManager;
import com.peedeep.library.util.ResourceCallback;

/**
 * Created by rick on 2019/4/26.
 * TODO
 */
public abstract class RadioMiddle implements RadioSubject.Middle, ResourceCallback {

    private final RadioManager radioManager;

    public RadioMiddle() {
        radioManager = new RadioManager();
    }

    @Override
    public void subscribe() {
        // TODO: 2019/4/26 init
        radioManager.addListener(new RadioProxy(new RadioFinal(this)));
    }

    @Override
    public void unSubscribe() {
        // TODO: 2019/4/26 release
        radioManager.remove(new RadioProxy(new RadioFinal(this)));
    }
}
