package com.androidhw.mywheath.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hw on 2017/1/19.
 */

public class RetrofitService {
	public final static String BASE_URL = "https://free-api.heweather.com/v5";
	public static Retrofit retrofit = new Retrofit.Builder()
			.baseUrl(BASE_URL)
			.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.build();

	public static <S> S createRetrofit(Class<S> service) {
		return retrofit.create(service);
	}

}
