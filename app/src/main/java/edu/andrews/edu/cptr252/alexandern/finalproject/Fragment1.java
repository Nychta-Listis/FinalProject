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

public class Fragment1 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View Fragment1View = inflater.inflate(R.layout.fragment1, container,false);

        DAOEvents helper = new DAOEvents(getContext());

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("name", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");

        Bundle bundle = this.getArguments();
        EventData sourEvent = bundle.getParcelable("sourEvent");
        EventData destEvent = bundle.getParcelable("destEvent");
        Boolean isFirst = bundle.getBoolean("isFirst");

        EventData currentEvent = destEvent;

        String regex = "\\(heroName\\)";
        TextView eventText = Fragment1View.findViewById(R.id.event_text1);
        eventText.setText(currentEvent.getText().replaceAll(regex, name));
        Button choiceBtn = Fragment1View.findViewById(R.id.next_button);
        choiceBtn.setText(currentEvent.getChoice1txt().replaceAll(regex, name));

        choiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData choice1 = helper.searchEvent(currentEvent.getChoice1id());
                Bundle result = new Bundle();
                result.putParcelable("sourEvent",currentEvent);
                result.putParcelable("destEvent",choice1);
                result.putBoolean("isFirst",true);
                getParentFragmentManager().setFragmentResult("requestKey", result);
            }
        });
        // Inflate the layout for this fragment
        return Fragment1View;
    }

//    @Override
//    public View OnCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View Fragment1View = inflater.inflate(R.layout.event_stepping_stone, container,false);
//
//        DAOEvents helper = new DAOEvents(getContext());
//
//        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("info", Context.MODE_PRIVATE);
//        String name = sharedPreferences.getString("name","");
//
//        Bundle bundle = this.getArguments();
//        EventData sourEvent = bundle.getParcelable("sourEvent");
//        EventData destEvent = bundle.getParcelable("destEvent");
//        Boolean isFirst = bundle.getBoolean("isFirst");
//
//        EventData currentEvent = destEvent;
//
//
//        TextView eventText = getActivity().findViewById(R.id.event_text);
//        eventText.setText("currentEvent.getText()");
//        Button choiceBtn = getActivity().findViewById(R.id.next_button);
//        choiceBtn.setText(currentEvent.getChoice1txt());
//
//        EventData choice1 = helper.searchEvent(currentEvent.getChoice1id());
//
//        choiceBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle result = new Bundle();
//                bundle.putParcelable("sourEvent",currentEvent);
//                bundle.putParcelable("destEvent",choice1);
//                bundle.putBoolean("isFirst",true);
//                getParentFragmentManager().setFragmentResult("requestKey", result);
//            }
//        });
//        // Inflate the layout for this fragment
//        return Fragment1View;
//    }
}
