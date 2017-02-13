package com.example.test.tmenu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */
public class ListDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String[] colors = {
                "Orange",
                "Red",
                "Blue",
                "Yellow"
        } ;
//        builder.setItems(colors, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getActivity(),colors[which],Toast.LENGTH_SHORT).show();
//            }
//        });
        builder.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, colors), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(),colors[which],Toast.LENGTH_SHORT).show();
            }
        });
        return builder.create();
    }
}
