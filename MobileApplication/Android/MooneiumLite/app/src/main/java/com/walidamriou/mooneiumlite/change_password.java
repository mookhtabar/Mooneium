package com.walidamriou.mooneiumlite;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.walidamriou.mooneiumlite.database.data;
import com.walidamriou.mooneiumlite.database.dataBaseHelper;

public class change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        //add fonts
        String customFont = "SymbioARLT-Regular.ttf";
        Typeface typeface = Typeface.createFromAsset(getAssets(), customFont);
        TextView t1 = (TextView) findViewById(R.id.title3);
        TextView t2 = (TextView) findViewById(R.id.oldpass3);
        TextView t3 = (TextView) findViewById(R.id.newpass);
        TextView t4 = (TextView) findViewById(R.id.savedata);
        TextView t5 = (TextView) findViewById(R.id.messeger);



        t1.setTypeface(typeface);
        t2.setTypeface(typeface);
        t3.setTypeface(typeface);
        t4.setTypeface(typeface);
        t5.setTypeface(typeface);
    }



    public void savedata(View view) {

        //declaer the messger
        TextView messeger = (TextView)findViewById(R.id.messeger);


        //open the database and get the corrent valure
        dataBaseHelper d = new dataBaseHelper(this);
        data da = new data();
        da = d.getData(1);
        int pass = da.getPassword();

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
            EditText newpass = (EditText)findViewById(R.id.newpass);
            String newpassor      =  newpass.getText().toString();
            int newpassord = Integer.parseInt(String.valueOf(newpassor));

            //save the new pass to database
            d.updatePASSWORD(1,newpassord);

        }



    }
}
