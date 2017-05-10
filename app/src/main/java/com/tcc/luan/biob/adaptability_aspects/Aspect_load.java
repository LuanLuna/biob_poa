package com.tcc.luan.biob.adaptability_aspects;

import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;

import com.tcc.luan.biob.auxiliary_classes.Aspect_Session;
import com.tcc.luan.biob.base_application.view.MainActivity;
import com.tcc.luan.biob.context_manager.Biob_Batery;
import com.tcc.luan.biob.context_manager.Biob_Location;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by luan on 18/10/16.
 */
@Aspect
public class Aspect_load {
    public static Biob_Location biob_location;
    public static Biob_Batery biob_batery;
    //-------------------------------------------------creating sensors
    private static final String ON_INSTANCE_CONTEXT =
            "execution (public void " +
                    "com.tcc.luan.biob.base_application.view.MainActivity.onCreate(..))";

    @Pointcut(ON_INSTANCE_CONTEXT)
    public void onInstanceContext(){}

    @Before(value = "onInstanceContext()",argNames = "joinPoint")
    public void beforeOnInstanceContext(JoinPoint joinPoint){
        MainActivity context =  (MainActivity) joinPoint.getThis();
        Aspect_Session aspect_session = Aspect_Session.getInstance();
        aspect_session.setContexto_atual(context);
        //-------------------------------------Localizador
        biob_location = new Biob_Location(context);
        biob_location.callConnection();
        //-------------------------------------Medição de bateria
        try {
            biob_batery = new Biob_Batery();
            context.registerReceiver(biob_batery, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        }catch (Exception e){}
    }
    //---------------------------------------------------
    private static final String ON_DESTROI_CONTEXT =
            "execution (public void " +
                    "com.tcc.luan.biob.base_application.view.MainActivity.onDestroy(..))";

    @Pointcut(ON_DESTROI_CONTEXT)
    public void onDestroiContext(){}

    @Before(value = "onDestroiContext()")
    public void beforeOnDestroiContext(){
        Aspect_Session aspect_session = Aspect_Session.getInstance();
        MainActivity context = aspect_session.getContexto_atual();
        biob_location.stopLocationUpdate();
        context.unregisterReceiver(biob_batery);
    }

}
