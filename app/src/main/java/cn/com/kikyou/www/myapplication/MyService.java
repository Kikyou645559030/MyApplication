package cn.com.kikyou.www.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * 服务
 */
public class MyService extends Service {
	public MyService() {
	}

	@Override
	public IBinder onBind(Intent intent) {
		return new MyBind();
	}

	private void businessMethod() {
		System.err.println("我被调用到了");
	}

	private class MyBind extends Binder implements IService {

		@Override
		public void useServiceMethod() {
			businessMethod();
		}
	}
}
