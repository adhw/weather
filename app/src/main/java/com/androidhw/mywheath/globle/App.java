package com.androidhw.mywheath.globle;

import android.app.Application;
import android.content.Context;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by hw on 2017/1/19.
 */

public class App extends Application {
	public static  Context context;
	@Override
	public void onCreate() {
		super.onCreate();
		context =this;
		if (LeakCanary.isInAnalyzerProcess(this)) {
			return;
		}
		LeakCanary.install(this);
	}
}
