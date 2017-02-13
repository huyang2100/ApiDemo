package com.example.test.tmenu;

import android.app.Fragment;
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

public class HomeFragment extends Fragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_home, container, false);
        v.findViewById(R.id.btn_menu).setOnClickListener(this);
        v.findViewById(R.id.btn_dialog).setOnClickListener(this);
        v.findViewById(R.id.btn_toast).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_menu:
                getFragmentManager().beginTransaction().replace(R.id.frag_content,new MenuFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_dialog:
                getFragmentManager().beginTransaction().replace(R.id.frag_content,new DialogsFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_toast:
                getFragmentManager().beginTransaction().replace(R.id.frag_content,new ToastFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
