package com.application1.coys.schoolcomms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.database.annotations.Nullable;

import androidx.fragment.app.Fragment;


public class tab1_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab1Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tab1_fragment, container, false);

        Button gs = (Button) root.findViewById(R.id.gs);
        gs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gsheet();
            }
        });

        Button AddItem = (Button)root.findViewById(R.id.btn_add_item1);
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSheet1();
            }
        });

            return root;
    }

    public void gsheet() {
      // Do something in response to button
      Intent intent = new Intent(getContext(), googleSheet.class);
      startActivity(intent);
        }

    public void googleSheet1() {

        Intent intent = new Intent(getContext(),AddItem.class);
        startActivity(intent);
    }
}



