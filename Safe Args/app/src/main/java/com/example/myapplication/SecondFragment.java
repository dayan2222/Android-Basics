package com.example.myapplication;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private SecondViewModel mViewModel;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView =  inflater.inflate(R.layout.second_fragment, container, false);

        Bundle bundle = getArguments();

        String firstName = bundle.getString("FirstName");
        String lastName = bundle.getString("LastName");

        TextView firstText = (TextView)rootView.findViewById(R.id.firstname);
        TextView lastText = (TextView)rootView.findViewById(R.id.lastname);

        firstText.setText(firstName);
        lastText.setText(lastName);



        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SecondViewModel.class);
        // TODO: Use the ViewModel
    }

}
