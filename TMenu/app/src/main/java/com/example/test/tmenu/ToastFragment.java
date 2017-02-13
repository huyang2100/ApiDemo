package com.example.test.tmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */
public class ToastFragment extends Fragment implements View.OnClickListener {

    private Toast toastCus;
    private Toast toast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_toast, container, false);
        v.findViewById(R.id.btn_position).setOnClickListener(this);
        v.findViewById(R.id.btn_custom).setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_position:
                if(toast == null){
                    toast = Toast.makeText(getActivity(), "Hello Toast", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL,0,0);
                }
                toast.show();
                break;
            case R.id.btn_custom:
                if(toastCus == null){
                    toastCus = new Toast(getActivity());
                    toastCus.setGravity(Gravity.CENTER,0,0);
                    toastCus.setView(View.inflate(getActivity(),R.layout.toast_cus,null));
                    toastCus.setDuration(Toast.LENGTH_LONG);
                }
                toastCus.show();
                break;
        }
    }
}
