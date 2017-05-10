package com.tcc.luan.biob.base_application.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.tcc.luan.biob.R;
import com.tcc.luan.biob.base_application.control.VoltarOnClickListener;
import com.tcc.luan.biob.base_application.model.Learn;
import com.tcc.luan.biob.base_application.model.SESSION;

public class MainActivity extends AppCompatActivity {
    private GridView gv;
    private TextView title;
    private TextView description;
    private RelativeLayout header;
    private ImageView image;
    private Button back;
    private Switch blok;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        gv = (GridView) findViewById(R.id.item_gridView);
        title = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        header = (RelativeLayout) findViewById(R.id.header);
        image = (ImageView) findViewById(R.id.image_header);
        back = (Button) findViewById(R.id.back);
        blok = (Switch) findViewById(R.id.blok);

        VoltarOnClickListener voltar = new VoltarOnClickListener(this);
        back.setOnClickListener(voltar);

        Learn.prepareLearn(this);

        SESSION.context = this;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Learn.prepareLearn(this);
    }

    public boolean isBlok(){
        return blok.isChecked();
    }

    public Button getBack() {
        return back;
    }

    public void setBack(Button back) {
        this.back = back;
    }

    public Switch getBlok() {
        return blok;
    }

    public void setBlok(Switch blok) {
        this.blok = blok;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }

    public RelativeLayout getHeader() {
        return header;
    }

    public void setHeader(RelativeLayout header) {
        this.header = header;
    }

    public GridView getGv() {
        return gv;
    }

    public void setGv(GridView gv) {
        this.gv = gv;
    }

    public TextView getTitle_() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }
}