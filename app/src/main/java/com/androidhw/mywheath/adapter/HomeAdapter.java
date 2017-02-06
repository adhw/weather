package com.androidhw.mywheath.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidhw.mywheath.R;
import com.androidhw.mywheath.bean.Api;
import com.androidhw.mywheath.bean.WeatherForecast;
import com.androidhw.mywheath.bean.WeatherService;
import com.androidhw.mywheath.globle.App;
import com.androidhw.mywheath.utils.RetrofitService;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.functions.Func1;

/**
 * 主界面的适配器
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {
//	private List<>


	/**
	 * 得到viewholder
	 *
	 * @param parent
	 * @param viewType
	 * @return
	 */
	@Override
	public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View view = View.inflate(App.context, R.layout.item_recyclerview_home, null);
		HomeViewHolder viewHolder = new HomeViewHolder(view);
		return viewHolder;
	}

	@Override
	public void onBindViewHolder(HomeViewHolder holder, final int position) {
		WeatherService retrofit = RetrofitService.createRetrofit(WeatherService.class);
		Observable<WeatherForecast> observable = retrofit.getForecast("重庆", Api.KEY, "中国");
		observable.map(new Func1<WeatherForecast, String>() {
			@Override
			public String call(WeatherForecast weatherForecast) {
				weatherForecast.getHeWeather5().get(position).getDaily_forecast().get(position).getTmp();
				return null;
			}
		});

	}

	@Override
	public int getItemCount() {
		return 0;
	}

	class HomeViewHolder extends RecyclerView.ViewHolder {
		@Bind(R.id.iv_weather_icon)
		ImageView ivWeatherIcon;
		@Bind(R.id.tv_home_time)
		TextView tvHomeTime;
		@Bind(R.id.tv_home_temperature)
		TextView tvHomeTemperature;

		public HomeViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}
	}
}
