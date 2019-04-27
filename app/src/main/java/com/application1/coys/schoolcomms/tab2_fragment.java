package com.application1.coys.schoolcomms;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.google.firebase.database.annotations.Nullable;
import androidx.fragment.app.Fragment;

/**
 * second computer room fragment
 */
public class tab2_fragment extends Fragment {

    // the fragment initialization parameters
    private static final String TAG = "Tab2Fragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        final View root = inflater.inflate(R.layout.fragment_tab2_fragment, container,false);

        /**
         * set button to view bookings
         */
        Button gs2 = (Button) root.findViewById(R.id.gs2);
        gs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gsheet();
            }
        });
/**
 * set button to add request
 */
        Button AddItem = (Button)root.findViewById(R.id.btn_add_item2);
        AddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                googleSheet1();
            }
        });

        return root;
    }

    /**
     * call google sheet class to view bookings using google sheets api
     */
    public void gsheet() {
        // Do something in response to button
        Intent intent = new Intent(getContext(), googleSheet.class);
        startActivity(intent);
    }

    /**
     * set button to add request
     */
    public void googleSheet1() {

        Intent intent = new Intent(getContext(),AddItem.class);
        startActivity(intent);
    }
}


