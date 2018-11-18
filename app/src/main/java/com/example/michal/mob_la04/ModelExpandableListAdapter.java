package com.example.michal.mob_la04;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.michal.mob_la04.Models.Model;

import java.util.HashMap;
import java.util.List;

public class ModelExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<Model> expandableListTitle;
    private HashMap<Model, List<Model>> expandableListDetail;

    public ModelExpandableListAdapter(Context context, List<Model> expandableListTitle,
                                      HashMap<Model, List<Model>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }


    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {

        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded, View view, ViewGroup viewGroup) {

        String listTitle = (String) getGroup(listPosition).toString();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_group, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.parent_text_view);
        textView.setText(listTitle);

        return view;
    }

    @Override
    public View getChildView(int listPosition, int expandedListPosition,
                             boolean isLastChild, View view, ViewGroup viewGroup) {

        final String expandedListText = (String) getChild(listPosition, expandedListPosition).toString();
        if(view == null){
            LayoutInflater inflater = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_child, null);

        }

        TextView textView = (TextView) view.findViewById(R.id.child_text_view);
        textView.setText(expandedListText);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
