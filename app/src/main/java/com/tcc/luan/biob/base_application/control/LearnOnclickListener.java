package com.tcc.luan.biob.base_application.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tcc.luan.biob.base_application.view.LearnActivity;

/**
 * Created by luan on 09/09/16.
 */
public class LearnOnclickListener implements View.OnClickListener {
    private int item_id;

    public LearnOnclickListener(int item_id) {
        this.item_id = item_id;
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(v.getContext(),LearnActivity.class);
        Bundle b = new Bundle();
        b.putInt("item_id", item_id);
        i.putExtras(b);
        v.getContext().startActivity(i);
    }
}
