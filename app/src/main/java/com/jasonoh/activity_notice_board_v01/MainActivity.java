package com.jasonoh.activity_notice_board_v01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    TextView tv_empty;

    ArrayList<Members> members = new ArrayList<>();
    MyAdapter listView_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("게시판");

        listView = findViewById(R.id.listView);
        tv_empty = findViewById(R.id.tv_empty);

        listView.setEmptyView( tv_empty );

        listView_adapter = new MyAdapter(members, getLayoutInflater());
        listView.setAdapter( listView_adapter );

    }//onCreate

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        switch ( requestCode ) {
            case 10 :
                if(resultCode == RESULT_OK) {

                    members.add( new Members( data.getStringExtra( "Name" ), data.getStringExtra( "NickName" ), data.getStringExtra( "Title" ), data.getStringExtra( "Write" ) ) );
                    listView_adapter = new MyAdapter(members, getLayoutInflater());
                    listView_adapter.notifyDataSetChanged();
                    listView.setAdapter( listView_adapter );
                }//if
                break;
        }//switch

        super.onActivityResult(requestCode, resultCode, data);
    }//onActivityResult

    public void clickPlus(View view) {
        startActivityForResult( new Intent(this, SecondActivity.class), 10 );
    }//clickPlus
}//MainActivity class
