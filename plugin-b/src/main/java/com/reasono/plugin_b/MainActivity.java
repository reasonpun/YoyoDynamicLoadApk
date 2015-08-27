package com.reasono.plugin_b;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.reasono.yoyodynamicloadapk.library.dynamicload.DLBasePluginActivity;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends DLBasePluginActivity {

    @Bind(R.id.send_btn)
    Button mSendBtn;
    @Bind(R.id.image)
    ImageView mImage;

    @OnClick(R.id.send_btn)
    public void send() {
        mSendBtn.setText("clicked");

        Picasso.with(that).load("http://f.hiphotos.baidu.com/image/h%3D360/sign=6fe50562ed50352aae61230e6342fb1a/f11f3a292df5e0fecc3383d4586034a85edf723f.jpg").into(mImage);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}
