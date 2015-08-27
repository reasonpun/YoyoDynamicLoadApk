package com.reasono.dynamicloadapkpluga;/**
 * Created by reasono on 15/8/27.
 */

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.reasono.network.library.HttpClientRequest;
import com.reasono.network.library.RequestParams;
import com.reasono.yoyodynamicloadapk.library.dynamicload.DLBasePluginActivity;

import java.util.HashMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Reason
 * @title com.reasono.dynamicloadapkpluga
 * @description
 * @modifier
 * @date
 * @since 15/8/27 09:27
 **/
public class AarLibTestActivity extends DLBasePluginActivity {
    @Bind(R.id.btn_test)
    Button mBtnTest;
    @Bind(R.id.content)
    EditText mContent;
    @Bind(R.id.show_msg)
    TextView mShowMsg;

    @OnClick(R.id.btn_test)
    public void click() {
        String APIKEY = "your key";
        RequestParams requestParams = new RequestParams();
        requestParams.put("key", APIKEY);
        requestParams.put("info", mContent.getText().toString());
        String url = "http://www.tuling123.com/openapi/api";

        HttpClientRequest
                .getInstance(that)
                .get(HashMap.class, url,
                        requestParams,
                        new HttpClientRequest.OnHttpRequestEvent<HashMap>() {
                            @Override
                            public void OnStart() {

                            }

                            @Override
                            public void OnSuccess(HashMap result) {
                                mShowMsg.setText(result.get("text").toString());
                            }

                            @Override
                            public void OnError(Throwable error) {

                            }

                            @Override
                            public void OnComplete() {

                            }
                        });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aar_lib_test);
        ButterKnife.bind(this);
    }
}
