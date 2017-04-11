package www.gatherup.com.gatherup.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import www.gatherup.com.gatherup.R;

public class SearchEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_event);

        Button mapButton = (Button)findViewById(R.id.search_event_map_btn);
        Button listButton = (Button)findViewById(R.id.search_event_list_btn);

        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO move to map activity/fragment
                Intent intent = new Intent(SearchEventActivity.this, SearchMapActivity.class);
                startActivity(intent);
            }
        });

        listButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO move to list activity/fragment
                Intent intent = new Intent(SearchEventActivity.this, SearchListActivity.class);
                startActivity(intent);
            }
        });

    }
}
