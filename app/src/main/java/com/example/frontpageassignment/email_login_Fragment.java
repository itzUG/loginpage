package com.example.frontpageassignment;

import android.app.Activity;
import android.graphics.Color;
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
import android.widget.Toast;

public class email_login_Fragment extends Fragment {

    private Button signinmail;
    private Button create;
    private EditText enteremail;

    public email_login_Fragment()
    {
    }

    @Override
    public void onViewCreated(@NonNull  View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        signinmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              String text = enteremail.getText().toString().trim();
                if(text.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(text).matches())
                   {
                       Toast.makeText(getActivity(), "PLEASE ENTER A VALID EMAIL ID", Toast.LENGTH_SHORT).show();
                   }
                else
                  {
                       PasswordFragment passwordFragment = new PasswordFragment();
                       FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                       transaction.replace(R.id.liout, passwordFragment);
                       transaction.addToBackStack(null).commit();
                  }
            }
        });


        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                account_creation_fragment acf = new account_creation_fragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.liout , acf);
                transaction.addToBackStack(null).commit();
            }
        });


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_email_login_, container, false);
        signinmail = view.findViewById(R.id.signinmail);
        create = view.findViewById(R.id.create);
        enteremail = view.findViewById(R.id.enteremail);
        return view;


    }
}