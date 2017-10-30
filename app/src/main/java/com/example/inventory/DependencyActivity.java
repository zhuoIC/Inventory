package com.example.inventory;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.example.inventory.adapter.DependencyAdapter;
import com.example.inventory.pojo.Dependency;
import com.example.inventory.repository.DependencyRepository;

import java.lang.reflect.Array;


// Cuando hereda de ListActivity del layout tiene que contener sí o sí un ListView con el id "@android:id/list"
public class DependencyActivity extends ListActivity {

    private ArrayAdapter<Dependency> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        // CASO 1: Adapter no personalizado
        //adapter = new ArrayAdapter<Dependency>(this, android.R.layout.simple_list_item_1,
        // DependencyRepository.getInstance().getSectors());
        // CASO 2: Adapter personalizado
        adapter = new DependencyAdapter(this);
        getListView().setAdapter(adapter);
    }
}
