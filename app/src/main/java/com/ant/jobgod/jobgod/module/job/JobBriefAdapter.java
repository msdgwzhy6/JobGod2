package com.ant.jobgod.jobgod.module.job;

import android.content.Context;
import android.view.ViewGroup;

import com.ant.jobgod.jobgod.R;
import com.ant.jobgod.jobgod.model.bean.JobBrief;
import com.ant.jobgod.jobgod.util.BaseViewHolder;
import com.ant.jobgod.jobgod.util.RecyclerArrayAdapter;

/**
 * Created by alien on 2015/7/7.
 */
public class JobBriefAdapter extends RecyclerArrayAdapter<JobBrief> {

    public JobBriefAdapter(Context context) {
        super(context);
    }

    @Override
    public void OnBindViewHolder(BaseViewHolder holder, int position) {
        super.OnBindViewHolder(holder, position);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new JobViewHolder(parent, R.layout.job_item_brief);
    }
}
