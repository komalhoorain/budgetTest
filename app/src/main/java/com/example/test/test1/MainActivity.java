package com.example.test.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Base.MyAppCompact;
import Model.User;
import db.DBHelper;

public class MainActivity extends MyAppCompact implements View.OnClickListener{

    ImageView twt,btn2,btn1 ,log;
    EditText namevalue,passvalue;
    ArrayList<User> users =null ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //

        namevalue=(EditText) findViewById(R.id.username);
        passvalue=(EditText) findViewById(R.id.password);
        btn1=(ImageView) findViewById(R.id.img1);
        btn1.setOnClickListener(this);
        btn2=(ImageView) findViewById(R.id.img2);
        btn2.setOnClickListener(this);
        log=(ImageView) findViewById(R.id.log);
        log.setOnClickListener(this);
        twt=(ImageView) findViewById(R.id.img3);
        twt.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img1: {
                Intent intent = new Intent(getBaseContext(), Register.class);
                startActivity(intent);
            }
            break;
            case R.id.img2: {
                Intent intent = new Intent(getBaseContext(), ViewPagerActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.log: {
                users=dbHelper.getAllUsers();
                for (User user:users)
                {
                    if (user.getUsername().equals(namevalue.getText().toString()) &&user.getPassowrd().equals(passvalue.getText().toString()))
                    {
                        Intent intent = new Intent(getBaseContext(), Listing.class);
                        startActivity(intent);
                        finish();
                        onDestroy();
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid user!",
                                Toast.LENGTH_SHORT).show();
                    }
                }

            }
            break;
            case R.id.img3:{
                Intent intent = new Intent(getBaseContext(), chart.class);
                startActivity(intent);
            }
            break;
            default:
                break;
        }
    }
}
