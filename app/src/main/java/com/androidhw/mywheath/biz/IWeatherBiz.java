package com.androidhw.mywheath.biz;

/**
 * 得到天气的信息方法
 */

public interface IWeatherBiz {
	/**
	 * 	得到天气信息的方法

	 */
	void getInfo(String city,String key,String lang);
}
