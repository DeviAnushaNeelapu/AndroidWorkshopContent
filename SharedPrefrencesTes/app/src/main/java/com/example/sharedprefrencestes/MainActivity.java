package com.example.sharedprefrencestes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name,et_mobile;
    TextView tv;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = findViewById(R.id.name);
        et_mobile = findViewById(R.id.mobile);
        tv = findViewById(R.id.result);
        //working with single activity
        preferences = getPreferences(MODE_PRIVATE);
        //working with multiple activitys
        //preferences = getSharedPreferences("Prefrencefilename",MODE_PRIVATE);

    }

    public void save(View view) {
        String name = et_name.getText().toString();
        String mobile = et_mobile.getText().toString();
        SharedPreferences.Editor editor =
                preferences.edit();
        editor.putString("n",name);
        editor.putString("m",mobile);
        editor.apply();
        Toast.makeText(this,
                "Details saved...", Toast.LENGTH_SHORT).show();

    }

    public void retrive(View view) {
        String myname = preferences.getString("n","Data is not available");
        String myMobile = preferences.getString("m","Data is not Available");
        tv.setText(myname+"\n"+myMobile);
    }
}
