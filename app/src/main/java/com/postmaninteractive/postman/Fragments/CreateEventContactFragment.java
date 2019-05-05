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


public class CreateEventContactFragment extends Fragment {


    private ContactFragmentListener listener;
    private EditText contactNameView;
    private EditText contactPhoneView;
    private EditText contactEmailView;
    private String[] vals = new String[]{"", "", ""};
    private Button saveView;

    public interface ContactFragmentListener {
        void onContactValuesSaved(String[] vals);
    }

    private enum VAL_TYPES {
        ADDRESS, CITY, COUNTRY
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_event_contact, container, false);
        contactNameView = (EditText) view.findViewById(R.id.contactNameView);
        contactPhoneView = (EditText) view.findViewById(R.id.contactPhoneView);
        contactEmailView = (EditText) view.findViewById(R.id.contactEmailView);
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

        vals[0] = contactNameView.getText().toString();
        vals[1] = contactPhoneView.getText().toString();
        vals[2] = contactEmailView.getText().toString();
        listener.onContactValuesSaved(vals);

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ContactFragmentListener) {
            listener = (ContactFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString() + " doesn't implement contact fragment listener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
