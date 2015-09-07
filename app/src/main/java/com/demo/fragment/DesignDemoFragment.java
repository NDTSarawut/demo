package com.demo.fragment;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.demo.designdemo.DesignDemoRecyclerAdapter;
import com.demo.designdemo.MainActivity;
import com.demo.designdemo.R;
import com.demo.model.DesignDemoPagerAdapter;

import java.util.ArrayList;

public class DesignDemoFragment extends Fragment {

    private static final String TAB_POSITION = "tab_position";
    private int mParam1;

    public static DesignDemoFragment newInstance(int tabPosition) {
        DesignDemoFragment fragment = new DesignDemoFragment();
        Bundle args = new Bundle();
        args.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    public DesignDemoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(TAB_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_design_demo, container, false);

//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        //collapsingToolbar.setTitle("Holy Shit");

        //Bundle args = getArguments();
        //int tabPosition = args.getInt(TAB_POSITION);

        ArrayList<String> items = new ArrayList<String>();
        for (int i = 0; i < 50; i++) {
            items.add("Tab #" + mParam1 + " item #" + i);
        }

        FragmentManager fm = getActivity().getSupportFragmentManager();

        DesignDemoPagerAdapter adapter = new DesignDemoPagerAdapter(fm);
        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new DesignDemoRecyclerAdapter(items));

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }


}
