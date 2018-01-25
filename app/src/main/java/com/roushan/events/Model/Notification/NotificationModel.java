package com.roushan.events.Model.Notification;

/**
 * Created by Aditya on 08-02-2017.
 */

public class NotificationModel {

    String question,ans;


    public NotificationModel(String question,String ans) {

        this.question=question;
        this.ans=ans;


    }
    public NotificationModel()
    {

    }

    public String getAns() {
        return ans;
    }

    public String getQuestion() {
        return question;
    }
}
