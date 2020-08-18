package com.jasonoh.activity_notice_board_v01;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    EditText et_name, et_nickName, et_title, et_write;
    TextView tv_writeCnt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().setTitle("게시판 작성");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        et_name = findViewById(R.id.et_name);
        et_nickName = findViewById(R.id.et_nickName);
        et_title = findViewById(R.id.et_title);
        et_write = findViewById(R.id.et_write);
        tv_writeCnt = findViewById(R.id.tv_writeCnt);

        et_write.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv_writeCnt.setText( et_write.getText().toString().length() + " / 500" );
            }//onTextChanged

            @Override
            public void afterTextChanged(Editable s) { }
        });//et_write.addTextChangedListener

    }//onCreate

    public void clickBtn(View view) {

        switch ( view.getId() ) {

            case R.id.btn_cancel :
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage( R.string.cancel_message );
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }//onClick
                });//builder.setPositiveButton

                builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }//onClick
                });// builder.setNegativeButton

                AlertDialog alertDialog = builder.create();
                alertDialog.show();

                break;

            case R.id.btn_finish :

                AlertDialog.Builder builder_finish = new AlertDialog.Builder(this);
                builder_finish.setMessage( R.string.finish_message );
                builder_finish.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = getIntent();

                        intent.putExtra( "Name", et_name.getText().toString() );
                        intent.putExtra( "NickName", et_nickName.getText().toString() );
                        intent.putExtra( "Title", et_title.getText().toString() );
                        intent.putExtra( "Write", et_write.getText().toString() );

                        setResult( RESULT_OK, intent );

                        finish();
                    }//onClick
                });//builder.setPositiveButton

                builder_finish.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) { }//onClick
                });// builder.setNegativeButton

                AlertDialog alertDialog_finish = builder_finish.create();
                alertDialog_finish.show();


                break;

        }//switch

    }//clickBtn
}//SecondActivity
