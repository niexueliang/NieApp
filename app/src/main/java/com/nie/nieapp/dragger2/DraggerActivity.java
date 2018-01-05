package com.nie.nieapp.dragger2;

import com.nie.nieapp.R;
import com.nie.nieapp.databinding.ActivityDraggerBinding;
import com.nie.nieapp.dragger2.contract.DraggerDemoContract;
import com.nie.nieapp.dragger2.presenter.DraggerDemoPresenter;
import com.nie.nieapp.nbase.NActivity;

/**
 * Created by Administrator on 2017/12/30.
 */

public class DraggerActivity extends NActivity<DraggerDemoPresenter,ActivityDraggerBinding> implements DraggerDemoContract.View {
    @Override
    public void method() {

    }

    @Override
    protected int getContentId() {
        return R.layout.activity_dragger;
    }
}
