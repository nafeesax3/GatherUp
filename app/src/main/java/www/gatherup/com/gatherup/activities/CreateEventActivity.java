package www.gatherup.com.gatherup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import www.gatherup.com.gatherup.HomeScreenActivity;
import www.gatherup.com.gatherup.R;

public class CreateEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event);

        Button createButton = (Button)findViewById(R.id.create_event_create_btn);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CreateEventActivity.this, HomeScreenActivity.class);
                startActivity(intent);
            }
        });
    }
}
