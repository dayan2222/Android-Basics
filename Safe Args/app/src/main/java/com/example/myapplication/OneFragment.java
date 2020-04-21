package com.example.myapplication;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class OneFragment extends Fragment {
    EditText firstName,lastName;
    Button buttonsubmit;

    private OneViewModel mViewModel;

    public static OneFragment newInstance() {
        return new OneFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootview =  inflater.inflate(R.layout.one_fragment, container, false);

        firstName = (EditText) rootview.findViewById(R.id.firstname);
        lastName = (EditText) rootview.findViewById(R.id.lastname);

        buttonsubmit = (Button)rootview.findViewById(R.id.submitbutton);

        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = firstName.getText().toString();
                String last = lastName.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("FirstName",first);
                bundle.putString("LastName",last);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);

                fragmentTransaction.replace(R.id.frame_container,secondFragment);
                fragmentTransaction.commit();
            }
        });



        return rootview;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(OneViewModel.class);
        // TODO: Use the ViewModel
    }

}
