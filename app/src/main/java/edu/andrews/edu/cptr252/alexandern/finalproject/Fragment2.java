package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {

    @Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Fragment2View = inflater.inflate(R.layout.fragment_1, container,false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");

        Bundle bundle = this.getArguments();
        Long idD = bundle.getLong("idD");
        Boolean isFirst = bundle.getBoolean("isFirst");




        // Inflate the layout for this fragment
        return Fragment2View;
    }
}