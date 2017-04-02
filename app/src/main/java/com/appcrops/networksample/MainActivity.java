package com.appcrops.networksample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {

    ListView mListView;

    private String TAG = getClass().getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView)findViewById(R.id.simple_list);

        ChannelData.instance().getChannelList(new ChannelData.ChannelDataCallback() {
            @Override
            public void onResponse(ArrayList<Channel> channelList) {
                Log.d(TAG, "ChannelData.instance().getChannelList:" + channelList);
                ChannelListAdapter channelListAdapter = new ChannelListAdapter(MainActivity.this ,channelList);
                mListView.setAdapter(channelListAdapter);
            }
        });
    }
}
