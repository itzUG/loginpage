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
import android.widget.Toast;

public class ForgotPasswordFragment extends Fragment {


    private Button sendOtp;
    private EditText inmail;


    @Override
    public void onViewCreated( View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = inmail.getText().toString().trim();

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
                        Toast.makeText(getActivity(), "CHECK YOUR MAIL FOR THE PASSWORD ", Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    public ForgotPasswordFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_forgot_password, container, false);
        sendOtp = view.findViewById(R.id.sendOtp);
        inmail = view.findViewById(R.id.inmail);
        return view;
    }
}