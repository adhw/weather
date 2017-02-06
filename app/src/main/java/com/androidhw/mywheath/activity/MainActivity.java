package com.androidhw.mywheath.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.androidhw.mywheath.R;
import com.androidhw.mywheath.adapter.HomePagerAdapter;
import com.androidhw.mywheath.fragment.CityFragment;
import com.androidhw.mywheath.fragment.HomeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

	@Bind(R.id.tl_main_title)
	Toolbar tlMainTitle;
	@Bind(R.id.vp_show)
	ViewPager vpShow;
	@Bind(R.id.nav_view)
	NavigationView navView;
	@Bind(R.id.draw_layout)
	DrawerLayout drawLayout;
	@Bind(R.id.header_tablayout)
	TabLayout headerTablayout;
	private HomePagerAdapter homePagerAdapter;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		//初始化布局
		initView();
		intiDrawer();
	}

	/**
	 * 初始化抽屉
	 */
	private void intiDrawer() {
		if (navView != null) {
			//给他设置监听,点击里面的条目时触发事件
			navView.setNavigationItemSelectedListener(this);
			ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this, drawLayout, tlMainTitle, R.string.open, R.string.close);
			//给抽屉添加拖动的监听
			drawLayout.addDrawerListener(drawerToggle);
			//同步状态
			drawerToggle.syncState();

		}
	}

	private void initView() {
		setSupportActionBar(tlMainTitle);
		homePagerAdapter = new HomePagerAdapter(getSupportFragmentManager());
		homePagerAdapter.addFragmentAndTitle(new HomeFragment(), "主界面");
		homePagerAdapter.addFragmentAndTitle(new CityFragment(), "多城市");
		vpShow.setAdapter(homePagerAdapter);
		headerTablayout.setupWithViewPager(vpShow,false);
	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {
		return false;
	}
}
