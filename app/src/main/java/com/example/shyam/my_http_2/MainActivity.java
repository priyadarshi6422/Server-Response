package com.example.shyam.my_http_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =MainActivity.class.getName() ;
    Button mButton;
    EditText mEdit;
    ProgressBar mprogress;
    TextView mac;
    String msg;
    String url= "https://android-club-project.herokuapp.com/upload_details?";
    String mac1="94:92:bc:46:84:af";
    TextView textView2;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRrequest;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.send);
        mEdit   = (EditText)findViewById(R.id.reg);
        textView2 = (TextView)findViewById(R.id.textView2);
        //mprogress=(ProgressBar) findViewById(R.id.progressBar);
        //mprogress.setVisibility(View.GONE);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mprogress.setVisibility(View.VISIBLE);
                msg = mEdit.getText().toString();
                url += "reg_no=";
                url += msg;
                url += "&mac=";
                url += mac1;
                sentRequestAndPrintResponse();

            }
        });

    }

    private void sentRequestAndPrintResponse() {
        mRequestQueue= Volley.newRequestQueue(this);
        mStringRrequest= new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i(TAG,response.toString());
                textView2.setText("output is:" + response.toString());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i(TAG,error.toString());

            }
        }

        );
        mRequestQueue.add(mStringRrequest);
    }
}
