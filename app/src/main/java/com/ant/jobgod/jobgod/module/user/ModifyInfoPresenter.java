package com.ant.jobgod.jobgod.module.user;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.android.http.RequestMap;
import com.ant.jobgod.jobgod.app.BasePresenter;

/**
 * Created by alien on 2015/7/10.
 */
public class ModifyInfoPresenter extends BasePresenter<ModifyInfoActivity> {

    private final int REQUEST_CODE = 1;
    private final int RESULT_CODE = 0;

    @Override
    protected void onCreate(Bundle savedState) {
        super.onCreate(savedState);
    }

    @Override
    protected void onCreateView(ModifyInfoActivity view) {
        super.onCreateView(view);
    }

    public void submitInfo(RequestMap param) {
        param.put("id", readStandVar("id", 0) + "");
        /**
         * 接下来去post到服务器
         */
    }

    public void toModifyDataActivityForResult(ModifyInfoActivity.InfoFlag flag, TextView view) {
        Intent intent = new Intent(getView(), ModifyDataActivity.class);
        intent.putExtra(ModifyInfoActivity.KEY_FLAG, flag);
        intent.putExtra("data", view.getText().toString());
        getView().startActivityForResult(intent, REQUEST_CODE);
    }

}