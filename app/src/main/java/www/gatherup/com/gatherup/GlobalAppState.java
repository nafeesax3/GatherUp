package www.gatherup.com.gatherup;

import android.app.Application;

import java.util.ArrayList;

import www.gatherup.com.gatherup.data.DetailedEvent;
import www.gatherup.com.gatherup.data.User;

/**
 * Created by edwinsventura on 4/10/17.
 */

public class GlobalAppState extends Application {

    private User loggedInUser = new User();
    private User otherUser = new User();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<DetailedEvent> mDetailedEventList = new ArrayList<>();
    private DetailedEvent mCurrentDetailedEvent = new DetailedEvent();
    private ArrayList<String> categories = new ArrayList<String>();
    private ArrayList<DetailedEvent> mFilteredDetailedEvents = new ArrayList<>();


    public ArrayList<DetailedEvent> getNearByEvents(double latitude, double longitude, double mileRadius){
        ArrayList<DetailedEvent> nearbyDetailedEvents = new ArrayList<>();

        for(DetailedEvent detailedEvent : mDetailedEventList){
            if (distFrom(latitude, longitude, detailedEvent.getLatitude(), detailedEvent.getLongitude()) < mileRadius){
                nearbyDetailedEvents.add(detailedEvent);
            }
        }

        return nearbyDetailedEvents;
    }

    public double distFrom(double lat1, double lng1, double lat2, double lng2) {
        double earthRadius = 3958.75; // miles (or 6371.0 kilometers)
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double sindLat = Math.sin(dLat / 2);
        double sindLng = Math.sin(dLng / 2);
        double a = Math.pow(sindLat, 2) + Math.pow(sindLng, 2)
                * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double dist = earthRadius * c;

        return dist;
    }

    public ArrayList<String> getCategories() {
        return categories;
    }
    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

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

    public DetailedEvent getCurrentDetailedEvent() {
        return mCurrentDetailedEvent;
    }
    public void setCurrentDetailedEvent(DetailedEvent currentDetailedEvent) {
        this.mCurrentDetailedEvent = currentDetailedEvent;
    }

    public ArrayList<DetailedEvent> getDetailedEventList() {
        return mDetailedEventList;
    }
    public void setDetailedEventList(ArrayList<DetailedEvent> detailedEventList) {
        this.mDetailedEventList = detailedEventList;
    }

    public ArrayList<DetailedEvent> getFilteredDetailedEvents() {
        return mFilteredDetailedEvents;
    }
    public void setFilteredDetailedEvents(ArrayList<DetailedEvent> filteredDetailedEvents) {
        this.mFilteredDetailedEvents = filteredDetailedEvents;
    }
}// End Class
