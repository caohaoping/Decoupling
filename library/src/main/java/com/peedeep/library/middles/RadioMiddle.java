package com.peedeep.library.middles;

import com.peedeep.library.finals.RadioFinal;
import com.peedeep.library.proxys.RadioProxy;
import com.peedeep.library.contracts.RadioContract;
import com.peedeep.library.thirdpart.RadioManager;
import com.peedeep.library.util.ResourceCallback;

/**
 * Created by rick on 2019/4/26.
 * 对第三方的逻辑操作、接口注册与取消，都可以在这里。
 */
public abstract class RadioMiddle implements RadioContract.Middle, ResourceCallback {

    private final RadioManager radioManager;

    public RadioMiddle() {
        radioManager = new RadioManager();
    }

    @Override
    public void subscribe() {
        radioManager.addListener(new RadioProxy(new RadioFinal(this)));
    }

    @Override
    public void unSubscribe() {
        radioManager.removeListener(new RadioProxy(new RadioFinal(this)));
    }
}
