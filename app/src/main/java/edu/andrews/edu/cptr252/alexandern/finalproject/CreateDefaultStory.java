package edu.andrews.edu.cptr252.alexandern.finalproject;

import android.content.Context;
import android.media.metrics.Event;

public class CreateDefaultStory {

    private DAOEvents helper;
    private String MENU = "mainMenu";
    private String NO = "noEvent";
    private Context context;

    public CreateDefaultStory(Context context) {
        this.context=context;
    }

    private EventData createEvent(String title, String Id, String text,
                                  String choice1Text, String choice1ID,
                                  String choice2Text, String choice2ID) {
        EventData tempEvent = new EventData();
        EventData newEvent = new EventData();
        if (choice1ID.equals(MENU)) {
            newEvent.setChoice1id(-2L);
        } else if (choice1ID.equals(NO)) {
            newEvent.setChoice1id(-5L);
        } else {
            tempEvent.setId(choice1ID);
            EventData choice1Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice1id(choice1Event.getIdDB());
        }

        if (choice2ID.equals(MENU)) {
            newEvent.setChoice2id(-2L);
        } else if (choice2ID.equals(NO)) {
            newEvent.setChoice2id(-5L);
        } else {
            tempEvent.setId(choice2ID);
            EventData choice2Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice2id(choice2Event.getIdDB());
        }

        newEvent.setName(title);
        newEvent.setId(Id);
        newEvent.setText(text);
        newEvent.setChoice1txt(choice1Text);
        newEvent.setChoice2txt(choice2Text);

        return newEvent;
    }

    private EventData createEvent(String title, String Id, String text,
                                  String choice1Text, String choice1ID,
                                  String choice2Text, String choice2ID, Boolean isInitial) {
        EventData tempEvent = new EventData();
        EventData newEvent = new EventData();
        if (choice1ID.equals(MENU)) {
            newEvent.setChoice1id(-2L);
        } else if (choice1ID.equals(NO)) {
            newEvent.setChoice1id(-5L);
        } else {
            tempEvent.setId(choice1ID);
            EventData choice1Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice1id(choice1Event.getIdDB());
        }

        if (choice2ID.equals(MENU)) {
            newEvent.setChoice2id(-2L);
        } else if (choice2ID.equals(NO)) {
            newEvent.setChoice2id(-5L);
        } else {
            tempEvent.setId(choice2ID);
            EventData choice2Event = helper.retrieveFromID(tempEvent);
            newEvent.setChoice2id(choice2Event.getIdDB());
        }

        newEvent.setName(title);
        newEvent.setId(Id);
        newEvent.setText(text);
        newEvent.setChoice1txt(choice1Text);
        newEvent.setChoice2txt(choice2Text);
        newEvent.setIsInitial("1");

        return newEvent;
    }

    public void createStory() {
        helper = new DAOEvents(this.context);
        helper.insertEvent(createEvent(
                "36","36",//Title, Id
                "36",//Text
                "Menu",MENU,//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)
        ));
        helper.insertEvent(createEvent(
                "35","35",//Title, Id
                "35",//Text
                "Menu",MENU,//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "33","33",//Title, Id
                "33",//Text
                "35","35",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "32","32",//Title, Id
                "32",//Text
                "33","33",//Choice1Text, Choice1ID
                "36","36"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "31","31",//Title, Id
                "31",//Text
                "32","32",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "30","30",//Title, Id
                "30",//Text
                "31","31",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "28","28",//Title, Id
                "28",//Text
                "30","30",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "29","29",//Title, Id
                "29",//Text
                "28","28",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "25","25",//Title, Id
                "25",//Text
                "28","28",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "27","27",//Title, Id
                "27",//Text
                "29","29",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "24","24",//Title, Id
                "24",//Text
                "25","25",//Choice1Text, Choice1ID
                "27","27"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "23","23",//Title, Id
                "23",//Text
                "24","24",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "21","21",//Title, Id
                "21",//Text
                "Menu",MENU,//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "20","20",//Title, Id
                "20",//Text
                "21","21",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "19","19",//Title, Id
                "19",//Text
                "",NO,//Choice1Text, Choice1ID
                "",""//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "18","18",//Title, Id
                "18",//Text
                "19","19",//Choice1Text, Choice1ID
                "23","23"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "16","16",//Title, Id
                "16",//Text
                "18","18",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "15","15",//Title, Id
                "15",//Text
                "16","16",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "14","14",//Title, Id
                "14",//Text
                "15","15",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "13","13",//Title, Id
                "13",//Text
                "14","14",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "8","8",//Title, Id
                "8",//Text
                "14","14",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "11","11",//Title, Id
                "11",//Text
                "8","8",//Choice1Text, Choice1ID
                "13","13"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "10","10",//Title, Id
                "10",//Text
                "11","11",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "9","9",//Title, Id
                "9",//Text
                "10","10",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "7","7",//Title, Id
                "7",//Text
                "8","8",//Choice1Text, Choice1ID
                "9","9"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "6","6",//Title, Id
                "6",//Text
                "7","7",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "4b","4b",//Title, Id
                "4b",//Text
                "6","6",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "2b","2b",//Title, Id
                "2b",//Text
                "4b","4b",//Choice1Text, Choice1ID
                "6","6"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "3","3",//Title, Id
                "3",//Text
                "2b","2b",//Choice1Text, Choice1ID
                "6","6"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "4a","4a",//Title, Id
                "4a",//Text
                "3","3",//Choice1Text, Choice1ID
                "",NO//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "2a","2a",//Title, Id
                "2a",//Text
                "3","3",//Choice1Text, Choice1ID
                "4a","4a"//Choice2Text, Choice2ID
                //isInitial (optional)

        ));
        helper.insertEvent(createEvent(
                "1","1",//Title, Id
                "1",//Text
                "2a","2a",//Choice1Text, Choice1ID
                "3","3",//Choice2Text, Choice2ID
                true//isInitial (optional)

        ));

    }
}
