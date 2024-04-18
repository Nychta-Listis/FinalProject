package edu.andrews.edu.cptr252.alexandern.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editName = findViewById(R.id.name);
        Button beginBtn = findViewById(R.id.begin);
        Button eventBtn = findViewById(R.id.events);

        SharedPreferences sharedPreferences = getSharedPreferences("name", MODE_PRIVATE);
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();

        String name = sharedPreferences.getString("name","");
        editName.setText(name);

        beginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametemp = String.valueOf(editName.getText());
                if (!nametemp.equals("")){
                    sharedEditor.putString("name",nametemp);
                    sharedEditor.apply();
                    Intent intent = new Intent(MainActivity.this, story_select.class);
                    startActivity(intent);
                }
            }
        });

        eventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nametemp = String.valueOf(editName.getText());
                if (!nametemp.equals("")){
                    sharedEditor.putString("name",nametemp);
                    sharedEditor.apply();

                    Intent intent = new Intent(MainActivity.this, story_select.class);
                    startActivity(intent);
                }
            }
        });




    }
}