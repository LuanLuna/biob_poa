package com.tcc.luan.biob;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;

import com.tcc.luan.biob.adaptability_aspects.Aspect_load;
import com.tcc.luan.biob.auxiliary_classes.Aspect_Session;
import com.tcc.luan.biob.base_application.model.SESSION;
import com.tcc.luan.biob.base_application.view.MainActivity;
import com.tcc.luan.biob.context_manager.Biob_Batery;
import com.tcc.luan.biob.context_manager.Biob_Location;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Tests Artifact in the Build Variants view.
 */
public class Tests {
    @org.junit.After
    public void after(){
        Aspect_Session.test = false;
    }
    @org.junit.Test
    public void location() throws Exception {
        assertEquals(Aspect_Session.test,false);

        Biob_Location bl = new Biob_Location();
        Location loc = new Location("dummyprovider");
        bl.onLocationChanged(loc);

        assertEquals(Aspect_Session.test,true);
    }

    @org.junit.Test
    public void battery() throws Exception {
        assertEquals(Aspect_Session.test,false);

        Biob_Batery bb = new Biob_Batery();
        Intent i = new Intent();
        MainActivity m = new MainActivity();
        bb.onReceive(m,i);

        assertEquals(Aspect_Session.test,true);
    }
}