package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
//    @Override
    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View Fragment2View = inflater.inflate(R.layout.event_branching_path, container,false);

        DAOEvents helper = new DAOEvents(getContext());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");

        Bundle bundle = this.getArguments();
        EventData sourEvent = bundle.getParcelable("sourEvent");
        EventData destEvent = bundle.getParcelable("destEvent");
        Boolean isFirst = bundle.getBoolean("isFirst");

        EventData currentEvent = destEvent;

        TextView eventText = getActivity().findViewById(R.id.event_text);
        eventText.setText("currentEvent.getText()");
        Button choice1Btn = getActivity().findViewById(R.id.choice_1);
        choice1Btn.setText(currentEvent.getChoice1txt());
        Button choice2Btn = getActivity().findViewById(R.id.choice_2);
        choice2Btn.setText(currentEvent.getChoice1txt());

        EventData choice1 = helper.searchEvent(currentEvent.getChoice1id());
        EventData choice2 = helper.searchEvent(currentEvent.getChoice2id());

        choice1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                bundle.putParcelable("sourEvent",currentEvent);
                bundle.putParcelable("destEvent",choice1);
                bundle.putBoolean("isFirst",true);
                // The child fragment needs to still set the result on its parent fragment manager.
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
        choice2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                bundle.putParcelable("sourEvent",currentEvent);
                bundle.putParcelable("destEvent",choice2);
                bundle.putBoolean("isFirst",false);
                // The child fragment needs to still set the result on its parent fragment manager.
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
        // Inflate the layout for this fragment
        return Fragment2View;
    }
}