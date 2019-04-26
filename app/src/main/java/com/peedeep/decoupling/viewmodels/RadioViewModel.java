package com.peedeep.decoupling.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.peedeep.decoupling.data.Radio;

/**
 * Created by rick on 2019/4/26.
 * TODO
 */
public class RadioViewModel extends ViewModel {

    private LiveData<Radio> radioLiveData;

    public LiveData<Radio> getRadioLiveData() {
        if (radioLiveData == null) {
            radioLiveData = new RadioLiveData();
        }
        return radioLiveData;
    }

}
