package com.tcc.luan.biob.base_application.control;

import android.view.View;

import com.tcc.luan.biob.base_application.model.Learn;
import com.tcc.luan.biob.base_application.view.MainActivity;

/**
 * Created by luan on 10/09/16.
 */
public class VoltarOnClickListener implements View.OnClickListener {
    private MainActivity context;

    public VoltarOnClickListener(MainActivity context) {
        this.context = context;
    }

    @Override
    public void onClick(View v) {
        Learn.prepareLearn(context);
        context.getBlok().setChecked(true);
    }
}