package com.example.localizeduserlist;


import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddNewUserActivity extends Activity {

	
	TextView idBox; 
	EditText nameBox; 
	EditText addressBox; 
	EditText phoneBox; 

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_user);
		
		
		
		//icon
		getActionBar().setDisplayShowHomeEnabled(false);
	
		//hiding default app icon
		ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowHomeEnabled(false);
		//displaying custom ActionBar
		View mActionBarView = getLayoutInflater().inflate(R.layout.action_bar_add_new_users, null);
		actionBar.setCustomView(mActionBarView);
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)	;
		
		
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
		int height = size.y;
		
		TextView txtTitle = (TextView) findViewById(R.id.add_new_user_title_text);
       
        
		txtTitle.setWidth(width);
        txtTitle.setHeight(height);
        txtTitle.setGravity(Gravity.CENTER );
		
     
		
		
	}
	
	
	@Override
	protected void onStart(){
		super.onStart();
		idBox = (TextView) findViewById(R.id.add_new_user_text);
		nameBox = (EditText) findViewById(R.id.editTextName);
		addressBox = (EditText) findViewById(R.id.editTextAddress);
		phoneBox = (EditText) findViewById(R.id.editTextPhone);
		
	}
	
	public void back(View view){
		finish();
	}
	
	public void addUser(View view){
		
		   MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
	    	
    	   User user = 
              new User(nameBox.getText().toString() ,addressBox.getText().toString(), phoneBox.getText().toString());
    	
    	   dbHandler.addUser(user);
    	   finish();
		
	}
		
}
