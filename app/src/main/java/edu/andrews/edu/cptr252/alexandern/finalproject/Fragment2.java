package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View Fragment2View = inflater.inflate(R.layout.fragment2, container,false);

        DAOEvents helper = new DAOEvents(getContext());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","default");

        Bundle bundle = this.getArguments();
        EventData sourEvent = bundle.getParcelable("sourEvent");
        EventData destEvent = bundle.getParcelable("destEvent");
        Boolean isFirst = bundle.getBoolean("isFirst");

        EventData currentEvent = destEvent;

        String regex = "\\(heroName\\)";
        TextView eventText = Fragment2View.findViewById(R.id.event_text);
        eventText.setText(currentEvent.getText().replaceAll(regex, name));
        Button choice1Btn = Fragment2View.findViewById(R.id.choice_1);
        choice1Btn.setText(currentEvent.getChoice1txt().replaceAll(regex, name));
        Button choice2Btn = Fragment2View.findViewById(R.id.choice_2);
        choice2Btn.setText(currentEvent.getChoice2txt().replaceAll(regex, name));

        choice1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData choice1 = helper.searchEvent(currentEvent.getChoice1id());
                Bundle result = new Bundle();
                result.putParcelable("sourEvent",currentEvent);
                result.putParcelable("destEvent",choice1);
                result.putBoolean("isFirst",true);
                // The child fragment needs to still set the result on its parent fragment manager.
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
        choice2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData choice2 = helper.searchEvent(currentEvent.getChoice2id());
                Bundle result = new Bundle();
                result.putParcelable("sourEvent",currentEvent);
                result.putParcelable("destEvent",choice2);
                result.putBoolean("isFirst",false);
                // The child fragment needs to still set the result on its parent fragment manager.
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
        // Inflate the layout for this fragment
        return Fragment2View;
    }
}