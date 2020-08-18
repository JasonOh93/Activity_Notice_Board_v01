package com.jasonoh.activity_notice_board_v01;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    ArrayList<Members> members;
    LayoutInflater inflater;

    public MyAdapter( ArrayList<Members> members, LayoutInflater inflater ){
        this.members = members;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return members.size();
    }

    @Override
    public Object getItem(int position) {
        return members.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) convertView = inflater.inflate(R.layout.listview_item, null);

        TextView tv_name = convertView.findViewById(R.id.tv_list_name);
        TextView tv_nickName = convertView.findViewById(R.id.tv_list_nickName);
        TextView tv_title = convertView.findViewById(R.id.tv_list_title);
        TextView tv_write = convertView.findViewById(R.id.tv_list_write);

        tv_name.setText( members.get(position).name );
        tv_nickName.setText( members.get(position).nickName );
        tv_title.setText( members.get(position).title );
        tv_write.setText( members.get(position).write );


        return convertView;
    }
}
