package ssrp.android.syncwhenonline.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import ssrp.android.syncwhenonline.helper.DatabaseHelper;

public class Syncer extends BroadcastReceiver {
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;

	private boolean isConnected;

	public Syncer(Context context) {
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		this.setConnected(intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false));
	}

	public boolean isConnected() {
		return isConnected;
	}

	public void setConnected(boolean isConnected) {
		this.isConnected = isConnected;
	}
}
