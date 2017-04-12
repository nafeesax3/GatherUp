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

import www.gatherup.com.gatherup.data.DetailedEvent;

/**
 * Created by edwinsventura on 3/25/17.
 */

public class EventListViewAdapter extends ArrayAdapter<DetailedEvent> {

    public EventListViewAdapter(Context context, ArrayList<DetailedEvent> detailedEvents){
        super(context, 0, detailedEvents);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DetailedEvent detailedEvent = getItem(position);

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

        shortDay.setText(detailedEvent.getStartDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, Locale.getDefault()) );
        dayNumber.setText(String.valueOf(detailedEvent.getEndDate().get(Calendar.DAY_OF_MONTH)) );
        title.setText(detailedEvent.getTitle());
        //location.setText(AddressGenerator.getAddressLine(getContext(), detailedEvent.getLatitude(), detailedEvent.getLongitude()));
        location.setText(detailedEvent.getAddress());
        dayAndTime.setText(detailedEvent.getStartDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()) + " " + detailedEvent.getStartDate().get(Calendar.HOUR) + ":" + detailedEvent.getStartDate().get(Calendar.MINUTE) + " " + detailedEvent.getStartDate().getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault()));
        category.setText(detailedEvent.getCategory());
        numberOfPeople.setText("RSVP: " + String.valueOf( detailedEvent.getAtendeesList().size()));


        return convertView;
    }
}
