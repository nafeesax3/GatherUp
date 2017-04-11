package www.gatherup.com.gatherup.data;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by edwinsventura on 3/25/17.
 */

public class AddressGenerator {

    public static String getAddressLine(Context context, double latitude, double longitude){
        String s = "";

        //Geocoder geocoder = new Geocoder(context, Locale.getDefault());
        Geocoder geocoder = new Geocoder(context);
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(addresses.get(0).getAddressLine(0) != null? addresses.get(0).getAddressLine(0): "");
            stringBuilder.append(addresses.get(0).getLocality() != null? ", " + addresses.get(0).getLocality() : "");
            stringBuilder.append(addresses.get(0).getAdminArea() != null? ", " + addresses.get(0).getAdminArea(): "");
            stringBuilder.append(addresses.get(0).getPostalCode() != null? " " + addresses.get(0).getPostalCode(): "");

            //TODO Possibly use featured name?
            String knownName = addresses.get(0).getFeatureName();

            s = stringBuilder.toString();
        } catch (IOException e) {
            // TODO Properly handle this exception
            e.printStackTrace();
        }

        return s;
    }
}
