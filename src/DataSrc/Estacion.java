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
    
    double latitude;
    double longitude;
    
    DynamicArray<Ruta> listaRutas;

    public Estacion(String Nombre) {
        this.Nombre = Nombre;
        this.listaRutas = new DynamicArray<>(10);
    }
    
     public Estacion(String Nombre, int Nvagones, int NEntradas, double latitude, double longitude) {
        this.Nombre = Nombre;
        this.Nvagones = Nvagones;
        this.NEntradas = NEntradas;
        this.NUsuarios = 0;
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
        this.listaRutas = new DynamicArray<>(10);
    }

    public Estacion(int NUsuarios) {
        this.NUsuarios = NUsuarios;
        this.listaRutas = new DynamicArray<>(10);
    }

    public int getNvagones() {
        return Nvagones;
    }

    public void setNvagones(int Nvagones) {
        this.Nvagones = Nvagones;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    


    public DynamicArray<Ruta> getListaRutas() {
        return listaRutas;
    }
    
    public String listaRutas(){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < listaRutas.getSize();i++){
            
            if(i%1 == 0 && i != 0){
                builder.append(listaRutas.get(i).getNombre()).append(" <br>");
            }
            builder.append(listaRutas.get(i).getNombre()).append("     ");
        }
        
        return builder.toString();
    }

    public void setListaRutas(DynamicArray<Ruta> listaRutas) {
        this.listaRutas = listaRutas;
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
    
    @Override
    public int hashCode(){
        return this.Nombre.hashCode();
    }
    
}
