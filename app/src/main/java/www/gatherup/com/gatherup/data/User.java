package www.gatherup.com.gatherup.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by edwinsventura on 3/20/17.
 */

public class User  implements Parcelable {
    private int userId;
    private String username;
    private String fullName;
    private String email;
    private String passwordHash;
    private ArrayList<User> friendList;
    private double latitude;
    private double longitude;
    private ArrayList<Event> attendingEventsList;
    private ArrayList<Event> createdEventsList;


    public User(){
        this("username", "fullname", "email");
    }

    public User(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        userId = 0;
        passwordHash = "passwordHash";
        latitude = 0.0;
        longitude = 0.0;
        friendList = new ArrayList<>();
        attendingEventsList = new ArrayList<>();
        createdEventsList = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setFriendList(ArrayList<User> friendList) {
        this.friendList = friendList;
    }
    public ArrayList<User> getFriendList() {
        return friendList;
    }

    public double getLatitude() {
        return latitude;
    }
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Event> getAttendingEventsList() {
        return attendingEventsList;
    }
    public void setAttendingEventsList(ArrayList<Event> attendingEventsList) {
        this.attendingEventsList = attendingEventsList;
    }

    public void addAttendingEvent(Event e){
        attendingEventsList.add(e);
    }


    public ArrayList<Event> getCreatedEventsList() {
        return createdEventsList;
    }
    public void setCreatedEventsList(ArrayList<Event> createdEventsList) {
        this.createdEventsList = createdEventsList;
    }

    public void addCreatedEvent(Event e){
        createdEventsList.add(e);
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(userId);
        dest.writeString(username);
        dest.writeString(fullName);
        dest.writeString(email);
        dest.writeString(passwordHash);
        if (friendList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(friendList);
        }
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        if (attendingEventsList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(attendingEventsList);
        }
        if (createdEventsList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(createdEventsList);
        }
    }

    protected User(Parcel in) {
        userId = in.readInt();
        username = in.readString();
        fullName = in.readString();
        email = in.readString();
        passwordHash = in.readString();
        if (in.readByte() == 0x01) {
            friendList = new ArrayList<User>();
            in.readList(friendList, User.class.getClassLoader());
        } else {
            friendList = null;
        }
        latitude = in.readDouble();
        longitude = in.readDouble();
        if (in.readByte() == 0x01) {
            attendingEventsList = new ArrayList<Event>();
            in.readList(attendingEventsList, Event.class.getClassLoader());
        } else {
            attendingEventsList = null;
        }
        if (in.readByte() == 0x01) {
            createdEventsList = new ArrayList<Event>();
            in.readList(createdEventsList, Event.class.getClassLoader());
        } else {
            createdEventsList = null;
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };





}
