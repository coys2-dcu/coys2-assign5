package com.application1.coys.schoolcomms;

/**
 * Copyright [2019] [Stephen Coy]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import java.util.Map;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


/**
 *
 * this class adds a request booking to the google sheet
 *Class (or Method) contains code adapted from URL:
 * https://developer.android.com/training/volley/ Permission:  Apache License. Retrieved on:  April 2019
 *https://www.crazycodersclub.com/android/how-to-use-google-sheet-as-database-for-android-app-1-insert-operation/
 * https://www.crazycodersclub.com/android/using-google-spread-sheet-as-database-for-android-application-part-1/
 */
public class AddItem extends AppCompatActivity implements View.OnClickListener {
    EditText editTextUserName,editTextBookDate,editTextTime,editTextRoom;
    Button buttonAddItem;

    /**
     * initialise the view objects
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_item);

        editTextUserName = (EditText)findViewById(R.id.et_user_name);
        editTextBookDate = (EditText)findViewById(R.id.et_book_date);
        editTextTime = (EditText)findViewById(R.id.et_Time);
        editTextRoom = (EditText)findViewById(R.id.et_Room);
        buttonAddItem = (Button)findViewById(R.id.btn_add_item);
        buttonAddItem.setOnClickListener(this);
    }

    //This is the part where data is transferred from Your Android phone to Sheet by using HTTP Rest API calls

    /**
     * create strings from edit text field objects
     */
    private void   addItemToSheet() {

        final ProgressDialog loading = ProgressDialog.show(this,"Adding Item","Please wait");
        final String name = editTextUserName.getText().toString().trim();
        final String bdate = editTextBookDate.getText().toString().trim();
        final String time = editTextTime.getText().toString().trim();
        final String room = editTextRoom.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbyitJJwwBRRFlm1rxC2fiDNLEk8x6nVCarHbnRLs9WZ7iKAk8oh/exec",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        loading.dismiss();
                        Toast.makeText(AddItem.this,response,Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                        startActivity(intent);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        ) {
            /**
             * pass params to appscript
             * @return
             */
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();

                //here we pass params
                parmas.put("action","addItem");
                parmas.put("name",name);
                parmas.put("bdate",bdate);
                parmas.put("time",time);
                parmas.put("room",room);

                return parmas;
            }
        };

        int socketTimeOut = 50000;//  50 seconds

        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);

    }
    @Override
    public void onClick(View v) {

        if(v==buttonAddItem){
            addItemToSheet();

            //Define what to do when button is clicked - add items to sheet
        }
    }
}