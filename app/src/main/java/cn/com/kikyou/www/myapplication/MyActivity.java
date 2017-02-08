package cn.com.kikyou.www.myapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * AndroidStudio上的第一个应用程序
 */
public class MyActivity extends ActionBarActivity {

	private ServiceConnection conn;
	private IService myService;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my);
	}

	/**
	 * 绑定业务的方法
	 *
	 * @param v 当前按钮对象
	 */
	public void bind(View v) {
		Intent intent = new Intent(this, MyService.class);
		conn = new MyConn();
		bindService(intent, conn, BIND_AUTO_CREATE);
	}

	/**
	 * 调用业务方法
	 *
	 * @param v 当前按钮对象
	 */
	public void call(View v) {
		myService.useServiceMethod();
	}

	/**
	 * 解绑
	 *
	 * @param v
	 */
	public void unbind(View v) {
		unbindService(conn);
	}

	private class MyConn implements ServiceConnection {

		@Override
		public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
			myService = (IService) iBinder;
		}

		@Override
		public void onServiceDisconnected(ComponentName componentName) {
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my, menu);
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
