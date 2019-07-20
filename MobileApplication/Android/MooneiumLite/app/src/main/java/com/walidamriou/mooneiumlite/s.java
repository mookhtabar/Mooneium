package com.walidamriou.mooneiumlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.graphics.Typeface;
import android.widget.TextView;

public class s extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s);


        //add fonts
        String customFont = "SymbioARLT-Regular.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        TextView t1 = (TextView) findViewById(R.id.Title);
        TextView t2 = (TextView) findViewById(R.id.change_currency);
        TextView t3 = (TextView) findViewById(R.id.change_password);
        TextView t4 = (TextView) findViewById(R.id.mookhtabar);
        TextView t5 = (TextView) findViewById(R.id.version);
        TextView t7 = (TextView) findViewById(R.id.mookhtabarwebsite);

        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
        t7.setTypeface(typeface);

    }

        public void change_currency_btn(View view){

            //Create your Intent Here
            Intent i1 = new Intent(s.this,s_currency.class);
            startActivity(i1);

        }

        public void change_password_btn(View view){
            //Create your Intent Here
            Intent i2 = new Intent(s.this,s_password.class);
            startActivity(i2);
        }

}
