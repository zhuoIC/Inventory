package com.example.inventory;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.inventory.pojo.Dependency;

import java.lang.reflect.Array;

/**
 *
 */

// Cuando hereda de ListActivity del layout tiene que contener sí o sí un ListView con el id "@android:id/list"
public class DependencyActivity extends ListActivity {

    private ArrayAdapter<Dependency> dependencia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        dependencia = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
                ((InventoryApplication)getApplicationContext()).getDependencies());
        getListView().setAdapter(dependencia);
    }
}
