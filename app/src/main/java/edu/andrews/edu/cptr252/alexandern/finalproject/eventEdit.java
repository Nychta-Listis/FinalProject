package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.metrics.Event;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class eventEdit extends AppCompatActivity {

    private EventData event;
    private EditText editName;
    private EditText editID;
    private EditText editDescription;
    private Button choice1ID;
    private Button choice2ID;
    private EditText choice1Text;
    private EditText choice2Text;
    private Button doneHere;
    private CheckBox start_check;
    private DAOEvents helper;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_edit);

        helper = new DAOEvents(this);

        event = getIntent().getParcelableExtra("Event");

        editName = findViewById(R.id.editName);
        editID = findViewById(R.id.editID);
        editDescription = findViewById(R.id.editDescription);
        choice1ID = findViewById(R.id.choice1ID);
        choice2ID = findViewById(R.id.choice2ID);
        choice1Text = findViewById(R.id.choice1Text);
        choice2Text = findViewById(R.id.choice2Text);
        doneHere = findViewById(R.id.doneHere);
        start_check = findViewById(R.id.start_check);

        if (event.getIsInitial().equals("0")) {
            start_check.setChecked(false);
        } else {start_check.setChecked(true);}

        editName.setText(event.getName());
        editID.setText(event.getId());
        editDescription.setText(event.getText());

        EventData choice1 = helper.searchEvent(event.getChoice1id());
        EventData choice2 = helper.searchEvent(event.getChoice2id());

        choice1ID.setText(choice1.getId());
        choice2ID.setText(choice2.getId());

        choice1Text.setText(event.getChoice1txt());
        choice2Text.setText(event.getChoice2txt());

        choice1ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, eventSelect.class);
                intent1.putExtra("contact", contact);
                action = 1;
                eventSelectLauncher.launch(intent1);
            }
        });

        choice2ID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        doneHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Test if Id is repeated/already exists
                event.setName(editName.getText());

                event.setId(editID.getText());
                event.setIsInitial(start_check);
                event.setChoice1txt();
                event.setChoice2txt();
            }
        });


    }
    private final ActivityResultLauncher<Intent> eventSelectLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            EventData EditEvent = data.getParcelableExtra("contact");
                            if (action == 1) {
                                choice1ID = findViewById(R.id.choice1ID);
                                event.setChoice1id(EditEvent.getIdDB());
                                choice1ID.setText(EditEvent.getId());
                            } else if (action == 2) {
                                choice2ID = findViewById(R.id.choice2ID);
                                event.setChoice2id(EditEvent.getIdDB());
                                choice2ID.setText(EditEvent.getId());
                            }
                        }
                    }
                }
            }


    );
}