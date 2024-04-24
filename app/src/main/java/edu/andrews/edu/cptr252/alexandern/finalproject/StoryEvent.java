package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StoryEvent extends AppCompatActivity {

    private Fragment1 fragment1;
    private Fragment2 fragment2;
    private DAOEvents helper;
    private TextView eventName;
    private Button returnBtn;
    private FragmentManager fragmentManager;
    private final int REQUEST_NEW = 1;
    private final int REQUEST_SELECT = 2;
    private int action;
    private Boolean first;
    private EventData sourEvent;
    private EventData destEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_story_event);
        helper = new DAOEvents(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            destEvent = extras.getParcelable("destEvent");

            EventData Menu = new EventData();
            Menu.setName("Main Menu");
            Menu.setId("mainMenu");
            Menu.setIdDB(-2L);
            fragmentManager = getSupportFragmentManager();
            eventName = findViewById(R.id.event_name);
            returnBtn = findViewById(R.id.return_button);
            fragmentManager.setFragmentResultListener("requestKey", this, new FragmentResultListener() {
                @Override
                public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {
                    sourEvent = bundle.getParcelable("sourEvent");
                    destEvent = bundle.getParcelable("destEvent");
                    Boolean isFirst = bundle.getBoolean("isFirst");
                    prepareEvent(sourEvent, destEvent, isFirst);
                    first = isFirst;
                }
            });
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
        SharedPreferences sharedPreferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("name","");

        if (destEvent.getIdDB().equals(-3L) || destEvent.getIdDB().equals(-4L) || destEvent.getIdDB().equals(-5L)) {
            openOptions();
        } else if (destEvent.getIdDB() == -2L) {
            Intent intent = new Intent(StoryEvent.this, MainActivity.class);
            startActivity(intent);
        } else {
            String regex = "\\(heroName\\)";
            Bundle bundle = new Bundle();
            bundle.putParcelable("sourEvent",sourEvent);
            bundle.putParcelable("destEvent",destEvent);
            bundle.putBoolean("isFirst",isFirst);
            if (destEvent.getChoice2id().equals(-5L)) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.fragment, fragment1);
                transaction.commit();
                first = isFirst;
                eventName.setText(destEvent.getName().replaceAll(regex, name));

            } else {
                fragment2 = new Fragment2();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                fragment2.setArguments(bundle);
                transaction.replace(R.id.fragment, fragment2);
                transaction.commit();
                eventName.setText(destEvent.getName().replaceAll(regex, name));
            }
        }
    }

    private void openOptions(){
//        Toast.makeText(this, "Contact: ", Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Event Undefined");
        builder.setItems(new CharSequence[]{"Select", "New"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0: // Select Event
                                Intent intent = new Intent(StoryEvent.this, eventSelect2.class);
                                action = REQUEST_SELECT;
                                eventLauncher.launch(intent);
                                break;
                            case 1: // New Event
                                Intent intent1 = new Intent(StoryEvent.this, eventEdit.class);
                                intent1.putExtra("Event", new EventData());
                                action = REQUEST_NEW;
                                eventLauncher.launch(intent1);
                                break;
                        }
                    }
                });
        builder.create().show();
    }

    private final ActivityResultLauncher<Intent> eventLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            EventData inevent = data.getParcelableExtra("Event");
                            if (action == REQUEST_NEW) {
                                helper.insertEvent(inevent);
                                inevent = helper.retrieveFromID(inevent);
                                if (first) {
                                    sourEvent.setChoice1id(inevent.getIdDB());
                                } else {
                                    sourEvent.setChoice2id(inevent.getIdDB());
                                }
                                helper.editEvent(sourEvent);
                                prepareEvent(sourEvent,sourEvent,first);
                            } else if (action == REQUEST_SELECT) {
                                if (first) {
                                    sourEvent.setChoice1id(inevent.getIdDB());
                                } else {
                                    sourEvent.setChoice2id(inevent.getIdDB());
                                }
                                helper.editEvent(sourEvent);
                                prepareEvent(sourEvent,sourEvent,first);
                            }
                        }
                    }
                }
            }
    );


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

