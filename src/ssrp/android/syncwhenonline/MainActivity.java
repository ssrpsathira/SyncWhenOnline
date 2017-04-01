package ssrp.android.syncwhenonline;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import ssrp.android.syncwhenonline.entity.User;
import ssrp.android.syncwhenonline.orm.UserService;
import ssrp.android.syncwhenonline.service.Syncer;

public class MainActivity extends Activity {

	private EditText nameField;
	private Button saveDataButton;

	private UserService userService;
	private Syncer syncer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		nameField = (EditText) findViewById(R.id.name);
		saveDataButton = (Button) findViewById(R.id.btn_save_data);

		userService = new UserService(getApplicationContext());
		syncer = new Syncer(getApplicationContext());

		saveDataButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Toast.makeText(getApplicationContext(), nameField.getText().toString(), Toast.LENGTH_SHORT).show();
				User user = new User();
				user.setName(nameField.getText().toString());
				user.setIsSynced(0);

				userService.insertUser(user);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
