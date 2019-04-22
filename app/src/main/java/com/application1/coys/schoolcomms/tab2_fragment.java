package com.application1.coys.schoolcomms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.firebase.database.annotations.Nullable;

import androidx.fragment.app.Fragment;


public class tab2_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab2Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_tab2_fragment, container,false);

        Button gs2 = (Button) root.findViewById(R.id.gs2);
        gs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gsheet();
            }
        });

        Button AddItem = (Button)root.findViewById(R.id.btn_add_item2);
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSheet1();
            }
        });
       //LinearLayout tgallery = root.findViewById(R.id.timetablegallery);
        //LayoutInflater inflater = LayoutInflater.from(getActivity());
        //LinearLayout innerLayout = new LinearLayout(getActivity());


        //View view = inflater.inflate(R.layout.scroll_item, tgallery, false);

            //TextView textView = view.findViewById(R.id.scrollText);
            //textView.setText("Item");

            //ImageView imageView = view.findViewById(R.id.scrollImage);
            //imageView.setImageResource(R.drawable.ic_launcher_background);

            //tgallery.addView(view);

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


