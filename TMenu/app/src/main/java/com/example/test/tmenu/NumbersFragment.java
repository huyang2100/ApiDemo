package com.example.test.tmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */
public class NumbersFragment extends ListFragment {

    private ArrayList<String> numbers;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        numbers = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            numbers.add("item: #" + i);
        }
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_activated_1, numbers));
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        getListView().setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked) {
                int checkedItemCount = getListView().getCheckedItemCount();
                if(checkedItemCount == 0){
                    mode.setSubtitle(null);
                }else{
                    mode.setSubtitle(checkedItemCount+" items selected");
                }
            }

            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.menu_context, menu);
                mode.setTitle("Select items");
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_add:
                        Toast.makeText(getActivity(), "add", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                    case R.id.menu_delete:
                        Toast.makeText(getActivity(), "delete", Toast.LENGTH_SHORT).show();
                        mode.finish();
                        return true;
                }
                return false;
            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });

    }
}
