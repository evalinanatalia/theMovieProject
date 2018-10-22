package com.example.bri.themoviesproject.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.bri.themoviesproject.OnCallback;
import com.example.bri.themoviesproject.R;

import javax.security.auth.callback.Callback;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by BRI on 10/10/2018.
 */

public class DialogFilter implements RadioGroup.OnCheckedChangeListener{

    Context context;
    Dialog mDialog;
    private OnCallback callback;

    @BindView(R.id.sorting_group)
    RadioGroup sortingOptionsGroup;

    public DialogFilter(Context context) {

        this.context = context;
    }

    public void callback(OnCallback callback){
        this.callback = callback;
    }

    public void initView() {

        if (mDialog == null) {
            mDialog = new Dialog(context, R.style.CustomDialogTheme);
        }
        mDialog.setContentView(R.layout.sorting_options);
        mDialog.setCancelable(true);
        mDialog.show();
        ButterKnife.bind(this, mDialog);
        sortingOptionsGroup.setOnCheckedChangeListener(this);

//        setContentView(R.layout.sorting_options);
//        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i)
        {
            case R.id.most_popular:
                mDialog.dismiss();
                callback.setOnCallback("1");
                break;

            case R.id.highest_rated:
                mDialog.dismiss();
                callback.setOnCallback("2");
                break;

            case R.id.favorites:
                mDialog.dismiss();
                callback.setOnCallback("3");
                break;
            case R.id.newest:
                mDialog.dismiss();
                callback.setOnCallback("4");
                break;
        }
    }
}
