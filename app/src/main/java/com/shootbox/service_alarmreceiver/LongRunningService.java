/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/10/12 5:9:38
 * Project: Service_AlarmReceiver
 * File: LongRunningService.java
 * Class: LongRunningService
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/9/16 3:40:23
 * Project: T
 * File: LongRunningService.java
 * Class: LongRunningService
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.shootbox.service_alarmreceiver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.Date;

/**
 * Created by yangyankai on 2015/9/16.
 */
public class LongRunningService extends Service
{
	@Nullable
	@Override
	public IBinder onBind(Intent intent)
	{
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId)
	{
		Log.e("aaa", "Service");
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{

//				while (true){
//					Log.e("aaa","service executed at  "+new Date().toString());
//					try
//					{
//						Thread.sleep(10000);
//					} catch (InterruptedException e)
//					{
//						e.printStackTrace();
//					}
//				}
				Log.e("aaa","service executed at  "+new Date().toString());

			}
		}).start();

		stopSelf();// 结束服务，节省资源。等待广播唤醒

		return super.onStartCommand(intent, flags, startId);
	}
}
