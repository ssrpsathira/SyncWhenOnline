package ssrp.android.syncwhenonline.orm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import ssrp.android.syncwhenonline.entity.User;
import ssrp.android.syncwhenonline.helper.DatabaseHelper;

public class UserService {
	private DatabaseHelper dbHelper;
	private SQLiteDatabase database;
	
	private static final String TABLE_USER = "user";
	
	public final static String USER_NAME = "name";
	public final static String USER_IS_SYNCED = "is_synced";

	public UserService(Context context) {
		dbHelper = new DatabaseHelper(context);
		database = dbHelper.getWritableDatabase();
	}

	public long insertUser(User user) {
		ContentValues values = new ContentValues();
		
		values.put(USER_NAME, user.getName());
		values.put(USER_IS_SYNCED, 0);
		
		return database.insert(TABLE_USER, null, values);
	}
}
