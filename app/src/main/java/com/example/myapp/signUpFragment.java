package com.example.myapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class signUpFragment extends Fragment {

    public signUpFragment() {
        // Required empty public constructor
    }

private TextView alreadyhaveanaccount;
    private FrameLayout parentFrameLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_sign_up, container, false);
        alreadyhaveanaccount=view.findViewById(R.id.Already_have_an_account);
        parentFrameLayout=getActivity().findViewById(R.id.register_framelayout);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        alreadyhaveanaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setFragment(new signInFragment());
            }

            private void setFragment(Fragment fragment) {
                FragmentTransaction fragmentTransaction=getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(parentFrameLayout.getId(),fragment);
                fragmentTransaction.setCustomAnimations(R.anim.slide_from_left,R.anim.slideout_from_right);
                fragmentTransaction.commit();
            }
        });
    }
}
