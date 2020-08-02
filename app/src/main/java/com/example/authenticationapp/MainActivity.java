package com.example.authenticationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText username,email,password;
    Button signup;
    ImageButton small,capital,number,character;
    TextView SMALL,CAPITAL,NUMBER,CHARACTER;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.edit_text_username);
        email=findViewById(R.id.edit_text_email);
        password=findViewById(R.id.edit_text_password);
        signup=findViewById(R.id.button_signup);
        small=findViewById(R.id.small_letter_icon);
        capital=findViewById(R.id.capital_letter_icon);
        number=findViewById(R.id.number_letter_icon);
        character=findViewById(R.id.char_letter_icon);
        SMALL=findViewById(R.id.small_letter_text);
        CAPITAL=findViewById(R.id.capital_letter_text);
        NUMBER=findViewById(R.id.number_letter_text);
        CHARACTER=findViewById(R.id.char_letter_text);


        // Enabling Button according to Strong Password

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String StrongPassword = s.toString();
                Pattern pattern1=Pattern.compile(".*[a-z]");
                if (pattern1.matcher(StrongPassword).matches())
                {
                    small.setBackgroundColor(getResources().getColor(R.color.green));
                    SMALL.setTextColor(getResources().getColor(R.color.green));
                 signup.setBackground(getResources().getDrawable(R.drawable.button_enable));
                 signup.setTextColor(getResources().getColor(R.color.white));
                 signup.setClickable(true);
                }
                else
                {
                    small.setBackgroundColor(getResources().getColor(R.color.white));
                    SMALL.setTextColor(getResources().getColor(R.color.white));
                    signup.setBackground(getResources().getDrawable(R.drawable.button_disable));
                    signup.setTextColor(getResources().getColor(R.color.grey));
                    signup.setClickable(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {



            }
        });

    }
}
