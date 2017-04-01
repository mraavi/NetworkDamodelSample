package com.appcrops.networksample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private String TAG = getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChannelData.instance().getChannelList(new ChannelData.ChannelDataCallback() {
            @Override
            public void onResponse(ArrayList<Channel> channelList) {
                Log.d(TAG, "ChannelData.instance().getChannelList:" + channelList);
            }
        });
    }
}
