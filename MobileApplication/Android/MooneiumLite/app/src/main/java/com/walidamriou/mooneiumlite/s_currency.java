package com.walidamriou.mooneiumlite;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.walidamriou.mooneiumlite.database.data;
import com.walidamriou.mooneiumlite.database.dataBaseHelper;

public class s_currency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_currency);

        //add fonts
        String customFont = "SymbioARLT-Regular.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        TextView t1 = (TextView) findViewById(R.id.text4);
        TextView t2 = (TextView) findViewById(R.id.NowCurrency);
        TextView t3 = (TextView) findViewById(R.id.ValureCurrency);
        TextView t4 = (TextView) findViewById(R.id.messeger);
        TextView t5 = (TextView) findViewById(R.id.text);
        TextView t6 = (EditText) findViewById(R.id.oldpass);
        TextView t7 = (EditText) findViewById(R.id.currency);
        TextView t8 = (TextView) findViewById(R.id.change_currency_btn);


        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
        t6.setTypeface(typeface);
        t7.setTypeface(typeface);
        t8.setTypeface(typeface);


        //open the database and get the corrent valure
        dataBaseHelper d = new dataBaseHelper(this);
        data da = new data();
        da = d.getData(1);
        String currencyold = da.getCurrency();

        //declaer the ValureCurrency to print current valure in the screen
        t3.setText(currencyold);
    }




    public void savedata(View view) {

        //open the database and get the corrent valure
        dataBaseHelper d = new dataBaseHelper(this);
        data da = new data();
        da = d.getData(1);
        int pass = da.getPassword();
        String currencyold = da.getCurrency();

        //declaer the messger
        TextView messeger = (TextView)findViewById(R.id.messeger);

        TextView printCurrency = (TextView)findViewById(R.id.ValureCurrency);
        printCurrency.setText(currencyold);

        //declare the input of the current valure
        EditText oldpassa = (EditText)findViewById(R.id.oldpass);
        String oldpassaa      =  oldpassa.getText().toString();
        int oldpass = Integer.parseInt(String.valueOf(oldpassaa));

        if (oldpass != pass){
            //print "rewrite the old pass again "
            messeger.setText("الرقم السري خاطئ");
        }
        else {
            //get the input new pass
            EditText newcurrencyy = (EditText)findViewById(R.id.currency);
            String newcurrency      =  newcurrencyy.getText().toString();
            //String newcurrencyyy = Integer.parseInt(String.valueOf(newcurrency));

            //save the new pass to database
            d.updateDOURRENCY(1,newcurrency);

            messeger.setText("تم تغيير إسم العملة بنجاح .. أعد تشغيل التطبيق لتطبيق التغييرات");


        }



    }
}
