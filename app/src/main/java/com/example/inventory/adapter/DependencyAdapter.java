package com.example.inventory.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.inventory.R;
import com.example.inventory.pojo.Dependency;
import com.example.inventory.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

/**
 * Created by usuario on 26/10/17.
 */

public class DependencyAdapter extends ArrayAdapter<Dependency>{

    public DependencyAdapter (@NonNull Context context){
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
    }

    // Devuelve un objeto View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;

        View view = convertView;

        if(view == null) {
            // 1. Obtener el servicio del sistema Layout Inflater en el contexto
            // LayoutInflater inflater = LayoutInflater.from(getContext());
            // LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 2. Inflar la vista. Crea en memoria el objeto View con todos los widget del xml: item_dependecy.xml
            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder = new DependencyHolder();

            // 3. Inicializar las variables a los objetos ya creados de los widget del xml. ¡¡CUIDADO View.findViewID!!
            dependencyHolder.icon = (MaterialLetterIcon) view.findViewById(R.id.materialLetterIcon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvName);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvShortName);
            view.setTag(dependencyHolder);
        }else{
            dependencyHolder = (DependencyHolder) view.getTag();
        }

        // 4. Mostrar los datos del ArrayList mediante position
        dependencyHolder.icon.setLetter(getItem(position).getShortname().substring(0,1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortName.setText(getItem(position).getShortname());
        return view;
    }

    class DependencyHolder{
        MaterialLetterIcon icon;
        TextView txvName;
        TextView txvShortName;
    }
}
