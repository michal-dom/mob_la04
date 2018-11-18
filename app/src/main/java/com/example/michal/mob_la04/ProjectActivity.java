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

import com.example.michal.mob_la04.DataMapper.DataMapper;
import com.example.michal.mob_la04.DataMapper.ProjectMapper;
import com.example.michal.mob_la04.DataMapper.StudentMapper;
import com.example.michal.mob_la04.Dialogs.ProjectDialog;
import com.example.michal.mob_la04.Dialogs.StudentDialog;
import com.example.michal.mob_la04.Factories.Factory;
import com.example.michal.mob_la04.Factories.ProjectFactory;
import com.example.michal.mob_la04.Factories.StudentFactory;
import com.example.michal.mob_la04.ModelLists.ModelList;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Project;
import com.example.michal.mob_la04.Models.Student;
import com.example.michal.mob_la04.OpenHelpers.FullOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProjectActivity extends AppCompatActivity {

    DataMapper projectMapper;
    Factory projectFactory;
    SQLiteOpenHelper openHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);

        openHelper = new FullOpenHelper(getApplicationContext());
        projectFactory = new ProjectFactory();
        projectMapper = new ProjectMapper(openHelper, projectFactory);


        ModelList<Project> projects = projectMapper.selectAll();

        onCreateButtons();
        onCreateExpentableList(projects);

    }

    public void onCreateButtons(){
        final ProjectDialog dialog  = new ProjectDialog(ProjectActivity.this);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Button subBtn = dialog.findViewById(R.id.button2);
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String proName = dialog.getProjectName();
                projectMapper.insert(new Project(0, proName, null));

                dialog.hide();
            }
        });

        Button addBtn = (Button) findViewById(R.id.add_proj);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });

    }

    public void onCreateExpentableList(ModelList<Project> projectList) {

        ExpandableListView expandableListView = findViewById(R.id.project_exp_list);
        HashMap<Model, List<Model>>  expandableListDetail = getData(projectList);
        List<Model> expandableListTitle = new ArrayList<Model>(expandableListDetail.keySet());
        ExpandableListAdapter expandableListAdapter = new ModelExpandableListAdapter(getApplicationContext(),
                expandableListTitle, expandableListDetail);


        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                return false;
            }
        });

    }


    public static HashMap<Model, List<Model>> getData(ModelList<Project> projectList) {

        HashMap<Model, List<Model>> expandableListDetail = new HashMap<Model, List<Model>>();

        for(Project p: projectList.getModels()){
            List<Model> list = new ArrayList<>();
            list.add(new Student(0, "Adam", "Adam", null));
            expandableListDetail.put(p, list);
        }

        return expandableListDetail;
    }



}
