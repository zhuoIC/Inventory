package com.example.inventory;

import android.content.Intent;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayout;
import android.view.View;
import android.widget.ImageView;

import com.example.inventory.R;

import java.util.ArrayList;
import java.util.Vector;

/**
 * Activity que muestra un panel de iconos
 * @author Nicolás Hernández Jiménez
 */

public class DashboardActivity extends AppCompatActivity {
    private GridLayout gridDashboard;
    private ClickListenerDashboard listenerDashboard = new ClickListenerDashboard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_support);
        gridDashboard = (GridLayout) findViewById(R.id.gridDashboard);

        // Definir un array de int, que contendrá el id de las imágenes Inventory, Product, Dependecias
        int[] images = {R.drawable.chair, R.drawable.closet, R.drawable.cpu, R.drawable.inventory,
                R.drawable.keyboard, R.drawable.monitor, R.drawable.mouse, R.drawable.printer,
                R.drawable.proyector, R.drawable.table, R.drawable.whiteboard};

        // No se define en Java/Android arrays de objetos. Se utiliza Vector o Colecciones.
        // ImageView[] imageViews = new ImageView[images.length];

        // No utilizamos la clase Vector porque no trabajamos con hilos y no se requiere sincronización.
        // Vector<ImageView> vectorImages = new Vector<ImageView>();
        // ArrayList debe ser parametrizado
/*        ArrayList arrayImageViews = new ArrayList();
        for (int   i = 0; i < images.length; i++) {
            arrayImageViews.add(new ImageView(this));
            if (arrayImageViews.get(i) instanceof ImageView){
                ((ImageView)arrayImageViews.get(i)).setImageResource(images[i]);
            }
        }*/
        // ArrayList<ImageView> arrayImageViews = new ArrayList<>();
        ImageView imageView;
        float width = getResources().getDimension(R.dimen.imgDashboradWidth);
        float height = getResources().getDimension(R.dimen.imgDashboradHeight);
        for (int   i = 0; i < images.length; i++) {
            imageView = new ImageView(this);
            imageView.setImageResource(images[i]);
            imageView.setId(images[3]);
            imageView.setOnClickListener(listenerDashboard);
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.width = (int) width;
            params.height = (int) height;
            imageView.setLayoutParams(params);
            params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL, 1f);
            gridDashboard.addView(imageView);
        }
    }

    class ClickListenerDashboard implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            Intent intent = null;
            switch (view.getId()){
                case R.drawable.inventory:
                    intent = new Intent(DashboardActivity.this, InventoryActivity.class);
                    break;
                /*case R.drawable.product:
                    intent = new Intent(DashboardActivity.this, ProductActivity.class);
                    break;*/
            }
            startActivity(intent);
        }
    }
}
