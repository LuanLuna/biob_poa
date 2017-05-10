package com.tcc.luan.biob.base_application.control;

import android.content.Context;

import com.tcc.luan.biob.base_application.model.database.DataBase;
import com.tcc.luan.biob.base_application.model.util.User;

/**
 * Created by luan on 28/08/16.
 */
public class Access {
    public static User login(String login, String password, Context context){
        DataBase db = new DataBase(context);
        User retorno = db.login(login,password);

        return retorno;
    }
}
