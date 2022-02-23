package com.example.frontpageassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordFragment extends Fragment {

                private Button fgtpwd , loginfinal;
                private EditText pwd;


     public PasswordFragment()
    {

    }


    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

           fgtpwd.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {


                       ForgotPasswordFragment forgotPasswordFragment = new ForgotPasswordFragment();
                       FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                       transaction.replace(R.id.liout, forgotPasswordFragment);
                       transaction.addToBackStack(null).commit();

               }
           });

           loginfinal.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {

                   if(TextUtils.isEmpty(pwd.getText().toString()))
                   {
                       Toast.makeText(getActivity(), " PLEASE ENTER A PASSWORD ", Toast.LENGTH_SHORT).show();
                   }

                   else
                   {

                     UserInterfaceFragment userInterfaceFragment = new UserInterfaceFragment();
                     FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                     transaction.replace(R.id.liout , userInterfaceFragment);
                     transaction.addToBackStack(null).commit();

                   Toast.makeText(getActivity(), "WELCOME", Toast.LENGTH_SHORT).show();
                 }
               }
           });

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_password, container, false);
        fgtpwd = view.findViewById(R.id.fgtpwd);
        loginfinal = view.findViewById(R.id.loginfinal);
        pwd = view.findViewById(R.id.pwd);
        return view;

    }
}