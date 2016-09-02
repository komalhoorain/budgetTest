package com.example.test.test1;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.TimeZone;

import Base.MyAppCompact;
import Model.User;
import db.DBHelper;
import de.hdodenhof.circleimageview.CircleImageView;

public class Register extends MyAppCompact implements View.OnClickListener{

   Button createbtn;
    TextView cancel;
    TextView dob;
    ImageView pic;
    CircleImageView profile;

    String imgDecodableString;
    private static int RESULT_LOAD_IMG = 1;

    private DatePicker datePicker;
    private Calendar calendar;
    private int year, month, day;


    EditText namevalue, emailvalue, uservalue, passvalue, rpassvalue, descriptionvalue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        //
        cancel=(TextView) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        cancel=(TextView) findViewById(R.id.cancel);
        cancel.setOnClickListener(this);
        createbtn=(Button) findViewById(R.id.create);
        createbtn.setOnClickListener(this);
        pic=(ImageView) findViewById(R.id.picture);
        pic.setOnClickListener(this);
        profile=(CircleImageView) findViewById(R.id.profile);
        dob = (TextView)findViewById(R.id.dobtext);
        dob.setOnClickListener(this);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

        namevalue= (EditText) findViewById(R.id.fullname);
        emailvalue= (EditText) findViewById(R.id.emailvalue);
        uservalue= (EditText) findViewById(R.id.user);
        passvalue= (EditText) findViewById(R.id.pas);
        rpassvalue= (EditText) findViewById(R.id.rpas);
        descriptionvalue= (EditText) findViewById(R.id.descvalue);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dobtext: {
                showDialog(999);
            }
            break;
            case R.id.cancel: {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
            break;
            case R.id.create: {
                User user =null;
                //int nextInt = new Random().nextInt(3);
                // save the new comment to the database
                //convert user, pass in string

                if (passvalue.getText().toString().equals(rpassvalue.getText().toString())) {
                    dbHelper.insertUser(namevalue.getText().toString(), emailvalue.getText().toString(), uservalue.getText().toString(), passvalue.getText().toString(), descriptionvalue.getText().toString());
                    //dbHelper.getAllUsers();
                    //ArrayList array_list = mydb.getAllUsers();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(this, "Password mis-match!", Toast.LENGTH_LONG)
                            .show();
                }
            }
            break;
            case R.id.picture:{
                // Create intent to Open Image applications like Gallery, Google Photos
                Intent galleryIntent = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                // Start the Intent
                startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
            }
            default:
                break;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int year, int month, int day) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            dob.setText(day+"/"+month+"/"+year);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (resultCode == RESULT_OK) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                Picasso.with(Register.this).load(selectedImage).into(profile);

                //Picasso Use to set image

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }
    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

}
