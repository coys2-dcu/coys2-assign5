package com.application1.coys.schoolcomms;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class tab3_fragment extends Fragment {
    //
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String TAG = "Tab3Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_tab3_fragment, container, false);

        SharedPreferences colAdd = getActivity().getPreferences(Context.MODE_PRIVATE);
        colAdd.edit().remove("collection_address").commit();

        SharedPreferences product = getActivity().getPreferences(Context.MODE_PRIVATE);
        product.edit().remove("product_selection").commit();
        return root;
    }


        @Override
        public void onStart() {
            super.onStart();

        }


    }



