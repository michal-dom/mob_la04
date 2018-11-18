package com.example.michal.mob_la04.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.example.michal.mob_la04.R;

public class ProjectDialog extends Dialog {

    private String projectName;


    public ProjectDialog(@NonNull Context context) {
        super(context, R.style.AppTheme);

        this.setContentView(R.layout.project_dialog);
    }

    public void setProjectName(String projectName){
        this.projectName = projectName;
        EditText et = (EditText) findViewById(R.id.project_edit);
        et.setText(projectName);
    }

    public Button getButton(){
        Button btn = (Button) findViewById(R.id.button2);
        return btn;
    }

    public String getProjectName() {
        EditText et = (EditText) findViewById(R.id.project_edit);
        this.projectName = et.getText().toString();
        return this.projectName;
    }


}
