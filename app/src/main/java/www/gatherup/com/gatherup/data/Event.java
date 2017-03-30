package www.gatherup.com.gatherup.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by edwinsventura on 3/20/17.
 */

public class Event implements Parcelable {
    private int eventID;
    private String title;
    private double latitude;
    private double longitude;
    private User owner;
    private ArrayList<User> atendeesList;
    private Calendar startDate;
    private Calendar endDate;
    private String Description;
    private String category;
    private double rating;

    public Event(){
        this("title", 0.0, 0.0, Calendar.getInstance(), Calendar.getInstance(), "description", "category");
    }

    public Event(String title, double latitude, double longitude, Calendar startDate, Calendar endDate, String description, String category) {
        this.title = title;
        this.latitude = latitude;
        this.longitude = longitude;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        Description = description;
        eventID = 0;
        owner = new User();
        atendeesList = new ArrayList<>();
        rating = 0.0;
    }

    public int getEventID() {
        return eventID;
    }
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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

    public User getOwner() {
        return owner;
    }
    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ArrayList<User> getAtendeesList() {
        return atendeesList;
    }
    public void setAtendeesList(ArrayList<User> atendeesList) {
        this.atendeesList = atendeesList;
    }

    public Calendar getStartDate() {
        return startDate;
    }
    public void setStartDate(Calendar startDate) {
        this.startDate = startDate;
    }

    public Calendar getEndDate() {
        return endDate;
    }
    public void setEndDate(Calendar endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }

    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(eventID);
        dest.writeString(title);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
        dest.writeValue(owner);
        if (atendeesList == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(atendeesList);
        }
        dest.writeValue(startDate);
        dest.writeValue(endDate);
        dest.writeString(Description);
        dest.writeString(category);
        dest.writeDouble(rating);
    }

    protected Event(Parcel in) {
        eventID = in.readInt();
        title = in.readString();
        latitude = in.readDouble();
        longitude = in.readDouble();
        owner = (User) in.readValue(User.class.getClassLoader());
        if (in.readByte() == 0x01) {
            atendeesList = new ArrayList<User>();
            in.readList(atendeesList, User.class.getClassLoader());
        } else {
            atendeesList = null;
        }
        startDate = (Calendar) in.readValue(Calendar.class.getClassLoader());
        //startDate = (GregorianCalendar) in.readSerializable();
        endDate = (Calendar) in.readValue(Calendar.class.getClassLoader());
        //endDate = (GregorianCalendar) in.readSerializable();
        //
        Description = in.readString();
        category = in.readString();
        rating = in.readDouble();
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Event> CREATOR = new Parcelable.Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };













}
