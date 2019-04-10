package com.application1.coys.schoolcomms;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class tab4_fragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab4Fragment";
    private Context mContext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_tab4_fragment, container,false);


        SharedPreferences settings = getActivity().getSharedPreferences("collection_address", Context.MODE_PRIVATE);
        settings.edit().clear().commit();
        return root;

    }

    @Override
    public void onStart() {
        super.onStart();

    }

    }



