package com.example.michal.mob_la04;

import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.michal.mob_la04.DataMapper.DataMapper;
import com.example.michal.mob_la04.DataMapper.StudentMapper;
import com.example.michal.mob_la04.Dialogs.OptionDialog;
import com.example.michal.mob_la04.Dialogs.StudentDialog;
import com.example.michal.mob_la04.Factories.Factory;
import com.example.michal.mob_la04.Factories.StudentFactory;
import com.example.michal.mob_la04.ModelLists.ModelList;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Project;
import com.example.michal.mob_la04.Models.Student;
import com.example.michal.mob_la04.OpenHelpers.FullOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DataMapper studentMapper;
    Factory studentFactory;
    SQLiteOpenHelper openHelper;
//    final StudentDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new FullOpenHelper(getApplicationContext());
        studentFactory = new StudentFactory();
        studentMapper = new StudentMapper(openHelper, studentFactory);

        ModelList<Student> students = studentMapper.selectAll();

        onCreateButtons();
        onCreateExpentableList(students);

    }

    public void onCreateButtons(){
        final StudentDialog dialog  = new StudentDialog(MainActivity.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button subBtn = dialog.findViewById(R.id.sub_stud_btn);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = dialog.getName();
                String surname = dialog.getSurname();
                studentMapper.insert(new Student(0, name, surname, null));
                dialog.hide();
            }
        });

        Button addBtn = (Button) findViewById(R.id.btn_add_stud);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

        Button goBtn = (Button) findViewById(R.id.btn_pro);
        goBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ProjectActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onCreateExpentableList(ModelList<Student> studentList) {


        ExpandableListView expandableListView = findViewById(R.id.expanded_list);
        HashMap<Model, List<Model>>  expandableListDetail = getData(studentList);
        final List<Model> expandableListTitle = new ArrayList<Model>(expandableListDetail.keySet());
        ExpandableListAdapter expandableListAdapter = new ModelExpandableListAdapter(getApplicationContext(),
                expandableListTitle, expandableListDetail);


        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                final OptionDialog dialog  = new OptionDialog(MainActivity.this);
//                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Button deleteBtn = dialog.getDeleteButton();
                Button updateBtn = dialog.getUpdateButton();

                final Student s = (Student) expandableListTitle.get(i);

                deleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(studentMapper.delete(s)){
                            Toast.makeText(MainActivity.this, "Usunieto", Toast.LENGTH_SHORT).show();
                        }
                        dialog.hide();
                    }
                });

                updateBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final StudentDialog studentDialog  = new StudentDialog(MainActivity.this);
//                        studentDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        Button subBtn = studentDialog.findViewById(R.id.sub_stud_btn);
                        studentDialog.setName(s.getName());
                        studentDialog.setSurname(s.getSurname());

                        subBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String name = studentDialog.getName();
                                String surname = studentDialog.getSurname();
                                if(studentMapper.update(new Student(s.getId(), name, surname, null))){
                                    Toast.makeText(MainActivity.this, "Zaktualizowano", Toast.LENGTH_SHORT).show();
                                }
                                studentDialog.hide();
                            }
                        });
                        studentDialog.show();
                        dialog.hide();
                    }
                });
                dialog.show();

                return false;
            }
        });

    }

    public static HashMap<Model, List<Model>> getData(ModelList<Student> studentList) {

        HashMap<Model, List<Model>> expandableListDetail = new HashMap<Model, List<Model>>();

        for(Student s: studentList.getModels()){
            List<Model> list = new ArrayList<>();
            list.add(new Project(0, "pr1", null));
            list.add(new Project(1, "pr2", null));
            expandableListDetail.put(s, list);
        }

        return expandableListDetail;
    }


}
