package com.tcc.luan.biob.auxiliary_classes;

import android.content.Context;

import com.tcc.luan.biob.base_application.view.MainActivity;

/**
 * Created by luan on 17/10/16.
 */
public class Aspect_Session {
    private MainActivity contexto_atual;
    private static Aspect_Session ourInstance = new Aspect_Session();
    public static boolean test = false;

    public static Aspect_Session getInstance() {
        return ourInstance;
    }

    private Aspect_Session() {
    }

    public MainActivity getContexto_atual() {
        return contexto_atual;
    }

    public void setContexto_atual(MainActivity contexto_atual) {
        this.contexto_atual = contexto_atual;
    }
}
