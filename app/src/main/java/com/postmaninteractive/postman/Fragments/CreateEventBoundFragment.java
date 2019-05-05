package com.postmaninteractive.postman.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.postmaninteractive.postman.R;


public class CreateEventBoundFragment extends Fragment {


    private BoundFragmentListener listener;
    private Spinner boundView, reachView;
    private String[] vals = new String[]{"", ""};
    private Button saveView;

    public interface BoundFragmentListener {
        void onBoundValuesSaved(String[] vals);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event_bound, container, false);

        boundView = (Spinner) view.findViewById(R.id.boundView);
        String[] bounds = {"Private", "Public"};
        ArrayAdapter<String> boundAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, bounds);
        boundView.setAdapter(boundAdapter);

        reachView = (Spinner) view.findViewById(R.id.reachView);
        String[] reaches = {"Within city", "Country wide", "Global", "Online"};
        ArrayAdapter<String> reachesAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, reaches);
        reachView.setAdapter(reachesAdapter);

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

        vals[0] = boundView.getSelectedItem().toString();
        vals[1] = reachView.getSelectedItem().toString();

        listener.onBoundValuesSaved(vals);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof BoundFragmentListener) {
            listener = (BoundFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " doesn't implement bound fragment listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
