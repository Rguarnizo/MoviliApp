/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataSrc;

import DataSrc.DataStructures.Array.DynamicArray;
import DataSrc.DataStructures.Node2B2;

/**
 *
 * @author Rubén Darío Martínez
 */
public class Ruta implements Comparable<Ruta> {
    
    String nombre;
    
    int numParadas;
    byte Linea;
    
    DynamicArray<Estacion> paradas;
    
    String origen;
    String destino;
    
    Node2B2 realTimeInfo;
    long latitude;
    long longitude;
  



    public Ruta(String nombre, int numParadas, byte Linea, DynamicArray<Estacion> paradas) {
        this.nombre = nombre;
        this.numParadas = numParadas;
        this.Linea = Linea;
        this.paradas = paradas;
        this.realTimeInfo = null;
    }
    
    public Ruta(String nombre, String origen, String destino) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.realTimeInfo = null;
    }

    public Ruta(String nombre) {
        this.nombre = nombre;
        this.realTimeInfo = null;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

   
    
    
    public Node2B2 getRealTimeInfo() {
        return realTimeInfo;
    }

    public void setRealTimeInfo(Node2B2 realTimeInfo) {
        this.realTimeInfo = realTimeInfo;
    }

    public String getNombre() {
        return nombre;       
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumParadas() {
        return numParadas;
    }

    public void setNumParadas(int numParadas) {
        this.numParadas = numParadas;
    }

    public byte getLinea() {
        return Linea;
    }

    public void setLinea(byte Linea) {
        this.Linea = Linea;
    }

    public DynamicArray<Estacion> getParadas() {
        return paradas;
    }

    public void setParadas(DynamicArray<Estacion> paradas) {
        this.paradas = paradas;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    
    public boolean equals(Ruta obj) {
        return (this.nombre == null ? obj.nombre == null : this.nombre.equals(obj.nombre));
    }



    @Override
    public int compareTo(Ruta o) {
        if(this.nombre.compareTo(o.nombre) == 0){
            return 0;
        }else if(this.nombre.compareTo(o.nombre) > 0){
        return 1;
        }else{
            return -1;
        }
    }
    
   
    
    
    
    
}
