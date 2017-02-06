package com.androidhw.mywheath.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hw on 2017/1/19.
 */
public class HomePagerAdapter extends FragmentPagerAdapter {
	//Fragment的集合
	private List<Fragment> fragments = new ArrayList<>();
	private List<String> tabTitles = new ArrayList<>();

	public HomePagerAdapter(FragmentManager fm) {
		super(fm);
	}

	/**
	 * 添加Fragment和标题
	 *
	 * @param fragment Fragment碎片
	 * @param title    viewpager上的标题
	 */
	public void addFragmentAndTitle(Fragment fragment, String title) {
		fragments.add(fragment);
		tabTitles.add(title);
	}

	@Override
	public Fragment getItem(int position) {
		return fragments.get(position);
	}

	@Override
	public int getCount() {
		return fragments.size();
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabTitles.get(position);
	}
}
