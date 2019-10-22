package com.example.bilal488.expandablelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;

public class MainActivity extends AppCompatActivity {

    List<String> ChildList;
    Map<String, List<String>> ParentListItems;
    ExpandableListView expandablelistView;

    // Assign Parent list items here.
    List<String> ParentList = new ArrayList<String>();
    { ParentList.add("ANDROID");
        ParentList.add("PHP");
    }

    // Assign children list element using string array.
    String[] AndroidName = { "ANDROID STUDIO","ANDROID EXAMPLES","ANDROID TUTORIALS" };
    String[] PhpName = { "XAMPP","PHPMYADMIN","MYSQL" };
    String[] ByDefalutMessage = {"Items Loading"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParentListItems = new LinkedHashMap<String, List<String>>();

        for ( String HoldItem : ParentList) {
            if (HoldItem.equals("ANDROID")) {
                loadChild(AndroidName);
            } else if (HoldItem.equals("PHP"))
                loadChild(PhpName);

            else
                loadChild(ByDefalutMessage);

            ParentListItems.put(HoldItem, ChildList);
        }

        expandablelistView = (ExpandableListView) findViewById(R.id.expandableListView1);
        final ExpandableListAdapter expListAdapter = new ListAdapter(
                this, ParentList, ParentListItems);
        expandablelistView.setAdapter(expListAdapter);

        expandablelistView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub

                final String selected = (String) expListAdapter.getChild(
                        groupPosition, childPosition);

                // Switch case to open selected child element activity on child element selection.

                Intent intent;
                switch(selected){
                    case "ANDROID STUDIO":
                        intent = new Intent(MainActivity.this, Android_Activity.class);
                        startActivity(intent);
                        break;

                    case "ANDROID EXAMPLES":
                        intent = new Intent(MainActivity.this, ANDROID_EXAMPLES_Activity.class);
                        startActivity(intent);
                        break;

                    case "ANDROID TUTORIALS":
                        intent = new Intent(MainActivity.this, ANDROID_TUTORIALS_Activity.class);
                        startActivity(intent);
                        break;

                    case "XAMPP":
                        intent = new Intent(MainActivity.this, XAMPPActivity.class);
                        startActivity(intent);
                        break;

                    case "PHPMYADMIN":
                        intent = new Intent(MainActivity.this, PHPMYADMINActivity.class);
                        startActivity(intent);
                        break;

                    case "MYSQL":
                        intent = new Intent(MainActivity.this, MYSQLActivity.class);
                        startActivity(intent);
                        break;

                }

                return true;
            }
        });
    }

    private void loadChild(String[] ParentElementsName) {
        ChildList = new ArrayList<String>();
        for (String model : ParentElementsName)
            ChildList.add(model);
    }

}