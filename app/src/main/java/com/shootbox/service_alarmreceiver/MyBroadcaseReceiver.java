/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/10/12 5:12:21
 * Project: Service_AlarmReceiver
 * File: MyBroadcaseReceiver.java
 * Class: MyBroadcaseReceiver
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.shootbox.service_alarmreceiver;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yangyankai on 2015/10/12.
 */
public class MyBroadcaseReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent)
	{
		//		Log.e("aaa", "time  broadCastReceiver");
		//		Log.e("aaa","receive");

		boolean         isServiceRunning = false;
		ActivityManager manager          = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE))
		{
			if ("com.shootbox.service_alarmreceiver.LongRunningService".equals(service.service.getClassName()))
			{
				isServiceRunning = true;
			}
		}
		if (!isServiceRunning)
		{
			Intent mIntent = new Intent(context, LongRunningService.class);
			mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startService(mIntent);

		}
		else
		{
			Log.e("aaa", "service already running");

		}

	}
}

// Service
//		10-12 17:26:00.055 24177-24488/? E/aaa: service executed at  Mon Oct 12 17:26:00 GMT+08:00 2015
//		10-12 17:27:00.140 24177-24177/? E/aaa: service already running
//		10-12 17:28:00.300 24177-24177/? E/aaa: service already running
//		10-12 17:29:00.090 24177-24177/? E/aaa: service already running