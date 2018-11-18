package com.example.michal.mob_la04.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;

import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.R;

public class OptionDialog extends Dialog {

    private Model model;


    public OptionDialog(@NonNull Context context) {
        super(context, R.style.AppTheme);

        this.setContentView(R.layout.option_dialog);
    }


    public Button getDeleteButton(){
        Button btn = (Button) findViewById(R.id.delete_btn);
        return btn;
    }

    public Button getUpdateButton(){
        Button btn = (Button) findViewById(R.id.update_btn);
        return btn;
    }

    public Button getJoinsButton(){
        Button btn = (Button) findViewById(R.id.joins_btn);
        return btn;
    }
}
