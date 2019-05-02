package com.application1.coys.schoolcomms;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

/**
 * book room activity where the user can view timetables and book a computer room
 */
public class bookRoom extends AppCompatActivity {

    private static final String TAG = "Book Room";
    private SectionsPageAdapter msectionsPageAdpater;
    private ViewPager mViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_room);
        msectionsPageAdpater =  new SectionsPageAdapter(getSupportFragmentManager());
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }

    /**
     * create fragments
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new tab1_fragment(), "Room1");
        adapter.addFragment(new tab2_fragment(), "Room2");
        adapter.addFragment(new tab3_fragment(), "Room3");
        viewPager.setAdapter(adapter);
    }

}
