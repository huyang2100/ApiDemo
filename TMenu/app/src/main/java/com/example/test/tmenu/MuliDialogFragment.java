package com.example.test.tmenu;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ${desc}
 * <p>
 * 作者：Yang on ${date} ${time}
 * 邮箱：huyang2100@163.com
 */
public class MuliDialogFragment extends DialogFragment {
    ArrayList<String> mSelectes = new ArrayList<String>();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String[] techs = {
                "Java",
                "Ios",
                "Android"
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Pick your toppings: ")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), Arrays.toString(mSelectes.toArray()), Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setMultiChoiceItems(techs, null, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        if (isChecked) {
                            mSelectes.add(techs[which]);
                        } else if (mSelectes.contains(techs[which])) {
                            mSelectes.remove(techs[which]);
                        }
                    }
                });
        return builder.create();
    }
}
