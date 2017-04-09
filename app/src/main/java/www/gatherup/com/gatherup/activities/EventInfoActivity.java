package www.gatherup.com.gatherup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Locale;

import www.gatherup.com.gatherup.MapsActivity;
import www.gatherup.com.gatherup.R;
import www.gatherup.com.gatherup.data.Event;

public class EventInfoActivity extends AppCompatActivity {
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info);

        event = (Event)getIntent().getExtras().get("event");

        TextView titleTv = (TextView)findViewById(R.id.event_info_title_tv);
        TextView dayTv = (TextView)findViewById(R.id.event_info_day);
        TextView timetv = (TextView)findViewById(R.id.event_info_time);
        TextView addressTv = (TextView)findViewById(R.id.event_info_address);
        TextView hostedByTv = (TextView)findViewById(R.id.event_info_owner);
        final TextView rsvpTv = (TextView)findViewById(R.id.event_info_atendees);
        TextView description = (TextView)findViewById(R.id.event_info_desc);
        final Button rsvpBtn = (Button)findViewById(R.id.event_info_rsvp);
        Button mapBtn = (Button)findViewById(R.id.event_info_open_map_btn);
        Button editBtn = (Button)findViewById(R.id.event_info_edit_btn);


        editBtn.setVisibility(View.GONE);

        titleTv.setText(event.getTitle());
        dayTv.setText(event.getStartDate().getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault()));
        timetv.setText(event.getStartDate().get(Calendar.HOUR) + ":" + event.getStartDate().get(Calendar.MINUTE) + " " + event.getStartDate().getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault()) + " to " + event.getEndDate().get(Calendar.HOUR) + ":" + event.getEndDate().get(Calendar.MINUTE) + " " + event.getEndDate().getDisplayName(Calendar.AM_PM, Calendar.SHORT, Locale.getDefault()));
        addressTv.setText(event.getAddress());
        hostedByTv.setText(event.getOwner().getFullName());
        rsvpTv.setText(event.getAtendeesList().size() + " people are going");
        description.setText(event.getDescription());

        rsvpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"You succesfully registered", Toast.LENGTH_SHORT).show();
                rsvpBtn.setEnabled(false);

                rsvpTv.setText(event.getAtendeesList().size()+1 + " people are going");
            }
        });

        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EventInfoActivity.this, MapsActivity.class);
                intent.putExtra("event", event);
                startActivity(intent);
            }
        });

    }
}
