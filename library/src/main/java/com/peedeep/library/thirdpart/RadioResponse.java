package com.peedeep.library.thirdpart;

/**
 * Created by rick on 2019/4/1.
 * 模拟第三方需要的返回类型。
 */
public class RadioResponse {

    private String radioName;
    private String reply;

    public RadioResponse(String radioName, String reply) {
        this.radioName = radioName;
        this.reply = reply;
    }

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
