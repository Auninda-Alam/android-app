package com.example.attendanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;

    private EditText mTextUsername;
    private EditText mTextPassword;
    private EditText mTextCnfPassword;
    private EditText mTextUserType;
    private Button mButtonRegister;
    private TextView mTextViewLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DatabaseHelper(this);
        mTextUsername=(EditText)findViewById(R.id.edittext_username);
        mTextCnfPassword=(EditText)findViewById(R.id.edittext_password);
        mTextPassword=(EditText)findViewById(R.id.edittext_cnf_password);
        mTextUserType=(EditText)findViewById(R.id.edittext_usertype);
        mButtonRegister=(Button)findViewById(R.id.button_register);
        mTextViewLogin=(TextView)findViewById(R.id.textview_login);
        mTextViewLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent LoginIntent = new Intent (RegisterActivity.this,MainActivity.class);
                startActivity(LoginIntent);
            }

        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                String type = mTextUserType.getText().toString().trim();
                Boolean res = db.checkUser(user, pwd);
                if (pwd.equals(cnf_pwd)) {
                    long val = db.addUser(user, pwd, type);
                    if (val > 0) {
                        Toast.makeText(RegisterActivity.this, "Sign up Successful", Toast.LENGTH_SHORT).show();
                        Intent moveTologin = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(moveTologin);

                    } else {
                        Toast.makeText(RegisterActivity.this, "Registration Error", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(RegisterActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}