package com.postmaninteractive.postman.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.postmaninteractive.postman.R;

public class CreateEventWhereFragment extends Fragment {

    private WhereFragmentListener listener;
    private EditText addressView;
    private EditText cityView;
    private EditText countryView;
    private String[] vals = new String[]{"", "", ""};
    private Button saveView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event_where, container, false);
        addressView = view.findViewById(R.id.addressView);
        cityView = view.findViewById(R.id.cityView);
        countryView = view.findViewById(R.id.countryView);
        saveView = view.findViewById(R.id.saveView);
        saveView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        return view;
    }

    private void save() {

        vals[0] = addressView.getText().toString();
        vals[1] = cityView.getText().toString();
        vals[2] = countryView.getText().toString();
        listener.onWhereValuesSaved(vals);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof WhereFragmentListener) {
            listener = (WhereFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " doesn't implement where fragment listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


    private enum VAL_TYPES {
        ADDRESS, CITY, COUNTRY
    }

    public interface WhereFragmentListener {
        void onWhereValuesSaved(String[] vals);
    }
}
