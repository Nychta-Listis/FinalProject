package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StoryEvent extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private DAOEvents helper;
    private TextView eventName;
    private Button returnBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story_event);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            EventData destEvent = extras.getParcelable("destEvent");

            EventData Menu = new EventData();
            Menu.setName("Main Menu");
            Menu.setId("mainMenu");
            Menu.setIdDB(-2L);
            FragmentManager fragmentManager = getSupportFragmentManager();
            eventName = findViewById(R.id.event_name);
            returnBtn = findViewById(R.id.return_button);
            fragmentManager.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                    EventData sourEvent = bundle.getParcelable("sourEvent");
                    EventData destEvent = bundle.getParcelable("destEvent");
                    Boolean isFirst = bundle.getBoolean("isFirst");
                    eventName.setText(destEvent.getName());
                    prepareEvent(sourEvent, destEvent, isFirst);

                }
            });
            eventName.setText(destEvent.getName());
            prepareEvent(Menu, destEvent, true);

        }
        returnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menu = new Intent(StoryEvent.this, MainActivity.class);
                startActivity(menu);
            }
        });
    }
    void prepareEvent(EventData sourEvent, EventData destEvent, Boolean isFirst) {
        if (destEvent.getIdDB().equals(-3L) || destEvent.getIdDB().equals(-4L)) {
            missingEvent(destEvent, isFirst);
        } else if (destEvent.getIdDB() == -2L) {
            Intent intent = new Intent(StoryEvent.this, MainActivity.class);
            startActivity(intent);
        } else {
            Bundle bundle = new Bundle();
            bundle.putParcelable("sourEvent",sourEvent);
            bundle.putParcelable("destEvent",destEvent);
            bundle.putBoolean("isFirst",isFirst);
            if (destEvent.getChoice2id().equals(-5L)) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.fragment, fragment1);
                transaction.commit();

            } else {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                fragment2.setArguments(bundle);
                transaction.replace(R.id.fragment, fragment2);
                transaction.commit();
            }
        }
    }
    void missingEvent(EventData sourEvent, Boolean isFirst) {
        // Say event not yet defined, ask if want to create an event, or redefine destination of this choice
        Long newId = 0L; //result from either creating event or redefining destination

        helper.editChoiceID(sourEvent,newId,isFirst);// After editing, make sure returns to current event.
    }


}

// receive id of initial event to enter (Will be defined by definition)
// Retrieve EventData from database,
// Create Menu eventDataSource
// pass eventDataSource and eventDataDest to Fragment according to how many choices

// Within Fragment

// Write event data to fields and wait for button press:
// Identify eventDataSource (Current event) Destination (id for button), and isFirst (which button)

// Receive eventDataSource, eventDataDest, and isFirst
// Check if eventDataDest corresponds to Menu, if so, go to Menu
// Check if eventDataDest corresponds to Empty Event, if so, ask if want to reassign or create
//  If reassign, go to scrollable menu to retrieve new ID for destination,
//      assign to eventDataSource according to isFirst
//  If create, go to create new event, once done, find DatabaseID using EventID
//      assign to eventDataSource according to isFirst
// If Event defined but can't be found in Database (Deleted)
//  set eventID to empty and perform empty event case
// If Event exists and is same number of choices, change entries and stored variables
//  If Event has different number of choices, pass everything to other Fragment.

