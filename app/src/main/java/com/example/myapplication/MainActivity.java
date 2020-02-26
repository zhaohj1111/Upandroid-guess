package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int number=(int)(Math.random()*1000);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView Image1=(ImageView)findViewById(R.id.IM1);
        final ImageView Image2=(ImageView)findViewById(R.id.IM2);
        final ImageView Image3=(ImageView)findViewById(R.id.IM3);

        final EditText editText=(EditText)findViewById(R.id.GuessInput);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String str=s.toString();
                int Guess=Integer.valueOf(str).intValue();
                String big="big";
                String small="small";
                String equ="YOU GUESS IT!CONGRATULATION!";

                if(!editText.getText().toString().equals("")){
                    if(Guess>number){
                        Toast.makeText(getApplicationContext(),big,Toast.LENGTH_SHORT).show();
                        Image3.setVisibility(View.INVISIBLE);
                        Image1.setVisibility(View.VISIBLE);
                    }
                    else if(Guess==number)
                    {
                        Toast.makeText(getApplicationContext(),equ,Toast.LENGTH_SHORT).show();
                        Image3.setVisibility(View.INVISIBLE);
                        Image1.setVisibility(View.INVISIBLE);
                    }
                    else if(Guess<number){
                        Toast.makeText(getApplicationContext(),small,Toast.LENGTH_SHORT).show();
                        Image3.setVisibility(View.VISIBLE);
                        Image1.setVisibility(View.INVISIBLE);
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


}
