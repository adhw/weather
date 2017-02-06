package com.androidhw.mywheath.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidhw.mywheath.R;
import com.androidhw.mywheath.adapter.HomeAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 主页的界面
 */

public class HomeFragment extends Fragment {
	@Bind(R.id.rl_home_fragment)
	RecyclerView rlHomeFragment;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = View.inflate(getActivity(), R.layout.home_fragment, null);
		ButterKnife.bind(this, view);
		rlHomeFragment.setAdapter(new HomeAdapter());
		return view;
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.unbind(this);
	}
}
