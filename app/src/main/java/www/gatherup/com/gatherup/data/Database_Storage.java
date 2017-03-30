package www.gatherup.com.gatherup.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap;
import android.nfc.Tag;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.ByteArrayOutputStream;

/**
 * Created by Matthew Luce on 3/30/2017.
 */

public final class Database_Storage {
    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference myRef = database.getReference("message");

    public static boolean WriteToDatabase(){
        myRef.setValue("Hello World!");
        return true;
    }
    public static void readFromDatabase(){
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                Log.d("TAG","Value is: " +value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("TAG","Failed to read value", error.toException());
            }
        });
    }
}
