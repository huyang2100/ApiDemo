package com.example.test.tmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */

public class SingleFragment extends Fragment {

    private ActionMode mActionMode;
    private ActionMode.Callback callback;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callback = new ActionMode.Callback() {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu_context,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_add:
                        Toast.makeText(getActivity(),"add",Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    case R.id.menu_delete:
                        Toast.makeText(getActivity(),"delete",Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {
                mActionMode = null;
            }
        };
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.frag_modesv, container, false);
        v.findViewById(R.id.tv).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(mActionMode!=null){
                    return false;
                }
                mActionMode = getActivity().startActionMode(callback);
                return true;
            }
        });
        return v;
    }
}
