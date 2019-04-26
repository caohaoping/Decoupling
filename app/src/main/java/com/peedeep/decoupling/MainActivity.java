package com.peedeep.decoupling;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.peedeep.decoupling.data.Radio;
import com.peedeep.decoupling.viewmodels.RadioViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView name = findViewById(R.id.radio_name);

        RadioViewModel radioViewModel = ViewModelProviders.of(this).get(RadioViewModel.class);
        radioViewModel.getRadioLiveData().observe(this, new Observer<Radio>() {
            @Override
            public void onChanged(@Nullable Radio radio) {
                assert radio != null;
                Log.i(TAG, "radioName: " + radio.getName() + ", frequency: " + radio.getFrequency());
                name.setText(String.format("radio frequency: %s", radio.getFrequency()));
            }
        });
    }
}
