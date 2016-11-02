package com.wbh.myjxksecret.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.wbh.myjxksecret.R;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */
public class ChoiceContoryAdatper extends BaseExpandableListAdapter {
    private List<String> groupArray;
    private List<List<String>> childArray;
    private Context context;

    public ChoiceContoryAdatper(List<String> groupArray, List<List<String>> childArray, Context context) {
        this.groupArray = groupArray;
        this.childArray = childArray;
        this.context = context;
    }


    @Override
    public int getGroupCount() {
        return groupArray.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childArray.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {

        return groupArray.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childArray.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        isExpanded=true;
        return getTextView(groupArray.get(groupPosition));
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        return getchildTextView(childArray.get(groupPosition).get(childPosition),childPosition);
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    public TextView getTextView(String str) {
        TextView view = new TextView(context);
        view.setText(str);
        view.setTextSize(20);
        view.setPadding(20,0,0,0);
        view.setBackgroundResource(R.color.colorLightGray);

        return view;
    }
    public TextView getchildTextView(String str,int childPosition) {
        TextView view = new TextView(context);
        view.setText(str);
        view.setTextSize(16);
        view.setPadding(40,0,0,0);
        view.setHeight(100);

        if (childPosition%5==1){
            view.setTextColor(Color.GREEN);
        }
        view.setGravity(View.SCROLL_AXIS_VERTICAL);


        return view;
    }

}
