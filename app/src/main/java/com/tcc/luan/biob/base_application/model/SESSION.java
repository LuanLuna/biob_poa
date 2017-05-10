package com.tcc.luan.biob.base_application.model;

import android.content.Context;

import com.tcc.luan.biob.base_application.model.util.User;
import com.tcc.luan.biob.base_application.view.MainActivity;

/**
 * Created by luan on 27/08/16.
 */
public class SESSION {
    private User user = null;
    public static MainActivity context;
    private static SESSION ourInstance = new SESSION();

    public static SESSION getInstance() {
        return ourInstance;
    }

    private SESSION() {
    }
    public void setContext(MainActivity context){
        SESSION.context = context;
    }
    public void setUser(User user){
        this.user = user;
    }
    public User getUser(){
        return this.user;
    }
}
