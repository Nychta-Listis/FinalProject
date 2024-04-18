package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StoryEvent extends AppCompatActivity {

    private DAOEvents helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_event);

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            Long destID = extras.getLong("destID");
            testEvent(-2L, destID, true);
        }
    }
    void testEvent(Long idS, Long idD, Boolean isFirst) {

        if (idD == -3L) {
            // Say event not yet defined, ask if want to create an event, or redefine destination of this choice
        } else if (idD == -2L) {
            // Go to menu
        } else {
            EventData newEvent = helper.searchEvent(idD);
            if (newEvent.getIdDB().equals(-4L)) {
                // Say event missing, ask if want to create an event, or redefine destination
            } else {
                if (newEvent.getChoice2id().equals(-5L)) {
                    //Pass everything to fragment 1
                } else {
                    //Pass everything to fragment 2
                }
            }
        }

    }
    void missingEvent(Long idS, Boolean IsFirst) {
        // Ask if want to replace or reassign.
        //  If reassign, go to eventList and select an event, reassign
        //  If create, go to create new and run all of that stuff.
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

