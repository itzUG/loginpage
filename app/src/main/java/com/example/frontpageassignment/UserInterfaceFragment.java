package com.example.frontpageassignment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class UserInterfaceFragment extends Fragment {

    private Button firstPage;


    public UserInterfaceFragment() {

    }

    @Override
    public void onViewCreated (View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        firstPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginStartFragment loginStartFragment = new LoginStartFragment();
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.liout , loginStartFragment);
                transaction.addToBackStack(null).commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_user_interface, container, false);
         firstPage = view.findViewById(R.id.firstPage);
        return  view;
    }
}