package www.gatherup.com.gatherup.models;

import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import www.gatherup.com.gatherup.data.User;

/**
 * Created by Matthew Luce on 4/9/2017.
 */

public class Firebase_Model {
    private final String TAG = "FB_SIGNIN";
    private DatabaseReference mDatabase;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseUser mAuthUser;
    private static final Firebase_Model sFirebase_model = new Firebase_Model();

    public static Firebase_Model get(){
        return sFirebase_model;
    }
    private Firebase_Model(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "Signed in: " + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "Currently signed out");
                }
            }
        };
    }

    // START Authentication Methods
    public void addAuthListener(){
        mAuth.addAuthStateListener(mAuthListener);
    }
    public void removeAuthListener(){
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public boolean isUserConnected(){
        mAuthUser = mAuth.getCurrentUser();
        return mAuthUser == null;
    }

    public String getEmail(){
        return mAuthUser.getEmail();
    }
    public String getUserID(){
        return mAuthUser.getUid();
    }
    public FirebaseAuth getAuth(){
        return mAuth;
    }
    // END Authentication Methods

    // START Database Methods
    public void addUserToDataBase(User user){
        //user.setUserID(mAuthUser.getUid());
        mDatabase.child("users").push().setValue(user);
    }
    public User getUser(){

        return new User();
    }
    // END Database Methods

    /// Getters ///


    /// Setters ///

    // Authentication
        // Authenticate User Log In
        // Create New User Authentication
        // Delete Account
        // Change Account Password

    // Database
        //Creation
            // Create New User On Database
            // Create User Profile
            // Create New Friend OR Follow Another User
            // Create Event
                // Add Filters
                // Add Location
                // Add Category
                // Add Event Info
                // Add Rating
                // Add Attendance
                    // Pending Invites
                    // Going

        // Deletion
            // Remove Friend / Stop Following Another User
            // Delete Event
                // Delete Filters
                // Delete Location
                // Delete Category
                // Delete Event Info
                // Delete Rating
                // Delete Attendance
                    // Pending Invites
                    // Going
            // Remove User From Event
            // Remove An Event Filter
            // Delete Account

        // Update
            // Change Event
                // Info
                // Location
                // Add Filters
                // Category
                // Your Rating Of Event
            // Change Profile Info
            // Change Account
                // Email
                // Alias
                // Phone

        // Fetch
            // Fetch User Information & Update User Model
            // Fetch User Profile
                //
                //
            // Fetch Followed Users / Friends
            // Fetch Registered Events
                // Info
                // Location
                // Filters
                // Category
                // Ratings of Event
            // Fetch Events By Location
                // Info
                // Location
                // Filters
                // Category
                // Ratings of Event
            //

}
