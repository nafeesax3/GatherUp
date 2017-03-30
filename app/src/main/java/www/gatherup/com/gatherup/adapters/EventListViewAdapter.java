package www.gatherup.com.gatherup.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

//import com.example.seniorproject.test.R;
import www.gatherup.com.gatherup.R;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import www.gatherup.com.gatherup.data.AddressGenerator;
import www.gatherup.com.gatherup.data.Event;

/**
 * Created by edwinsventura on 3/25/17.
 */

public class EventListViewAdapter extends ArrayAdapter<Event> {

    public EventListViewAdapter(Context context, ArrayList<Event> events){
        super(context, 0, events);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Event event = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_event, parent, false);
        }

        TextView shortDay = (TextView)convertView.findViewById(R.id.item_event_day_ofw);
        TextView dayNumber = (TextView)convertView.findViewById(R.id.item_event_day_number);
        TextView title = (TextView)convertView.findViewById(R.id.item_event_title);
        TextView location = (TextView)convertView.findViewById(R.id.item_event_address);
        TextView dayAndTime = (TextView)convertView.findViewById(R.id.item_event_date);
        TextView category = (TextView)convertView.findViewById(R.id.item_event_category);
        TextView numberOfPeople = (TextView)convertView.findViewById(R.id.item_event_people);

        shortDay.setText(event.getStartDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()) );
        dayNumber.setText(String.valueOf(event.getEndDate().get(Calendar.DAY_OF_MONTH)) );
        title.setText(event.getTitle());
        //location.setText(AddressGenerator.getAddressLine(getContext(), event.getLatitude(), event.getLongitude()));
        location.setText(event.getAddress());
        dayAndTime.setText(event.getStartDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()) + " " + event.getStartDate().get(Calendar.HOUR) + ":" + event.getStartDate().get(Calendar.MINUTE) + " " + event.getStartDate().getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault()));
        category.setText(event.getCategory());
        numberOfPeople.setText("RSVP: " + String.valueOf( event.getAtendeesList().size()));


        return convertView;
    }
}
