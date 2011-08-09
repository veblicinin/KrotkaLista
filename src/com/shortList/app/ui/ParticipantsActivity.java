package com.shortList.app.ui;
 

import static com.shortList.app.db.Constants.KEY_USER_NAME;
import static com.shortList.app.db.Constants.KEY_USER_NAME_POSITION;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.SimpleCursorAdapter.CursorToStringConverter;

import com.shortList.app.db.DBAdapter;
import com.shortList.app.model.Event;

public class ParticipantsActivity extends   ListActivity {

	protected DBAdapter myDB = null; 
	protected SimpleCursorAdapter adapter;
	
	protected final int CREATE_NEW_PARTICIPANT = 1;

    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        Event event = null;
         myDB = new DBAdapter(this);
        Cursor c = myDB.getParticipants(event);
        startManagingCursor(c);    

          adapter = new SimpleCursorAdapter(this,
                android.R.layout.activity_list_item, c, 
                new String[] { KEY_USER_NAME },
                new int[] { android.R.id.text1 });

        adapter.setCursorToStringConverter(new CursorToStringConverter() {
            public CharSequence convertToString(Cursor theCursor) {
                String number = theCursor.getString(KEY_USER_NAME_POSITION); 
                return number ;
            }
        }); 

        this.setListAdapter(adapter);
    }     
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.participant_menu, menu);
		return true;
	}
	
	@Override
	protected void onPrepareDialog(int id, Dialog dialog) {
		AlertDialog d = (AlertDialog) dialog;	

		switch(id){
			case CREATE_NEW_PARTICIPANT:
				
		}
		
		// TODO Auto-generated method stub
		//super.onPrepareDialog(id, dialog);
	}
	
	@Override
	protected Dialog onCreateDialog(int id, Bundle args) {
		Dialog dialog = null;
		switch(id){
		case CREATE_NEW_PARTICIPANT:
			LayoutInflater factory = LayoutInflater.from(this);
            final View textEntryView = factory.inflate(R.layout.alert_dialog_new_participant, null);
            return new AlertDialog.Builder(this)
             //   .setIconAttribute(android.R.attr.alertDialogIcon)
                //.setTitle(R.string.alert_dialog_text_entry)
            .setTitle("dodaj uzytkownika")
                .setView(textEntryView)
                .setPositiveButton("Tak", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        /* User clicked OK so do some stuff */
                    }
                })
                .setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        /* User clicked cancel so do some stuff */
                    }
                })
                .create(); 
		default:
	        dialog = null;
		}
		return dialog;
	}
    
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		switch (item.getItemId()) {
			case R.id.participants:
				showDialog(CREATE_NEW_PARTICIPANT);
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}
	
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
//		Log.d(LOG_TAG, "clicked:" +  ((SQLiteCursor)adapter.getItem(position)).getString(DBAdapter.KEY_URL_POSITION) + " id:" + id + " position: " + position);
//		super.onListItemClick(l, v, position, id);		
//		Bundle bun = new Bundle(); 				
//		bun.putInt(DBAdapter.KEY_ROWID, position);
//		bun.putString(DBAdapter.KEY_URL, ((SQLiteCursor)adapter.getItem(position)).getString(DBAdapter.KEY_URL_POSITION) );						
//		Intent intent = new Intent();
//		intent.putExtras(bun);
//        setResult(RESULT_OK, intent);
//        finish();
	}
}
