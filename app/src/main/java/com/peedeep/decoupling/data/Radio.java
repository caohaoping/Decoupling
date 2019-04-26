package com.peedeep.decoupling.data;

/**
 * Created by rick on 2019/4/26.
 * TODO
 */
public class Radio {

    private String name;
    private float frequency;

    public Radio(String name, float frequency) {
        this.name = name;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getFrequency() {
        return frequency;
    }

    public void setFrequency(float frequency) {
        this.frequency = frequency;
    }
}
