package www.gatherup.com.gatherup.models;

import java.util.List;

import www.gatherup.com.gatherup.data.User;
import www.gatherup.com.gatherup.data.Event;

/**
 * Created by Matthew Luce on 4/9/2017.
 */

public class UserModel {

    private List<Event> mRegisteredEvents;
    private List<Event> mEvents;
    private List<User> mFriends;
    private String mAccountName;
    //private String mAlias;
    private String mEmail;
    private String mPhoneNum;
    private static final UserModel sUserModel = new UserModel();

    private UserModel(){

    }
    public static UserModel getUserModel(){
        return sUserModel;
    }

    public List<Event> getRegisteredEvents() {
        return mRegisteredEvents;
    }

    public void setRegisteredEvents(List<Event> registeredEvents) {
        mRegisteredEvents = registeredEvents;
    }

    public List<Event> getEvents() {
        return mEvents;
    }

    public void setEvents(List<Event> events) {
        mEvents = events;
    }

    public List<User> getFriends() {
        return mFriends;
    }

    public void setFriends(List<User> friends) {
        mFriends = friends;
    }
}
