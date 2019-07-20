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

import com.walidamriou.mooneiumlite.database.dataBaseHelper;
import com.walidamriou.mooneiumlite.database.data;

import static com.walidamriou.mooneiumlite.R.mipmap.ic_launcher;

public class password extends AppCompatActivity {

    int TheKey,TheID;
    private Boolean firstTime = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        //add logo in the bar with the name of the app
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);



            if (firstTime == null) {
                SharedPreferences mPreferences = this.getSharedPreferences("first_time", Context.MODE_PRIVATE);
                firstTime = mPreferences.getBoolean("firstTime", true);
                if (firstTime) {
                    SharedPreferences.Editor editor = mPreferences.edit();
                    editor.putBoolean("firstTime", false);
                    editor.commit();
                }
            }



        //database make
        dataBaseHelper d = new dataBaseHelper(this);
        if (firstTime){
        d.insertData(1,8888,0.0,"دينار جزائري");
        }

        String customFont = "SymbioARLT-Regular.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        TextView t1 = (TextView) findViewById(R.id.textView7);
        TextView t2 = (TextView) findViewById(R.id.textView6);
        TextView t3 = (TextView) findViewById(R.id.button);

        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);


        data da = new data();
        da = d.getData(1);
        TheKey = da.getPassword();

    }

    public void login(View view) {

        //declare the input
        EditText txtname = (EditText)findViewById(R.id.pass);

        //get the inpute valure
        String b      =  txtname.getText().toString();
        int TheKeyinput = Integer.parseInt(b);

        if (TheKey==TheKeyinput){
            //Create your Intent Here
            Intent i = new Intent(password.this,MainActivity.class);
            startActivity(i);
        }
        else {

        }


    }
}
