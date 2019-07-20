package com.walidamriou.mooneiumlite;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;
import android.widget.EditText;

import com.walidamriou.mooneiumlite.database.data;
import com.walidamriou.mooneiumlite.database.dataBaseHelper;

import java.io.File;

import static com.walidamriou.mooneiumlite.R.mipmap.ic_launcher;


public class MainActivity extends AppCompatActivity {

    String Thecurrencyomlaa;
    String TheMoneya;
    double TheMoney_doublea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //add logo in the bar with the name of the app
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);


        //add fonts
        String customFont = "SymbioARLT-Regular.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        TextView t1 = (TextView) findViewById(R.id.textView3);
        TextView t2 = (TextView) findViewById(R.id.dataD);
        TextView t3 = (TextView) findViewById(R.id.currencyomla);
        TextView t4 = (TextView) findViewById(R.id.textView);
        TextView t5 = (TextView) findViewById(R.id.textView4);
        TextView t7 = (TextView) findViewById(R.id.save);
        TextView t8 = (TextView) findViewById(R.id.button4);

        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
        t7.setTypeface(typeface);
        t8.setTypeface(typeface);

        //get the Money and the Currency

        dataBaseHelper d = new dataBaseHelper(this);
        data da = new data();
        da = d.getData(1);
        Thecurrencyomlaa = da.getCurrency();
        TheMoney_doublea = da.getMoney();



        //declare the view
        TextView myAwesomeTextView = (TextView)findViewById(R.id.dataD);
        TextView currencytext = (TextView)findViewById(R.id.currencyomla);

        //declare the input
        EditText txtname = (EditText)findViewById(R.id.datawrite);





        //desplay the valure

        currencytext.setText(Thecurrencyomlaa);

        TheMoneya = Double.toString(TheMoney_doublea);
        myAwesomeTextView.setText(TheMoneya);



    }



    // part of remove

    public void removein(View view) {

        String TheMoney;
        double TheMoney_double;

        //declare the view
        TextView myAwesomeTextView = (TextView)findViewById(R.id.dataD);

        //declare the input
        EditText txtname = (EditText)findViewById(R.id.datawrite);


        //get the corrent valure from the database
        dataBaseHelper d = new dataBaseHelper(this);
        data da = new data();
        da = d.getData(1);
        double DATAcor = da.getMoney();

        //get the inpute valure
        String b      =  txtname.getText().toString();
        double num1 = Double.parseDouble(b);

        //the operation
        double a1 = DATAcor * 100;
        double a2 = num1 * 100;
        double a3 = a1 - a2;
        double a4 = a3 / 100;
        double subresulta = (Math.round(a4 * 100.0) / 100.0);

        //save the data to database
        d.updateMONEY(1,subresulta);

        //view the data
        da = d.getData(1);
        TheMoney_double = da.getMoney();
        TheMoney = Double.toString(TheMoney_double);
        myAwesomeTextView.setText(TheMoney);


    }

    //part of add

    public void addin(View view) {
        String TheMoney;
        double TheMoney_double;

        //declare the view
        TextView myAwesomeTextView = (TextView)findViewById(R.id.dataD);

        //declare the input
        EditText txtname = (EditText)findViewById(R.id.datawrite);


        //get the corrent valure from the file
        dataBaseHelper d = new dataBaseHelper(this);
        data da = new data();
        da = d.getData(1);
        double DATAcor = da.getMoney();

        //get the inpute valure
        String b      =  txtname.getText().toString();
        double num1 = Double.parseDouble(b);

        //the operation
        double a1 = DATAcor * 100;
        double a2 = num1 * 100;
        double a3 = a1 + a2;
        double a4 = a3 / 100;
        double subresulta = (Math.round(a4 * 100.0) / 100.0);

        //save the data to file
        d.updateMONEY(1,subresulta);

        //view the data
        da = d.getData(1);
        TheMoney_double = da.getMoney();
        TheMoney = Double.toString(TheMoney_double);
        myAwesomeTextView.setText(TheMoney);

    }



    public void settings_button(View view) {

            //Create your Intent Here
            Intent i = new Intent(MainActivity.this,s.class);
            startActivity(i);

    }

}
