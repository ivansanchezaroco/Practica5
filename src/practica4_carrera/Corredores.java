/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_carrera;

import java.io.Serializable;

/**
 *
 * @author dam12
 */
public class Corredores implements Serializable {
    private String nombre;
    private int dorsal;
    private String categoria;
    private String edad;
    private String tiempo;
    
    public Corredores(){
    }
    
    Corredores(String nombre, int dorsal, String Categoria, String edad, String tiempo){
    this.nombre = nombre;
    this.dorsal = dorsal;
    this.categoria = categoria;
    this.edad = edad;
    this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return "Corredores{" + "nombre=" + nombre + ", dorsal=" + dorsal + ", categoria=" + categoria + ", edad=" + edad + ", tiempo=" + tiempo + '}';
    }
    
}
