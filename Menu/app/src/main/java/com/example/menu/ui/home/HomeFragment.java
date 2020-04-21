package com.example.menu.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.menu.R;
import com.example.menu.ui.gallery.GalleryFragment;

public class HomeFragment extends Fragment implements View.OnClickListener {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn1 = (Button) root.findViewById(R.id.button3);
        Button btn2 = (Button) root.findViewById(R.id.button4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.button3:
                fragment = new GalleryFragment();
                replaceFragment(fragment);
                break;

            case R.id.button4:
                fragment = new HomeFragment();
                replaceFragment(fragment);
                break;
        }
    }
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.gallery, someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
