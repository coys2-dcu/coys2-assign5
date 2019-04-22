package com.application1.coys.schoolcomms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class tab3_fragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab3Fragment";
    private Context mContext;
    Button buttonAddItem;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_tab3_fragment, container,false);


        Button AddItem = (Button)root.findViewById(R.id.btn_add_item);
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSheet1();
            }
        });


        Button gs3 = (Button) root.findViewById(R.id.gs3);
        gs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gsheet();
            }
        });

        return root;
    }



    public void googleSheet1() {

            Intent intent = new Intent(getContext(),AddItem.class);
            startActivity(intent);
        }

    public void gsheet() {
        // Do something in response to button
        Intent intent = new Intent(getContext(), googleSheet.class);
        startActivity(intent);
    }

    }





