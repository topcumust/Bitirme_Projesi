package com.example.register;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Login extends Activity {


@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_main);

    final DatabaseHandler db = new DatabaseHandler(this);

	final Intent intent = new Intent(this, Home.class);
	final Intent intent2 = new Intent(this, MainActivity.class);
	
	Button submit = (Button) findViewById(R.id.submit);
	Button get_new_account = (Button) findViewById(R.id.create_New_Account);
    final TextView error_message=(TextView)findViewById(R.id.error_message);

	submit.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Bundle bundle = new Bundle();
	        String first="",second="";
			EditText username = (EditText) findViewById(R.id.editTex_Username);
			EditText password = (EditText) findViewById(R.id.editText_Password);
			String userName = username.getText().toString();
			String userPassword = password.getText().toString();
			// Burda veritaban�na kaydetmem gerekiyor

            if(db.checkUser(userName, userPassword))
            {
                bundle.putString("userName", userName);
                bundle.putString("userPassword", userPassword);
                intent.putExtras(bundle);
                startActivity(intent);
                System.out.println("Do�ru");
            }
            else{

                error_message.setText("Hatal� giri� tekrar  deneyiniz");

            }

		}
	});
			
			
	get_new_account.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			startActivity(intent2);
		}
	});	
	
	
}
}
