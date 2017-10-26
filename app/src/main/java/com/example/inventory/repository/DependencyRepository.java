package com.example.inventory.repository;

import android.widget.ArrayAdapter;

import com.example.inventory.pojo.Dependency;

import java.util.ArrayList;


/**
 * Created by usuario on 26/10/17.
 */

public class DependencyRepository {

    /* Declaración*/
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /* Inicialización
    /* Inicializa todos los atributos de ámbito static o de clase */
     static {
        dependencyRepository = new DependencyRepository();
    }

    /**
     * El constructor ha de ser privado para garantizar que hay una sola instancia de Repository
     */
    private DependencyRepository(){
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /* Métodos */
    public void initialize(){
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior", "1CFGS",
                "1CFGS Desarrollo Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior", "2CFGS",
                "2CFGS Desarrollo Aplicaciones Multiplataforma"));
    }

    /* Patrón Singleton*/
    public static DependencyRepository getInstance(){
        if(dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }


    /**
     * Método que añade una dependencia
     * @param dependency
     */
    public void addDependency(Dependency dependency){
        dependencies.add(dependency);
    }

    public ArrayList<Dependency> getDependencies(){
        return dependencies;
    }

}
