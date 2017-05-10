package com.tcc.luan.biob.base_application.control;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.tcc.luan.biob.base_application.model.util.Item;
import com.tcc.luan.biob.base_application.view.CollectActivity;

/**
 * Created by luan on 09/09/16.
 */
public class ColectOnClickListener implements View.OnClickListener {
    private Item item;

    public ColectOnClickListener(Item item) {

        this.item = item;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(),CollectActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("item_id",item.getId());
        bundle.putInt("location_id",item.getLocation());
        intent.putExtras(bundle);
        v.getContext().startActivity(intent);
    }
}
