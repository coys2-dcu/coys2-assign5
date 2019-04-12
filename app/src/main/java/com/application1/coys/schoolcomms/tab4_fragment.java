package com.application1.coys.schoolcomms;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;


public class tab4_fragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab4Fragment";
    private Context mContext;
    Button buttonAddItem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_tab4_fragment, container,false);


        Button AddItem = (Button)root.findViewById(R.id.btn_add_item);
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSheet1();
            }
        });
        return root;

    }


    public void googleSheet1() {

            Intent intent = new Intent(getContext(),AddItem.class);
            startActivity(intent);
        }

    }





