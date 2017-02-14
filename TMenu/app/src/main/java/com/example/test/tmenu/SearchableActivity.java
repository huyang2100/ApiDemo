package com.example.test.tmenu;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */

public class SearchableActivity extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0; i < 45; i++) {
            datas.add("item: #" + i);
        }
        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datas));
    }
}
