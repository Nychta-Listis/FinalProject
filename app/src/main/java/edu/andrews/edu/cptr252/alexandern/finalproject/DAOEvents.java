package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.metrics.Event;

import java.util.ArrayList;
import java.util.List;

public class DAOEvents  extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private final String TABLE = "events";
    private static final String DATABASE = "EventList";

    public DAOEvents(Context context) {
        super(context, DATABASE, null, VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+ TABLE +
                " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                " eventId TEXT NOT NULL, " +
                " name TEXT, " +
                " text TEXT, " +
                " choice1txt TEXT, " +
                " choice1id TEXT, " +
                " choice2txt TEXT, " +
                " choice2id TEXT, " +
                " isInitial TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public List<EventData> getFullList(String order){
        List<EventData> events = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                " ORDER BY eventId "+order+";", null);

        EventData Menu = new EventData();
        Menu.setName("Main Menu");
        Menu.setId("mainMenu");
        Menu.setIdDB(-2L);
        events.add(Menu);

        EventData emptyEvent = new EventData();
        emptyEvent.setName("emptyEvent");
        emptyEvent.setId("emptyEvent");
        emptyEvent.setIdDB(-3L);
        events.add(emptyEvent);

        while(cursor.moveToNext()){
            EventData e = new EventData();

            int IdIndex = cursor.getColumnIndex("id");
            int eventIdIndex = cursor.getColumnIndex("eventId");
            int nameIndex = cursor.getColumnIndex("name");
            int textIndex = cursor.getColumnIndex("text");
            int choice1txtIndex = cursor.getColumnIndex("choice1txt");
            int choice1idIndex = cursor.getColumnIndex("choice1id");
            int choice2txtIndex = cursor.getColumnIndex("choice2txt");
            int choice2idIndex = cursor.getColumnIndex("choice2id");
            int isInitialIndex = cursor.getColumnIndex("isInitial");

            e.setIdDB(cursor.getLong(IdIndex));
            e.setId(cursor.getString(eventIdIndex));
            e.setName(cursor.getString(nameIndex));
            e.setText(cursor.getString(textIndex));
            e.setChoice1txt(cursor.getString(choice1txtIndex));
            e.setChoice1id(cursor.getLong(choice1idIndex));
            e.setChoice2txt(cursor.getString(choice2txtIndex));
            e.setChoice2id(cursor.getLong(choice2idIndex));
            e.setIsInitial(cursor.getString(isInitialIndex));

            events.add(e);
        }
        cursor.close();
        return events;
    }

    public List<EventData> getEditList(String order){
        List<EventData> events = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                " ORDER BY eventId "+order+";", null);
        while(cursor.moveToNext()){
            EventData e = new EventData();

            int IdIndex = cursor.getColumnIndex("id");
            int eventIdIndex = cursor.getColumnIndex("eventId");
            int nameIndex = cursor.getColumnIndex("name");
            int textIndex = cursor.getColumnIndex("text");
            int choice1txtIndex = cursor.getColumnIndex("choice1txt");
            int choice1idIndex = cursor.getColumnIndex("choice1id");
            int choice2txtIndex = cursor.getColumnIndex("choice2txt");
            int choice2idIndex = cursor.getColumnIndex("choice2id");
            int isInitialIndex = cursor.getColumnIndex("isInitial");

            e.setIdDB(cursor.getLong(IdIndex));
            e.setId(cursor.getString(eventIdIndex));
            e.setName(cursor.getString(nameIndex));
            e.setText(cursor.getString(textIndex));
            e.setChoice1txt(cursor.getString(choice1txtIndex));
            e.setChoice1id(cursor.getLong(choice1idIndex));
            e.setChoice2txt(cursor.getString(choice2txtIndex));
            e.setChoice2id(cursor.getLong(choice2idIndex));
            e.setIsInitial(cursor.getString(isInitialIndex));

            events.add(e);
        }
        cursor.close();
        return events;
    }

    public List<EventData> getInitialList(String order){
        List<EventData> events = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                " ORDER BY eventId "+order+";", null);
        while(cursor.moveToNext()){
            EventData e = new EventData();

            int IdIndex = cursor.getColumnIndex("id");
            int eventIdIndex = cursor.getColumnIndex("eventId");
            int nameIndex = cursor.getColumnIndex("name");
            int textIndex = cursor.getColumnIndex("text");
            int choice1txtIndex = cursor.getColumnIndex("choice1txt");
            int choice1idIndex = cursor.getColumnIndex("choice1id");
            int choice2txtIndex = cursor.getColumnIndex("choice2txt");
            int choice2idIndex = cursor.getColumnIndex("choice2id");
            int isInitialIndex = cursor.getColumnIndex("isInitial");

            e.setIdDB(cursor.getLong(IdIndex));
            e.setId(cursor.getString(eventIdIndex));
            e.setName(cursor.getString(nameIndex));
            e.setText(cursor.getString(textIndex));
            e.setChoice1txt(cursor.getString(choice1txtIndex));
            e.setChoice1id(cursor.getLong(choice1idIndex));
            e.setChoice2txt(cursor.getString(choice2txtIndex));
            e.setChoice2id(cursor.getLong(choice2idIndex));
            e.setIsInitial(cursor.getString(isInitialIndex));

            if(e.getIsInitial().equals("1")){
                events.add(e);
            }
        }
        cursor.close();
        return events;
    }

    public EventData searchEvent (Long DBID) {
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                " where id = ?", new String[] {DBID.toString()});
        EventData e = new EventData();

        if (cursor!= null) {
            int IdIndex = cursor.getColumnIndex("id");
            int eventIdIndex = cursor.getColumnIndex("eventId");
            int nameIndex = cursor.getColumnIndex("name");
            int textIndex = cursor.getColumnIndex("text");
            int choice1txtIndex = cursor.getColumnIndex("choice1txt");
            int choice1idIndex = cursor.getColumnIndex("choice1id");
            int choice2txtIndex = cursor.getColumnIndex("choice2txt");
            int choice2idIndex = cursor.getColumnIndex("choice2id");
            int isInitialIndex = cursor.getColumnIndex("isInitial");

            e.setIdDB(cursor.getLong(IdIndex));
            e.setId(cursor.getString(eventIdIndex));
            e.setName(cursor.getString(nameIndex));
            e.setText(cursor.getString(textIndex));
            e.setChoice1txt(cursor.getString(choice1txtIndex));
            e.setChoice1id(cursor.getLong(choice1idIndex));
            e.setChoice2txt(cursor.getString(choice2txtIndex));
            e.setChoice2id(cursor.getLong(choice2idIndex));
            e.setIsInitial(cursor.getString(isInitialIndex));
        } else {
            e.setName("missingEvent");
            e.setId("missingEvent");
            e.setIdDB(-4L);
        }
        cursor.close();

        return e;

    }

    public void insertEvent (EventData e){
        ContentValues values = new ContentValues();
        values.put("eventId",e.getId());
        values.put("name",e.getName());
        values.put("text",e.getText());
        values.put("choice1txt",e.getChoice1txt());
        values.put("choice1id",e.getChoice1id());
        values.put("choice2txt",e.getChoice2txt());
        values.put("choice2id",e.getChoice2id());
        values.put("isInitial",e.getIsInitial());
        getWritableDatabase().insert(TABLE,null,values);
    }

    public void editEvent (EventData e){
        ContentValues values = new ContentValues();
        values.put("id",e.getIdDB());
        values.put("eventId",e.getId());
        values.put("name",e.getName());
        values.put("text",e.getText());
        values.put("choice1txt",e.getChoice1txt());
        values.put("choice1id",e.getChoice1id());
        values.put("choice2txt",e.getChoice2txt());
        values.put("choice2id",e.getChoice2id());
        values.put("isInitial",e.getIsInitial());

        String[] idToEdit = {e.getIdDB().toString()};
        getWritableDatabase().update(TABLE,values,"id=?",idToEdit);
    }

    public void editChoiceID (EventData e, Long TargetId, Boolean isFirst) {
        if (isFirst) {
            e.setChoice1id(TargetId);
        } else {
            e.setChoice2id(TargetId);
        }
        editEvent(e);
    }

    public void deleteContact (EventData e){
        SQLiteDatabase db = getWritableDatabase();
        String[] idToDelete = {e.getIdDB().toString()};
        db.delete(TABLE,"id=?",idToDelete);
    }
}