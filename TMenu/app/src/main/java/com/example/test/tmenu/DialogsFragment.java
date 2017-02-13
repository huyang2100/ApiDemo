package com.example.test.tmenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */
public class DialogsFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_dialog, container, false);
        v.findViewById(R.id.btn_btn).setOnClickListener(this);
        v.findViewById(R.id.btn_list).setOnClickListener(this);
        v.findViewById(R.id.btn_muli).setOnClickListener(this);
        v.findViewById(R.id.btn_custom).setOnClickListener(this);
        v.findViewById(R.id.btn_fs).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_btn:
                new ButtonDialogFragment().show(getFragmentManager(), "btn");
                break;
            case R.id.btn_list:
                new ListDialogFragment().show(getFragmentManager(), "list");
                break;
            case R.id.btn_muli:
                new MuliDialogFragment().show(getFragmentManager(), "muli");
                break;
            case R.id.btn_custom:
                new CustomDialogFragment().show(getFragmentManager(), "custom");
                break;
            case R.id.btn_fs:
//                new FullScreenDialogFragment().show(getFragmentManager(),"full");
                getFragmentManager()
                        .beginTransaction()
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .add(R.id.frag_content, new FullScreenDialogFragment())
                        .addToBackStack(null).commit();
                break;
        }
    }
}
