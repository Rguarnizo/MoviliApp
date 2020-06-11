package Logic;


import Data.User;
import Data.DataStructures.Array.DynamicArray;
import Data.DataStructures.LinkedList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.HashMap;

public class JsonLoadData {


    public static long loadDataUser (DynamicArray<User> userDynamicArray, int dataSize){

        long initLoadData = System.nanoTime ();
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("Data\\%d.json",dataSize)));
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
            Object obj = parser.parse (new FileReader (String.format ("Data\\%d.json",dataSize)));
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
            Object obj = parser.parse (new FileReader (String.format ("C:\\Users\\Ruben\\Documents\\NetBeansProjects\\MoviliApp\\Data\\%d.json",dataSize)));
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

    static void loadDataNecesary() {
        System.out.println("Cargando Datos Necesarios...");
        loadDataUser(DataManipulation.listaUsuariosHM,10000);
        System.out.println("Datos cargados con Exito.");
    }

    static void loadDataSpecify() {
        
    }

    
}
