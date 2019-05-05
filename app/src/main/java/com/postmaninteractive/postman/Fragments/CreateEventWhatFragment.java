package com.postmaninteractive.postman.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.postmaninteractive.postman.R;


public class CreateEventWhatFragment extends Fragment {

    public interface WhatFragmentListener {
        void onWhatValuesSaved(String[] vals);
    }

    private Spinner typeView;
    private EditText titleView;
    private EditText messageView;
    private EditText instructionsView;
    private Button saveView;
    private WhatFragmentListener listener;
    private String[] vals = new String[]{"", "", "", ""};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_create_event_what, container, false);
        typeView = (Spinner) view.findViewById(R.id.typeView);
        titleView = (EditText) view.findViewById(R.id.titleView);
        messageView = (EditText) view.findViewById(R.id.messageView);
        instructionsView = (EditText) view.findViewById(R.id.instructionsView);
        saveView = (Button) view.findViewById(R.id.saveView);


        String[] types = {"Sports", "Food and Dining"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, types);
        typeView.setAdapter(adapter);

        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        return view;
    }

    private void save() {

        vals[0] = typeView.getSelectedItem().toString();
        vals[1] = titleView.getText().toString();
        vals[2] = messageView.getText().toString();
        vals[3] = instructionsView.getText().toString();

        listener.onWhatValuesSaved(vals);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WhatFragmentListener) {
            listener = (WhatFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " doesn't implement what fragment listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

        listener = null;
    }
}
