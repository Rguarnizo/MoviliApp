/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSrc;

import DataSrc.DataStructures.Array.DynamicArray;

/**
 *
 * @author Rubén Darío Martínez
 */
public class Estacion implements Comparable<Estacion> {
    
    String Nombre;
    
    int Ntorniquetes;
    int Nvagones;

   
    int NTaquillas;
    int NEntradas;
    
    int NUsuarios;
    
    int Bolardos;
    
    String Zona;
    
    float latitude;
    float longitude;
    
    DynamicArray<Ruta> listaRutas;

    public Estacion(String Nombre) {
        this.Nombre = Nombre;
    }
    
     public Estacion(String Nombre, int Nvagones, int NEntradas, float latitude, float longitude) {
        this.Nombre = Nombre;
        this.Nvagones = Nvagones;
        this.NEntradas = NEntradas;
        this.latitude = latitude;
        this.longitude = longitude;
        this.listaRutas = new DynamicArray<>(10);
    }

    public Estacion(String Nombre, int Ntorniquetes, int NTaquillas, int NEntradas, int Bolardos, String Zona) {
        this.Nombre = Nombre;
        this.Ntorniquetes = Ntorniquetes;
        this.NTaquillas = NTaquillas;
        this.NEntradas = NEntradas;
        this.Bolardos = Bolardos;
        this.Zona = Zona;
    }

    public Estacion(int NUsuarios) {
        this.NUsuarios = NUsuarios;
    }
    
    

    public int getNUsuarios() {
        return NUsuarios;
    }

    public void setNUsuarios(int NUsuarios) {
        this.NUsuarios = NUsuarios;
    }
    
    

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNtorniquetes() {
        return Ntorniquetes;
    }

    public void setNtorniquetes(int Ntorniquetes) {
        this.Ntorniquetes = Ntorniquetes;
    }

    public int getNTaquillas() {
        return NTaquillas;
    }

    public void setNTaquillas(int NTaquillas) {
        this.NTaquillas = NTaquillas;
    }

    public int getNEntradas() {
        return NEntradas;
    }

    public void setNEntradas(int NEntradas) {
        this.NEntradas = NEntradas;
    }

    public int getBolardos() {
        return Bolardos;
    }

    public void setBolardos(int Bolardos) {
        this.Bolardos = Bolardos;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String Zona) {
        this.Zona = Zona;
    }

    @Override
    public String toString() {
        return this.Nombre; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Estacion o) {
        if(this.Nombre.compareTo(o.Nombre) == 0){
            return 0;
        }else if(this.Nombre.compareTo(o.Nombre) > 0){
        return 1;
        }else{
            return -1;
        }
    }

    public void aumentarPrioridad() {
        this.NUsuarios++;
    }
    
    
}
