package www.gatherup.com.gatherup;

import android.app.Application;

import java.util.ArrayList;

import www.gatherup.com.gatherup.data.Event;
import www.gatherup.com.gatherup.data.User;

/**
 * Created by edwinsventura on 4/10/17.
 */

public class GlobalAppState extends Application {

    private User loggedInUser = new User();
    private User otherUser = new User();
    private ArrayList<User> userList = new ArrayList<>();
    private Event currentEvent  = new Event();
    private ArrayList<Event> eventList = new ArrayList<>();


    public User getLoggedInUser() {
        return loggedInUser;
    }
    public void setLoggedInUser(User loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public User getOtherUser() {
        return otherUser;
    }
    public void setOtherUser(User otherUser) {
        this.otherUser = otherUser;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public Event getCurrentEvent() {
        return currentEvent;
    }
    public void setCurrentEvent(Event currentEvent) {
        this.currentEvent = currentEvent;
    }

    public ArrayList<Event> getEventList() {
        return eventList;
    }
    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }


}// End Class
