/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DataSrc.Estacion;
import Logic.DataManipulation;
import com.teamdev.jxmaps.swing.MapView;
import com.teamdev.jxmaps.*;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Rubén Darío Martínez
 */
public class Maps extends MapView{
    
    private Map map;
    
    public Maps(String nName){
        JFrame jFrame = new JFrame(nName);
        
        setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus ms) {
                if(ms == MapStatus.MAP_STATUS_OK){
                    map = getMap();
                    MapOptions mapOptions = new MapOptions();
                    MapTypeControlOptions mapOptionsT = new MapTypeControlOptions();
                    mapOptions.setMapTypeControlOptions(mapOptionsT);
                    
                    map.setOptions(mapOptions);
                    map.setCenter(new LatLng(4.60971, -74.08175));
                    map.setZoom(10.0);
                    
                    for(Estacion estacion: DataManipulation.listaEstacionesHM.values()){
                         Marker mark = new Marker(map);
                         mark.setPosition(new LatLng(estacion.getLatitude(),estacion.getLongitude()));
                         Icon icon = new Icon();
                         icon.loadFromFile("src\\src_images\\TMLogo.png");
                         icon.setScaledSize(new Size(30,30));
                         mark.setIcon(icon);
                         mark.setTitle(estacion.getNombre());
                    }
                    
                   
                    
                    
                }
            }
        });
               jFrame.add(this,BorderLayout.CENTER);
               jFrame.setSize(700,500);
               jFrame.setVisible(true);
    }
    
    public static void main(String[] args){
        Maps map = new Maps("VentanaPrueba");
    }
}
