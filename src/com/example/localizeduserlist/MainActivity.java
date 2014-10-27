package com.example.localizeduserlist;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	public char USER_COUNT = '0'; 
	public MyDBHandler dbHandler;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		dbHandler = new MyDBHandler(this, null, null, 1);
	
		ListView listView = (ListView) findViewById(R.id.listView1);
			
		Cursor cursor = dbHandler.getCursor();
		myCursorAdapter cursorAdapter = new myCursorAdapter(this, R.layout.listview_row , cursor, 0);
		listView.setAdapter(cursorAdapter);
	/*	
		String title = "  " + getResources().getQuantityString(R.plurals.users, dbHandler.getUserCount());	// getResources().getString(R.string.title).valueOf(title);
		
		//OMFG MUCH HACK WOW 
		
		 
		 Display display = getWindowManager().getDefaultDisplay();
		 Point size = new Point();
		 display.getSize(size);
		 int width = size.x;
		 
		int id = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView txtTitle = (TextView) findViewById(id);
        txtTitle.setGravity(Gravity.CENTER);
        txtTitle.setWidth(width);
       
		
        setTitle(title);
*/ 	}

	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
   
        return super.onCreateOptionsMenu(menu);
    }
	
	@Override
	protected void onResume(){
		super.onResume();
		
		dbHandler = new MyDBHandler(this, null, null, 1);
	
		ListView listView = (ListView) findViewById(R.id.listView1);
		
		Cursor cursor = dbHandler.getCursor();
		myCursorAdapter cursorAdapter = new myCursorAdapter(this, R.layout.listview_row , cursor, 0);
		listView.setAdapter(cursorAdapter);
		
		String title = " "+dbHandler.getUserCount() + " " + getResources().getQuantityString(R.plurals.users, dbHandler.getUserCount());
	
		//icon
		getActionBar().setDisplayShowHomeEnabled(false);
		//---- move title 
		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x;
	//	width = width - 32;
	
		int id = Resources.getSystem().getIdentifier("action_bar_title", "id", "android");
        TextView txtTitle = (TextView) findViewById(id);
        txtTitle.setGravity(Gravity.CENTER);
        txtTitle.setWidth(width);
        //---- end of move title
		
        setTitle(title);
	}

	  @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Take appropriate action for each action item click
	        switch (item.getItemId()) {
	        case R.id.action_bar_new_user_button:
	           
	        	addUser(null);
	            return true;
	      
	       
	        default:
	            return super.onOptionsItemSelected(item);
	        }
	    }
	
	
	public void addUser(View view){
		Intent intent = new Intent(this, AddNewUserActivity.class);
		startActivity(intent);
	}
	
	
}
