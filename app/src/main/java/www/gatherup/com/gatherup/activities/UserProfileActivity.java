package www.gatherup.com.gatherup.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import www.gatherup.com.gatherup.R;
import www.gatherup.com.gatherup.models.UserModel;

public class UserProfileActivity extends AppCompatActivity {

    private TextView username_TV;
    private TextView fullname_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        username_TV = (TextView)findViewById(R.id.username_TV);
        fullname_TV = (TextView)findViewById(R.id.fullname_TV);

        username_TV.setText(UserModel.get().getAccountName());
        fullname_TV.setText(UserModel.get().getFullname());
    }
}
