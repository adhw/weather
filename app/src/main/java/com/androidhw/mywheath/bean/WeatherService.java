package com.androidhw.mywheath.bean;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by hw on 2017/1/19.
 */

public interface WeatherService {
	//获取天气预报
	@GET("/forecast")
	Observable<WeatherForecast> getForecast(@Query("city") String city, @Query("key") String key, @Query("lang") String lang);

}
