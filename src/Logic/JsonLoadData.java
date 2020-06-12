package Logic;


import Data.User;
import Data.DataStructures.Array.DynamicArray;
import Data.DataStructures.LinkedList;
import Data.Estacion;
import Data.Ruta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;

import java.io.FileReader;
import java.util.HashMap;

public class JsonLoadData {
    
     static void loadDataNecesary() {
        System.out.println("Cargando Datos Necesarios...");
        long timeCargaUsuarios = loadDataUser(DataManipulation.listaUsuariosHM,10000);
        long timeCargaRutas = loadDataRutas(DataManipulation.listaRutasHM);
        long timeCargaEstaciones = loadDataEstaciones(DataManipulation.listaEstacionesHM);
                   
        System.out.println("Datos cargados con Exito.\n");
        
         System.out.println("El tiempo de carga de las estructuras fue: \n");
         System.out.println("Usuarios HashMap: " + timeCargaUsuarios);
         System.out.println("Rutas HashMap: " + timeCargaRutas);
         System.out.println("Estaciones HashMap: " + timeCargaEstaciones + ""+ "\n");
         
    }

    static void loadDataSpecify() {
        
    }


    public static long loadDataUser (DynamicArray<User> userDynamicArray, int dataSize){

        long initLoadData = System.nanoTime ();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("C:\\Users\\Ruben\\Documents\\NetBeansProjects\\MoviliApp\\Data\\User\\%d.json",dataSize)));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String nombre= jsonObject.get ("nombre").toString ();
                String apellido= jsonObject.get ("apellido").toString ();
                String email= jsonObject.get ("email").toString ();
                String password= jsonObject.get ("password").toString ();
                String telephone= jsonObject.get ("telephone").toString ();
                String cedula= jsonObject.get ("cedula").toString ();
                String anionac = jsonObject.get ("anionac").toString ();

                userDynamicArray.push (new User (nombre,apellido,email,password,telephone,cedula,anionac));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();

        return finishLoadData - initLoadData;
    }

    public static long loadDataUser (LinkedList<User> userLinkedList, int dataSize){
        long initLoadData = System.nanoTime ();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("C:\\Users\\Ruben\\Documents\\NetBeansProjects\\MoviliApp\\Data\\User\\%d.json",dataSize)));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String nombre= jsonObject.get ("nombre").toString ();
                String apellido= jsonObject.get ("apellido").toString ();
                String email= jsonObject.get ("email").toString ();
                String password= jsonObject.get ("password").toString ();
                String telephone= jsonObject.get ("telephone").toString ();
                String cedula= jsonObject.get ("cedula").toString ();
                String anionac = jsonObject.get ("anionac").toString ();

                userLinkedList.pushBack (new User (nombre,apellido,email,password,telephone,cedula,anionac));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }
    
    public static long loadDataUser (HashMap<String,User> userHashMap, int dataSize){
        long initLoadData = System.nanoTime ();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("C:\\Users\\Ruben\\Documents\\NetBeansProjects\\MoviliApp\\Data\\User\\%d.json",dataSize)));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String nombre= jsonObject.get ("nombre").toString ();
                String apellido= jsonObject.get ("apellido").toString ();
                String email= jsonObject.get ("email").toString ();
                String password= jsonObject.get ("password").toString ();
                String telephone= jsonObject.get ("telephone").toString ();
                String cedula= jsonObject.get ("cedula").toString ();
                String anionac = jsonObject.get ("anionac").toString ();

                userHashMap.put(cedula,new User(nombre,apellido,email,password,telephone,cedula));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }
    
    public static long loadDataRutas (HashMap<String,Ruta> userHashMap){
        long initLoadData = System.nanoTime ();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("C:\\Users\\Ruben\\Documents\\NetBeansProjects\\MoviliApp\\Data\\Rutas\\RutasTM.json")));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String Nombre= jsonObject.get ("Nombre").toString ();
                String Origen = jsonObject.get("Origen").toString();
                String Destino = jsonObject.get("Destino").toString();

                userHashMap.put(Nombre,new Ruta(Nombre,Origen,Destino));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }
    

    private static long loadDataEstaciones(HashMap<String, Estacion> listaEstacionesHM) {
       long initLoadData = System.nanoTime ();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("C:\\Users\\Ruben\\Documents\\NetBeansProjects\\MoviliApp\\Data\\Estaciones\\EstacionesTM.json")));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String Nombre= jsonObject.get ("Nombre").toString ();
                int NVagones = Integer.parseInt(jsonObject.get("NVagones").toString());
                int NEntradas  = Integer.parseInt(jsonObject.get("NEntradas").toString());
                float Latitude =  Float.parseFloat(jsonObject.get("Latitud").toString());
                float Longitude = Float.parseFloat(jsonObject.get("Longitud").toString());

                DataManipulation.listaEstacionesHM.put(Nombre,new Estacion(Nombre, NVagones,NEntradas, initLoadData, initLoadData));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }

    
}
