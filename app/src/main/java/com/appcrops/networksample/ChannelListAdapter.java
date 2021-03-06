package com.appcrops.networksample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 4/2/2017.
 */

public class ChannelListAdapter extends BaseAdapter {
    private final String THUMNAIL_URL_TEMPLATE = "http://data.jioplay.in/guide/v5/thumbnail/infotel/r4g/5.0/default/channel_id/100x80.light.png";

    public class ViewHolder{

        TextView name;
        TextView id;
        ImageView thumnail;

    }

    private ArrayList<Channel> mChannelList;
    private Context mContext;

    public ChannelListAdapter(Context context,ArrayList<Channel> channels){
        mChannelList = channels;
        mContext = context;

    }

    @Override
    public int getCount() {
        if (mChannelList != null) {
            return mChannelList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {        return mChannelList.get(i);

    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        view = layoutInflater.inflate(R.layout.channel_list_item, viewGroup, false);
        viewHolder.name = (TextView) view.findViewById(R.id.name);
        viewHolder.id = (TextView)view.findViewById(R.id.id);
        viewHolder.thumnail = (ImageView)view.findViewById(R.id.icon);

        Channel channel = mChannelList.get(pos);
        viewHolder.name.setText(channel.getName());
        viewHolder.id.setText(channel.getId());
        String thumbnailUrl = THUMNAIL_URL_TEMPLATE.replace("channel_id", channel.getThumnailId());
        new ImageDownloaderTask(viewHolder.thumnail).execute(thumbnailUrl);


        return view;
    }


}
