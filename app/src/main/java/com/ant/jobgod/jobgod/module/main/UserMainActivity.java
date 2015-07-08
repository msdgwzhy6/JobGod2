package com.ant.jobgod.jobgod.module.main;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ant.jobgod.jobgod.R;
import com.ant.jobgod.jobgod.app.BaseActivity;
import com.ant.jobgod.jobgod.model.bean.Banner;
import com.ant.jobgod.jobgod.model.bean.JobBrief;
import com.ant.jobgod.jobgod.model.bean.Topic;
import com.ant.jobgod.jobgod.model.bean.Trade;
import com.ant.jobgod.jobgod.module.job.JobBriefAdapter;
import com.ant.jobgod.jobgod.widget.LinearWrapContentRecyclerView;
import com.jude.rollviewpager.RollPagerView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nucleus.factory.RequiresPresenter;

/**
 * Created by zhuchenxi on 15/6/27.
 */
@RequiresPresenter(UserMainPresenter.class)
public class UserMainActivity extends BaseActivity<UserMainPresenter> {


    @InjectView(R.id.gdTrade)
    GridView gdTrade;
    @InjectView(R.id.tvHotJobMore)
    TextView tvHotJobMore;
    @InjectView(R.id.tvTopicMore)
    TextView tvTopicMore;
    @InjectView(R.id.guess_more)
    TextView guessMore;
    @InjectView(R.id.mDrawerLayout)
    DrawerLayout mDrawerLayout;
    @InjectView(R.id.insetView)
    TopicsView insetView;
    @InjectView(R.id.lwcrvGuessJob)
    LinearWrapContentRecyclerView lwcrvGuessJob;
    @InjectView(R.id.pvAd)
    RollPagerView pvAd;
    @InjectView(R.id.pagerview_recommend)
    RollPagerView pagerviewRecommend;
    private ActionBarDrawerToggle mDrawerToggle;
    private ArrayAdapter<Trade> tradeArrayAdapter;
    private HotJobAdapter hotJobAdapter;
    private JobBriefAdapter guessAdapter;
    private AdAdapter adAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity_usermain);
        ButterKnife.inject(this);
        setSwipeBackEnable(false);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, getToolbar(), R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerLayout.post(() -> mDrawerToggle.syncState());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        gdTrade.setAdapter(tradeArrayAdapter = new GridViewAdapter(this, R.layout.main_item_trade));
        pagerviewRecommend.setAdapter(hotJobAdapter = new HotJobAdapter(this));
        lwcrvGuessJob.setOrientation(LinearLayout.VERTICAL);
        lwcrvGuessJob.setAdapter(guessAdapter = new JobBriefAdapter(this));
        pvAd.setAdapter(adAdapter = new AdAdapter(this));
    }

    public void setTradeData(Trade[] tradeData) {
        tradeArrayAdapter.clear();
        tradeArrayAdapter.addAll(tradeData);
    }

    public void setTopicData(Topic[] topics) {
        insetView.setTopic(topics);
    }

    public void setHotJobData(JobBrief[] jobData) {
        hotJobAdapter.setData(jobData);
    }

    public void setGuessData(JobBrief[] jobs) {
        guessAdapter.clear();
        guessAdapter.addAll(jobs);
    }

    public void setAdData(Banner[] banners) {
        adAdapter.setData(banners);
    }

}
