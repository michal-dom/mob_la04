package com.example.michal.mob_la04.Dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.example.michal.mob_la04.R;

public class StudentDialog extends Dialog {

    private String name;
    private String surname;


    public StudentDialog(@NonNull Context context) {
        super(context, R.style.AppTheme);

        this.setContentView(R.layout.student_dialog);
    }

    public void setName(String name){
        this.name = name;
        EditText et = (EditText) findViewById(R.id.name_edit);
        et.setText(name);

    }

    public void setSurname(String surname){
        this.surname = surname;
        EditText et = (EditText) findViewById(R.id.surname_edit);
        et.setText(surname);
    }

    public Button getButton(){
        Button btn = (Button) findViewById(R.id.sub_stud_btn);
        return btn;
    }

    public String getName() {
        EditText et = (EditText) findViewById(R.id.name_edit);
        this.name = et.getText().toString();
        return this.name;
    }

    public String getSurname() {
        EditText et = (EditText) findViewById(R.id.surname_edit);
        this.surname = et.getText().toString();
        return surname;
    }
}
