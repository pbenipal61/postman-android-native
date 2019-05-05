package com.postmaninteractive.postman.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TimePicker;

import com.postmaninteractive.postman.R;


public class CreateEventWhenFragment extends Fragment {

    public interface WhenFragmentListener {
        void onWhenValuesChanges(int[] vals);
    }

    private WhenFragmentListener listener;
    private CalendarView calendarView;
    private TimePicker timeView;
    private Button saveView;
    private int[] vals = new int[]{0, 0, 0, 0, 0};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_event_when, container, false);

        calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        timeView = (TimePicker) view.findViewById(R.id.timeView);
        saveView = (Button) view.findViewById(R.id.saveView);
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
        return view;
    }

    private void save() {

        listener.onWhenValuesChanges(vals);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof WhenFragmentListener) {
            listener = (WhenFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " doesn't implement WhenFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
