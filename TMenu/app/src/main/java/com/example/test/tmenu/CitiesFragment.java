package com.example.test.tmenu;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */

public class CitiesFragment extends ListFragment {

    private String[] cities;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        cities = new String[]{
                "Shanghai",
                "Beijing",
                "Guangzhou",
                "Shenzhen",
                "Dalian",
                "Qingdao",
                "Taiyuan",
                "Yuncheng",
                "Yongji",
                "Chongqing",
                "Chengdu"
        };

        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, cities));
     }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getActivity().getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                Toast.makeText(getActivity(),"add",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.menu_delete:
                Toast.makeText(getActivity(),"delete",Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getActivity(),cities[position],Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        registerForContextMenu(getListView());
    }

    @Override
    public void onStop() {
        super.onStop();
        unregisterForContextMenu(getListView());
    }
}
