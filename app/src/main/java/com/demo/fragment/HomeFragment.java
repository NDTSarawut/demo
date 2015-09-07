package com.demo.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.demo.designdemo.MainActivity;
import com.demo.designdemo.R;

public class HomeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private int mParam1;

    public static HomeFragment newInstance(int tabPosition) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, tabPosition);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((MainActivity) getActivity()).getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle("Home");

        return view;
    }

}
