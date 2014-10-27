package com.example.localizeduserlist;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class myCursorAdapter extends ResourceCursorAdapter {

	
	
	public myCursorAdapter(Context context, int layout, Cursor c, int flags) {
		super(context, layout, c, flags);
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		TextView name = (TextView) view.findViewById(R.id.textView_row_name);
		name.setText(cursor.getString(cursor.getColumnIndex("name")));
		
		TextView address = (TextView) view.findViewById(R.id.textView_row_address);
		address.setText(cursor.getString(cursor.getColumnIndex("address")));
		
		TextView phone = (TextView) view.findViewById(R.id.textView_row_phone);
		phone.setText(cursor.getString(cursor.getColumnIndex("phone")));
		
		
	}

}
