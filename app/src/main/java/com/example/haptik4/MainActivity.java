package com.example.haptik4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ai.haptik.android.wrapper.sdk.HaptikSDK;
import ai.haptik.android.wrapper.sdk.model.InitData;
import ai.haptik.android.wrapper.sdk.model.Response;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        InitData initData = new InitData();
        initData.setPrimaryColor("#420420");
        initData.setComposerPlaceholder("Test message");
        initData.setNoHeader(true);
        initData.setInitializeLanguage("en");
        HaptikSDK.INSTANCE.init(this, initData);
        HaptikSDK.INSTANCE.init(this, initData);

        final Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchGuestConversation();
            }
        });
    }
    public void launchGuestConversation(){
        HaptikSDK.INSTANCE.loadGuestConversation(new Function1<Response, Unit>() {
            @Override
            public Unit invoke(Response response) {
                return null;
            }
        });

    }
}