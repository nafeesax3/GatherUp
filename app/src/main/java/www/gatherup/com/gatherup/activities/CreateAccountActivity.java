package www.gatherup.com.gatherup.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.seniorproject.test.R;
import www.gatherup.com.gatherup.LoginActivity;
import www.gatherup.com.gatherup.R;

import www.gatherup.com.gatherup.data.User;

/**
 * Created by edwinsventura on 3/23/17.
 */

public class CreateAccountActivity extends AppCompatActivity {

    User newUser;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.account_creation_activity);

        newUser = new User();

        Button createBtn = (Button)findViewById(R.id.create_acc_create_btn);
        final EditText usernameEdit = (EditText)findViewById(R.id.create_acc_username_edit);
        final EditText fullNameEdit = (EditText)findViewById(R.id.create_acc_name_edit);
        final EditText emailEdit = (EditText)findViewById(R.id.create_acc_email_edit);
        final EditText passEdit = (EditText)findViewById(R.id.create_acc_pass_edit);
        final EditText passConfirmEdit = (EditText)findViewById(R.id.create_acc_pass_confirm_edit);


        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = "User succesfully created";
                boolean isUserValid = true;

                String username = usernameEdit.getText().toString();
                String fullName = fullNameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String password = passEdit.getText().toString();
                String passwordConfirm = passConfirmEdit.getText().toString();


                // Validate user creation
                if(username.length() == 0){
                    message = "Empty username not valid";
                    isUserValid = false;
                }

                if(fullName.length() == 0){
                    message = "Empty name not valid";
                    isUserValid = false;
                }

                String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
                java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(emailPattern);
                java.util.regex.Matcher matcher = pattern.matcher(email);

                if(!matcher.matches()){
                    message =  "The email address "+ email +" is invalid";
                    isUserValid = false;
                }

                if(!password.equals(passwordConfirm)){
                    message = "Passwords don't match";
                    isUserValid = false;
                }

                if (passEdit.length() == 0 || passConfirmEdit.length() == 0){
                    message = "Empty passwords are not allowed";
                    isUserValid = false;
                }

                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                if(isUserValid){

                    newUser.setPasswordHash(password);
                    newUser.setUsername(username);
                    newUser.setFullName(fullName);
                    newUser.setEmail(email);
                    // TODO Send user information to online db

                    // TODO Pass user info to next activity
                    Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
                    Bundle bundle = new Bundle();
                    startActivity(intent);

                }


            }
        });


    }
}
