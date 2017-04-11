package www.gatherup.com.gatherup.models;

import java.util.ArrayList;
import java.util.List;

import www.gatherup.com.gatherup.data.User;
import www.gatherup.com.gatherup.data.Event;

/**
 * Created by Matthew Luce on 4/9/2017.
 */

public class UserModel {

    private List<Event> mRegisteredEvents = new ArrayList<>();
    private List<Event> mEvents = new ArrayList<>();
    private List<User> mFriends = new ArrayList<>();
    private String mAccountName;
    //private String mAlias;
    private String mEmail;
    private String mFullname;
    //private String mPhoneNum;
    private static final UserModel sUserModel = new UserModel();

    private UserModel(){
    }
    public static UserModel get(){

        return sUserModel;
    }

    public List<Event> getRegisteredEvents() {
        return mRegisteredEvents;
    }

    public void addRegisteredEvents(Event registeredEvent) {
        mRegisteredEvents.add(registeredEvent);
    }

    public List<Event> getEvents() {
        return mEvents;
    }

    public void addEvents(Event aEvent) {
        mEvents.add(aEvent);
    }

    public List<User> getFriends() {
        return mFriends;
    }

    public void addFriends(User friend) {
        mFriends.add(friend);
    }

    public String getAccountName() {
        return mAccountName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getFullname() {
        return mFullname;
    }

    public void setMainUser(User user){
        this.mAccountName = user.getUsername();
        this.mEmail = user.getEmail();
        this.mFullname = user.getFullName();
    }

}
