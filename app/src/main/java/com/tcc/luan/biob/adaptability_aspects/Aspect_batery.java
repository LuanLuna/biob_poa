package com.tcc.luan.biob.adaptability_aspects;

import android.content.Context;
import android.content.Intent;

import com.tcc.luan.biob.auxiliary_classes.Aspect_Session;
import com.tcc.luan.biob.context_manager.Biob_Location;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by luan on 18/10/16.
 */
@Aspect
public class Aspect_batery {
    public static int BATERY_LEVEL = 100;

    private static final String ON_CHANGE_BATERY = "execution (" +
            "public void " +
            "com.tcc.luan.biob.context_manager.Biob_Batery.onReceive(android.content.Context, android.content.Intent)) " +
            "&& args(context, intent)";

    @Pointcut(ON_CHANGE_BATERY)
    public void onBateryChange(Context context, Intent intent){}

    @After(value = "onBateryChange(context, intent)")
    public void afterOnBateryChange(Context context, Intent intent){
        Aspect_Session.test = true;
        try {
            BATERY_LEVEL = intent.getIntExtra("level", 0);
            if (BATERY_LEVEL <= 15)
                Biob_Location.setRefreshTime(Biob_Location.SAFE_REFRESH_TIME);
            else
                Biob_Location.setRefreshTime(Biob_Location.REAL_REFRESH_TIME);
        }catch (Exception e){}
    }


}
