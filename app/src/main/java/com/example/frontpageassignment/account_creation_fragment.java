package com.example.frontpageassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class account_creation_fragment extends Fragment {
    
    private Button accSignup;
    private EditText namecreate , emcreate , pword;


    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        accSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailchechker = emcreate.getText().toString().trim();

                if (TextUtils.isEmpty(namecreate.getText().toString())) {
                    Toast.makeText(getActivity(), " PLEASE ENTER YOUR NAME", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pword.getText().toString())) {
                    Toast.makeText(getActivity(), " PLEASE ENTER A PASSWORD ", Toast.LENGTH_SHORT).show();
                } else if (emailchechker.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(emailchechker).matches()) {
                    Toast.makeText(getActivity(), "PLEASE ENTER A VALID EMAIL-ID", Toast.LENGTH_SHORT).show();
                } else {

                    email_login_Fragment emf = new email_login_Fragment();
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction.replace(R.id.liout, emf);
                    transaction.addToBackStack(null).commit();

                    Toast.makeText(getActivity(), "ACCOUNT CREATED ", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    public account_creation_fragment() {
        
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_account_creation, container, false);
        accSignup = view.findViewById(R.id.accSignup);
        namecreate = view.findViewById(R.id.namecreate);
        pword = view.findViewById(R.id.pword);
        emcreate = view.findViewById(R.id.emcreate);

        return view;
    }
}