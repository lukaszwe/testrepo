package com.example.localizeduserlist;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDBHandler extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "userDB.db";
	private static final String TABLE_USERS = "users";
	
	public static final String COLUMN_ID = "id"; 
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_ADDRESS = "address";
	public static final String COLUMN_PHONE = "phone";
	
	public MyDBHandler(Context context, String name, 
			CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "(" + COLUMN_ID 
				+ " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME + " TEXT," + COLUMN_ADDRESS + " TEXT," 
				+ COLUMN_PHONE + " TEXT" +" )";
		db.execSQL(CREATE_USERS_TABLE);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Recreate database after upgrade
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
		onCreate(db);
	}
	
	public int getUserCount(){
		String query = "SELECT * from " + TABLE_USERS;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
//		Log.i("ss", String.valueOf(cursor.getCount()));
//		String counter = String.valueOf(cursor.getCount());
		int counter = cursor.getCount();
		cursor.close();
		db.close();
		return counter;
	}
	
	
	public Cursor getCursor(){
		//Alias id table as _id (needed for CursorAdapter)
		String query = "select id _id, * from " + TABLE_USERS;
		SQLiteDatabase db = this.getReadableDatabase();
		return db.rawQuery(query, null);
	}
	
	
	//TODO getAllUsers propably wont be used anymore 
	public List<User> getAllUsers(){
		List<User> userList = new ArrayList<User>();
		
		String query = "Select * from " + TABLE_USERS;
		
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		
		if(cursor.moveToFirst()){
			do{
				User user = new User();
				user.setId(Integer.parseInt(cursor.getString(0)));
				user.setName(cursor.getString(1));
				user.setAddress(cursor.getString(2));
				user.setPhone(cursor.getString(3));
				userList.add(user);
			}while (cursor.moveToNext());
		}
		
		return userList;
		
	}
	
	public void addUser(User user){
		ContentValues values = new ContentValues();
		values.put("name", user.getName());
		values.put("address ",user.getAddress());
		values.put("phone ", user.getPhone());
		
		SQLiteDatabase db = this.getWritableDatabase();
	
		db.insert(TABLE_USERS, null, values);
		db.close();
	}
	
	//TODO: getRows - Not used anymore - remove later
	public ArrayList<String> getRows(){
		String query = "SELECT * FROM " + TABLE_USERS;
		
		ArrayList<String> rowArray = new ArrayList<String>();
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(query, null);
		 if (cursor.moveToFirst())
		    {
		        while ( !cursor.isAfterLast() ){
		           rowArray.add( cursor.getString( cursor.getColumnIndex("name")) );
		           cursor.moveToNext();
		        }
		    }
		return rowArray;
	}
	
	//TODO: findUser wont be used propably anymore
	public User findUser(String username){
		String query = "Select * from " + TABLE_USERS + " WHERE " + COLUMN_ADDRESS + "= \"" + username +"\"";
		
		SQLiteDatabase db = this.getWritableDatabase();
		
		Cursor cursor = db.rawQuery(query, null);
		
		User user = new User();
		
		if(cursor.moveToFirst()){
			cursor.moveToFirst();
			user.setId(Integer.parseInt(cursor.getString(0)));
			user.setAddress(cursor.getString(1));
			user.setPhone(cursor.getString(2));
			cursor.close();
		}else{
			user = null;
		}
		db.close();
		return user;
		
	}
	
	//TODO ??? DELETE USER ???

}






