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
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class eventSelect2 extends AppCompatActivity {


    private RecyclerView recyclerEvents;
    private FullAdapter adapter;
    private DAOEvents helper;
    private List<EventData> eventList;
    private Button clearEventBtn;
    private final int REQUEST_NEW = 1;
    private final int REQUEST_EDIT = 2;
    private int action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.event_select_2);

        helper = new DAOEvents(this);
        eventList = helper.getFullList("ASC"); // Ascending
        clearEventBtn = findViewById(R.id.clear_event);

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
                        EventData e = eventList.get(position);
                        Intent i = new Intent();
                        i.putExtra("Event", e);
                        setResult(RESULT_OK, i);
                        finish();
                    }
                }
        ));

        clearEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventData e = new EventData();
                e.setName("noEvent");
                e.setId("noEvent");
                e.setIdDB(-5L);
                Intent i = new Intent();
                i.putExtra("Event", e);
                setResult(RESULT_OK, i);
                finish();
            }
        });
    }
}