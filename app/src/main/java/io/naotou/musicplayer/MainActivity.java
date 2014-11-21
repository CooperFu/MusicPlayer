package io.naotou.musicplayer;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    private ViewPager mPager;
    public List<View> pagerList;
    private ImageButton btn_main;
    private ImageButton btn_list;
    private ImageButton btn_lyric;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        mPager = (ViewPager) findViewById(R.id.pager);
        pagerList = new ArrayList<View>();
        View viewPlay = getLayoutInflater().inflate(R.layout.view_play, null);
        View viewList = getLayoutInflater().inflate(R.layout.view_list, null);
        View viewLyric = getLayoutInflater().inflate(R.layout.view_lyric, null);
        pagerList.add(viewPlay);
        pagerList.add(viewList);
        pagerList.add(viewLyric);


        PagerAdapter mPagerAdapter = new MyPagerAdapter();
        mPager.setAdapter(mPagerAdapter);
        initTitleView();
        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i) {
                    case 0:
                        btn_main.setEnabled(false);
                        btn_list.setEnabled(true);
                        btn_lyric.setEnabled(true);
                        break;
                    case 1:
                        btn_main.setEnabled(true);
                        btn_list.setEnabled(false);
                        btn_lyric.setEnabled(true);
                        break;
                    case 2:
                        btn_main.setEnabled(true);
                        btn_list.setEnabled(true);
                        btn_lyric.setEnabled(false);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });


    }

    private void initTitleView() {

        btn_main = (ImageButton) findViewById(R.id.btn_main);
        btn_list = (ImageButton) findViewById(R.id.btn_list);
        btn_lyric = (ImageButton) findViewById(R.id.btn_lyric);
        //进入程序让第一个显示成被按下的状态.
        btn_main.setEnabled(false);
        btn_list.setEnabled(true);
        btn_lyric.setEnabled(true);
        btn_main.setOnClickListener(this);
        btn_list.setOnClickListener(this);
        btn_lyric.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_main:
                mPager.setCurrentItem(0);
                break;
            case R.id.btn_list:
                mPager.setCurrentItem(1);
                break;
            case R.id.btn_lyric:
                mPager.setCurrentItem(2);
                break;
        }
    }

    private class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {

            return pagerList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {

            return view == o;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.addView(pagerList.get(position));

            return pagerList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {

            container.removeView(pagerList.get(position));

        }
    }
}
