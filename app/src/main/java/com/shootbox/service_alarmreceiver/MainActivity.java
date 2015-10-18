/*
 * Copyright (c) 2015-2015 by Shanghai shootbox Information Technology Co., Ltd.
 * Create: 2015/10/12 5:10:35
 * Project: Service_AlarmReceiver
 * File: MainActivity.java
 * Class: MainActivity
 * Module: app
 * Author: yangyankai
 * Version: 1.0
 */

package com.shootbox.service_alarmreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


//		Intent intent=new Intent(this,LongRunningService.class);
//		startService(intent);


		Log.e("aaa", "mainActivity");
		IntentFilter filter=new IntentFilter();
		filter.addAction(Intent.ACTION_TIME_TICK);
		MyBroadcaseReceiver receiver=new MyBroadcaseReceiver();
		registerReceiver(receiver, filter);
	}
}
