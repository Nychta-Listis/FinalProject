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
                " eventId TEXT, " +
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

        // IdDB = -4L ---> Event can't be found in database
        // IdDB = -5L ---> Choice 2 flagged as no choice available

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
        EventData e = new EventData();
        if (DBID == -2L) {
            e.setName("Main Menu");
            e.setId("mainMenu");
            e.setIdDB(-2L);
            return e;
        } else if (DBID == -3L) {
            e.setName("emptyEvent");
            e.setId("emptyEvent");
            e.setIdDB(-3L);
            return e;
        } else if (DBID == -5L) {
            e.setName("noEvent");
            e.setId("noEvent");
            e.setIdDB(-5L);
            return e;
        }
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                " ORDER BY eventId ASC;", null);

        while(cursor.moveToNext()){
            int eventIdIndex = cursor.getColumnIndex("eventId");
            int nameIndex = cursor.getColumnIndex("name");
            int textIndex = cursor.getColumnIndex("text");
            int choice1txtIndex = cursor.getColumnIndex("choice1txt");
            int choice1idIndex = cursor.getColumnIndex("choice1id");
            int choice2txtIndex = cursor.getColumnIndex("choice2txt");
            int choice2idIndex = cursor.getColumnIndex("choice2id");
            int isInitialIndex = cursor.getColumnIndex("isInitial");

            e.setIdDB(DBID);
            e.setId(cursor.getString(eventIdIndex));
            e.setName(cursor.getString(nameIndex));
            e.setText(cursor.getString(textIndex));
            e.setChoice1txt(cursor.getString(choice1txtIndex));
            e.setChoice1id(cursor.getLong(choice1idIndex));
            e.setChoice2txt(cursor.getString(choice2txtIndex));
            e.setChoice2id(cursor.getLong(choice2idIndex));
            e.setIsInitial(cursor.getString(isInitialIndex));

            if (e.getIdDB().equals(DBID)) {
                cursor.close();
                return e;
            }

        }
        e.setName("missingEvent");
        e.setId("missingEvent");
        e.setIdDB(-4L);
        cursor.close();
        return e;
    }

    public Boolean IDagainst(String ID, Long IdDB) {
        try{
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                    " ORDER BY eventId ASC;", null);
            EventData e = new EventData();
            if (cursor.getCount() != 0) {
                while (cursor.moveToNext()) {
                    int IdIndex = cursor.getColumnIndex("id");
                    int eventIdIndex = cursor.getColumnIndex("eventId");
                    if ((IdDB != cursor.getLong(IdIndex)) && (cursor.getString(eventIdIndex).equals(ID))) {
                        cursor.close();
                        return true;
                    } else {
                        continue;}
                    }
            }
            cursor.close();
            return false;
        } catch(Exception ex) {
            return false;
        }


    }

    public Boolean IDexists(String ID) {
        try{
            Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM "+TABLE+
                    " ORDER BY eventId ASC;", null);
            EventData e = new EventData();
            if (cursor.getCount() != 0) {
                while (cursor.moveToNext()) {
                    int IdIndex = cursor.getColumnIndex("id");
                    int eventIdIndex = cursor.getColumnIndex("eventId");
                    if (cursor.getString(eventIdIndex).equals(ID)) {
                        cursor.close();
                        return true;
                    } else {
                        continue;}
                }
            }
            cursor.close();
            return false;
        } catch(Exception ex) {
            return false;
        }


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
        values.put("eventId",e.getId());
        values.put("name",e.getName());
        values.put("text",e.getText());
        values.put("choice1txt",e.getChoice1txt());
        values.put("choice1id",e.getChoice1id());
        values.put("choice2txt",e.getChoice2txt());
        values.put("choice2id",e.getChoice2id());
        values.put("isInitial",e.getIsInitial());

        String[] idToEdit = {String.valueOf(e.getIdDB())};
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

    public void deleteEvent (EventData e){
        SQLiteDatabase db = getWritableDatabase();
        String[] idToDelete = {e.getIdDB().toString()};
        db.delete(TABLE,"id=?",idToDelete);
    }
}