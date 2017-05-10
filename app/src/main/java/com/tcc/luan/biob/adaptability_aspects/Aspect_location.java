package com.tcc.luan.biob.adaptability_aspects;

/**
 * Created by luan on 16/10/16.
 */
import android.location.Location;

import com.tcc.luan.biob.auxiliary_classes.Aspect_Session;
import com.tcc.luan.biob.base_application.model.Collect;
import com.tcc.luan.biob.base_application.model.Learn;
import com.tcc.luan.biob.base_application.model.database.DataBase;
import com.tcc.luan.biob.base_application.model.util.Item;
import com.tcc.luan.biob.base_application.view.MainActivity;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.List;

//onLocationChanged(Location location)
@Aspect
public class Aspect_location {
    private static final String LOCATION_CHANGE =
            "execution (public void " +
                    "com.tcc.luan.biob.context_manager.Biob_Location.onLocationChanged(android.location.Location)) && args(location)";

    @Pointcut(LOCATION_CHANGE)
    public void locationChange(Location location){}

    @After(value = "locationChange(location)")
    public void afterLocationChanged(Location location){
        Aspect_Session.test = true;
        try {
            Aspect_Session aspect_session = Aspect_Session.getInstance();
            MainActivity context = aspect_session.getContexto_atual();
            DataBase db = new DataBase(context);
            if (location != null) {
                List<Item> close_items = db.getItensByLocationPoint(location.getLatitude(), location.getLongitude());
                if (close_items.size() > 0 && !context.getBlok().isChecked()) {
                    Collect.prepareCollect(context, close_items);
                } else {
                    Learn.prepareLearn(context);
                }
            }
        }catch(Exception e){}
    }


}
