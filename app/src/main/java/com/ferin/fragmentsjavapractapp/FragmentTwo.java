package com.ferin.fragmentsjavapractapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

public class FragmentTwo extends Fragment {

    View view;
    TextView fragTwoReceiveTextVar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_two,container,false);

        fragTwoReceiveTextVar = view.findViewById(R.id.fragTwoReceiveText);

        getParentFragmentManager().setFragmentResultListener("dataFrom1", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                String s1 = result.getString("data");
                fragTwoReceiveTextVar.setText(s1);
            }
        });

        return view;
    }
}
