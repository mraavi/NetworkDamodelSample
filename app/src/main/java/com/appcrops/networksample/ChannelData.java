package com.appcrops.networksample;

import android.util.Log;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

/**
 * Created by mraavi on 01/04/17.
 */

public class ChannelData {
    private static ChannelData channelData = null;
    ArrayList<Channel> mChannelList = null;
    private ChannelData() {

    }

    public static ChannelData instance() {
        if (channelData == null) {
            channelData = new ChannelData();
        }
        return channelData;
    }

    public void getChannelList(final ChannelDataCallback channelDataCallback){
        if (mChannelList != null) {
            channelDataCallback.onResponse(mChannelList);
        } else {
            AsyncDataModel.instance().getChannelData(new AsyncDataModel.DataModelCallback() {
                @Override
                public void onResponse(AsyncDataModel.Response response) {
                    if (response == null) {
                        channelDataCallback.onResponse(null);
                    } else {
                        Log.d(TAG, "DataModel.instance().getChannelData- onResponse: Type" + response.responseType);
                        Log.d(TAG, "DataModel.instance().getChannelData- onResponse: Data" + response.data);

                        mChannelList = new ArrayList<Channel>();
                        JSONObject serverJsonResponse = response.data;
                        Object totalChannels = (Object)serverJsonResponse.get("total");
                        JSONArray channelInventory = (JSONArray) serverJsonResponse.get("inventories");
                        for (Object object : channelInventory) {
                            JSONObject jsonObject = (JSONObject) object;
                            String channelId = (String)jsonObject.get("id");
                            String channelName = (String)jsonObject.get("name");
                            String thumnailId = (String)jsonObject.get("thumbnail_id");
                            Channel channel = new Channel(channelId, channelName, thumnailId);
                            mChannelList.add(channel);
                        }

                        channelDataCallback.onResponse(mChannelList);
                    }
                }
            });
        }
    }

    public interface ChannelDataCallback {
        public void onResponse(ArrayList<Channel> channelList);
    }
}
