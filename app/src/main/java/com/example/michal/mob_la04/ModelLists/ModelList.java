package com.example.michal.mob_la04.ModelLists;

import com.example.michal.mob_la04.MainActivity;
import com.example.michal.mob_la04.Models.Model;
import com.example.michal.mob_la04.Models.Project;

import java.util.ArrayList;

public class ModelList<E> {

    protected ArrayList<String> modelStringList = new ArrayList<>();
    protected ArrayList<E> models;

    public ModelList(ArrayList<E> models){
        this.models = models;
        for(E m : models){
            modelStringList.add(m.toString());
        }
    }

    public ArrayList<String> getModelStringList(){
        return modelStringList;
    }

    public ArrayList<E> getModels() {
        return models;
    }
}
