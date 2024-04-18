package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class StoryEvent extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private DAOEvents helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_event);

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            Long destID = extras.getLong("destID");
            prepareEvent(-2L, destID, true);
        }
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
    }
    void prepareEvent(Long idS, Long idD, Boolean isFirst) {
        if (idD == -3L) {
            missingEvent(idS, isFirst);
        } else if (idD == -2L) {
            Intent intent = new Intent(StoryEvent.this, MainActivity.class);
            startActivity(intent);
        } else {
            EventData newEvent = helper.searchEvent(idD);
            if (newEvent.getIdDB().equals(-4L)) {
                missingEvent(idS, isFirst);
            } else {
                Bundle bundle = new Bundle();
                bundle.putLong("idD",idD);
                bundle.putBoolean("isFirst",isFirst);
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                if (newEvent.getChoice2id().equals(-5L)) {
                    fragment1.setArguments(bundle);
                    transaction.replace(R.id.fragment, fragment1);
                    transaction.commit();
                } else {
                    fragment2.setArguments(bundle);
                    transaction.replace(R.id.fragment, fragment2);
                    transaction.commit();
                }
            }
        }

    }
    void missingEvent(Long idS, Boolean isFirst) {
        // Say event not yet defined, ask if want to create an event, or redefine destination of this choice
        Long newId = 0L; //result from either creating event or redefining destination

        EventData sourceEvent = helper.searchEvent(idS);
        helper.editChoiceID(sourceEvent,newId,isFirst);// After editing, make sure returns to current event.
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

