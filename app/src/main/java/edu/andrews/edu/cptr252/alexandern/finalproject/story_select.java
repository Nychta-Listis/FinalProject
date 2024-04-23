package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

public class story_select extends AppCompatActivity {

    private RecyclerView recyclerEvents;
    private NameAdapter adapter;
    private DAOEvents helper;
    private List<EventData> storyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.story_select);

        helper = new DAOEvents(this);
        storyList = helper.getInitialList("ASC"); // Ascending

        recyclerEvents = findViewById(R.id.listView);
        recyclerEvents.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerEvents.setLayoutManager(llm);

        adapter = new NameAdapter(storyList);
        recyclerEvents.setAdapter(adapter);

        recyclerEvents.addOnItemTouchListener(new RecyclerItemClickListener(getApplicationContext(),
                new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Intent intent = new Intent(story_select.this, StoryEvent.class);
                        intent.putExtra("destEvent", storyList.get(position));
                        startActivity(intent);
                    }
                }
        ));
    }
}