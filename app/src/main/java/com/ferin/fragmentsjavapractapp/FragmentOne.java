package com.ferin.fragmentsjavapractapp;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FragmentOne extends Fragment {


    EditText fragOneEnterTextVar;
    TextView fragOneTextDisplayVar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one,container,false);

        fragOneEnterTextVar = view.findViewById(R.id.fragOneEnterText);
        fragOneTextDisplayVar = view.findViewById(R.id.fragOneTextDisplay);

        view.findViewById(R.id.fragOneButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = fragOneEnterTextVar.getText().toString();
//                fragOneTextDisplayVar.setText(s1);
                Bundle bundle = new Bundle();
                bundle.putString("data",s1);
                getParentFragmentManager().setFragmentResult("dataFrom1",bundle);
//                goToFrag2(new FragmentTwo());
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentTwo()).commit();
            }
        });

        return view;
    }

//    public void goToFrag2(Fragment fragment){
//        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frameLayout,fragment);
//        fragmentTransaction.commit();
//    }
}
