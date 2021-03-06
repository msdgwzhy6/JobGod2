package com.ant.jobgod.jobgod.module.job;

import android.content.Context;
import android.view.ViewGroup;

import com.ant.jobgod.jobgod.model.bean.JobBrief;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * Created by alien on 2015/7/7.
 */
public class JobBriefAdapter extends RecyclerArrayAdapter<JobBrief> {

    public JobBriefAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new JobViewHolder(parent);
    }
}
