package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class EventData implements Parcelable {

    private String id="";
    private String name="";
    private String text="";
    private String choice1txt="";
    private Long choice1id=-2L;
    private String choice2txt="";
    private Long choice2id;
    private String isInitial="0";
    private Long idDB = -1L;

    public EventData(){}
    private EventData(Parcel source) {
        String[] data = new String[8];
        source.readStringArray(data);
        setId(data[0]);
        setName(data[1]);
        setText(data[2]);
        setChoice1txt(data[3]);
        setChoice1id(Long.parseLong(data[4]));
        setChoice2txt(data[5]);
        setChoice2id(Long.parseLong(data[6]));
        setIsInitial(data[7]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeStringArray(new String[]{
                getId(),getName(),getText(),getChoice1txt(),String.valueOf(getChoice1id()),getChoice2txt(),String.valueOf(getChoice2id()),getIsInitial()
        });
    }

    public static final Parcelable.Creator<EventData> CREATOR=new Parcelable.Creator<EventData>(){

        @Override
        public EventData createFromParcel(Parcel source) {
            return new EventData(source);
        }

        @Override
        public EventData[] newArray(int size) {
            return new EventData[0];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChoice1txt() {
        return choice1txt;
    }

    public void setChoice1txt(String choice1txt) {
        this.choice1txt = choice1txt;
    }

    public Long getChoice1id() {
        return choice1id;
    }

    public void setChoice1id(Long choice1id) {
        this.choice1id = choice1id;
    }

    public String getChoice2txt() {
        return choice2txt;
    }

    public void setChoice2txt(String choice2txt) {
        this.choice2txt = choice2txt;
    }

    public Long getChoice2id() {
        return choice2id;
    }

    public void setChoice2id(Long choice2id) {
        this.choice2id = choice2id;
    }

    public String getIsInitial() {
        return isInitial;
    }

    public void setIsInitial(String isInitial) {
        this.isInitial = isInitial;
    }

    public Long getIdDB() {
        return idDB;
    }

    public void setIdDB(Long idDB) {
        this.idDB = idDB;
    }
}
