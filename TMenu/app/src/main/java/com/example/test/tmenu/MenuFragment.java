package com.example.test.tmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */

public class MenuFragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_menu, container, false);
        v.findViewById(R.id.btn_contextMenu).setOnClickListener(this);
        v.findViewById(R.id.btn_modeMenuLv).setOnClickListener(this);
        v.findViewById(R.id.btn_modeMenuSv).setOnClickListener(this);
        v.findViewById(R.id.btn_popMenu).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_contextMenu:
                getFragmentManager().beginTransaction().replace(R.id.frag_content, new CitiesFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_modeMenuLv:
                getFragmentManager().beginTransaction().replace(R.id.frag_content, new NumbersFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_modeMenuSv:
                getFragmentManager().beginTransaction().replace(R.id.frag_content, new SingleFragment()).addToBackStack(null).commit();
                break;
            case R.id.btn_popMenu:
                PopupMenu popupMenu = new PopupMenu(getActivity(), v);
                popupMenu.getMenuInflater().inflate(R.menu.menu_context, popupMenu.getMenu());
                popupMenu.show();
                break;
        }
    }
}
