package com.application1.coys.schoolcomms;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.annotations.Nullable;

import androidx.fragment.app.Fragment;


public class tab2_fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab2Fragment";
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_tab2_fragment, container,false);

        return root;

    }

    @Override
    public void onStart() {
        super.onStart();



    }
}


