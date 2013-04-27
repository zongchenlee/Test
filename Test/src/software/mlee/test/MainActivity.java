package software.mlee.test;

import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Window;

public class MainActivity extends FragmentActivity {

	private SectionsPagerAdapter mSectionsPagerAdapter;
	private List<Fragment> m_CFragList;

	private ViewPager mViewPager;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		
//		m_CFragList = new List<Fragment>();

		Fragment1 f1 = new Fragment1();
		Fragment2 f2 = new Fragment2();
		Fragment3 f3 = new Fragment3();
		m_CFragList.add(f1);
		m_CFragList.add(f2);
		m_CFragList.add(f3);

		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),m_CFragList);

		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setCurrentItem(1);

	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {
		private List<Fragment> fragList;

		public SectionsPagerAdapter(FragmentManager fm,List<Fragment> list) {
			super(fm);
			fragList = list;
		}

		@Override
		public Fragment getItem(int position) {
			return fragList.get(position);
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			}
			return null;
		}
	}

}
