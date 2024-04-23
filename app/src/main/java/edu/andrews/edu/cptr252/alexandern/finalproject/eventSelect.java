package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.metrics.Event;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class eventSelect extends AppCompatActivity {

    private RecyclerView recyclerEvents;
    private FullAdapter adapter;
    private DAOEvents helper;
    private List<EventData> eventList;
    private Button newEventBtn;
    private final int REQUEST_NEW = 1;
    private final int REQUEST_EDIT = 2;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_select);

        helper = new DAOEvents(this);
        eventList = helper.getEditList("ASC"); // Ascending
        newEventBtn = findViewById(R.id.new_event);

        recyclerEvents = findViewById(R.id.listView);
        recyclerEvents.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerEvents.setLayoutManager(llm);

        adapter = new FullAdapter(eventList);
        recyclerEvents.setAdapter(adapter);

        recyclerEvents.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        openOptions(eventList.get(position));
                    }
                }
        ));

        newEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent edit = new Intent(eventSelect.this, eventEdit.class);
                edit.putExtra("Event", new EventData());
                action = REQUEST_NEW;
                eventLauncher.launch(edit);
            }
        });


    }

    private void openOptions(EventData event){
//        Toast.makeText(this, "Contact: "+contact.getName(), Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Event: "+ event.getId());
        builder.setItems(new CharSequence[]{"Enter", "Edit", "Delete"},
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case 0: // Enter Event
                                break;
                            case 1: // Edit Event
                                Intent intent1 = new Intent(eventSelect.this, eventEdit.class);
                                intent1.putExtra("Event", event);
                                action = REQUEST_EDIT;
                                eventLauncher.launch(intent1);
                                break;
                            case 2: // Delete Event
                                eventList.remove(event);
                                helper.deleteEvent(event);
                                adapter.notifyDataSetChanged();
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
                            EventData event = data.getParcelableExtra("Event");
                            if (action == REQUEST_NEW) {
                                helper.insertEvent(event);
                            } else if (action == REQUEST_EDIT) {
                                helper.editEvent(event);
                            }
                            eventList = helper.getEditList("ASC");
                            adapter.setEventList(eventList);
                            adapter.notifyDataSetChanged();
                        }
                    }
                }
            }


    );
}