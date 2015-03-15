package com.learning.vitaliylakusta.learnmixer1_phone;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.learning.vitaliylakusta.learnmixer1_phone.dummy.DummyContent;

public class LearningResourcesFragment extends Fragment {
    private ListView resourcesListView;
    private ResourceAdapter resourceAdapter;

    public LearningResourcesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        resourcesListView = (ListView) view.findViewById(R.id.resourceTitle);
        String[] resourcesList = { "Learning resource 1", "Learning resource 2", "Learning resource 3" };
        resourceAdapter = new ResourceAdapter(this.getActivity(), resourcesList);
        resourcesListView.setAdapter(resourceAdapter);

        return view;
    }
}