package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Fragment1 extends Fragment {

    private Button choiceBtn;
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    private DAOEvents helper;

    @Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Fragment1View = inflater.inflate(R.layout.fragment_1, container,false);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");

        Bundle bundle = this.getArguments();
        Long idS = bundle.getLong("idD");
        Boolean isFirst = bundle.getBoolean("isFirst");

        EventData currentEvent = helper.searchEvent(idS);



        choiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Long idD = currentEvent.getChoice1id();
                if (idD == -3L) {
                    missingEvent(idS, isFirst);
                } else if (idD == -2L) {
                    Intent intent = new Intent(getActivity(), MainActivity.class);
                    startActivity(intent);
                } else {
                    EventData newEvent = helper.searchEvent(idD);
                    if (newEvent.getIdDB().equals(-4L)) {
                        missingEvent(idS, isFirst);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putLong("idD",idD);
                        bundle.putBoolean("isFirst",isFirst);

                        if (newEvent.getChoice2id().equals(-5L)) {
                            // Update all variables
                        } else {
                            fragment2.setArguments(bundle);
                            FragmentManager fragmentManager = getSupportFragmentManager();
                            FragmentTransaction transaction = fragmentManager.beginTransaction();
                            transaction.replace(R.id.fragment, fragment2);
                            transaction.commit();
                        }
                    }
                }
            }
        });
        // Inflate the layout for this fragment
        return Fragment1View;
    }
    void missingEvent(Long idS, Boolean isFirst) {
        // Say event not yet defined, ask if want to create an event, or redefine destination of this choice
        Long newId = 0L; //result from either creating event or redefining destination

        EventData sourceEvent = helper.searchEvent(idS);
        helper.editChoiceID(sourceEvent,newId,isFirst);// After editing, make sure returns to current event.
    }
}
