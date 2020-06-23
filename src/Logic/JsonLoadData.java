package Logic;


import DataSrc.User;
import DataSrc.DataStructures.Array.DynamicArray;
import DataSrc.DataStructures.LinkedList;
import DataSrc.DataStructures.Trees.AVLTree;
import DataSrc.DataStructures.Trees.PriorityQueueEstaciones;
import DataSrc.DataStructures.Trees.RutasPriorityQueue;
import DataSrc.Estacion;
import DataSrc.Ruta;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;
import org.json.simple.JsonObject;

public class JsonLoadData {
    
     static void loadDataNecesary() {
        System.out.println("Cargando Datos Necesarios...");
        long timeCargaUsuarios = loadDataUser(DataManipulation.listaUsuariosHM,10000);
        long timeCargaRutas = loadDataRutas(DataManipulation.listaRutasHM,0);
        long timeCargaEstaciones = loadDataEstaciones(DataManipulation.listaEstacionesHM,0);
        System.out.println("Datos cargados con Exito.\n");
        
         System.out.println("El tiempo de carga de las estructuras fue: \n");
         System.out.println("Usuarios HashMap: " + timeCargaUsuarios/1000000 + " milliseg");
         System.out.println("Rutas HashMap: " + timeCargaRutas/1000000 + " milliseg");
         System.out.println("Estaciones HashMap: " + timeCargaEstaciones/1000000 + " milliseg" + "\n");
         
    }

  


    public static long loadDataUser (DynamicArray<User> userDynamicArray, int dataSize){

        long initLoadData =0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("Data\\User\\%d.json",dataSize)));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            initLoadData = System.nanoTime ();
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String nombre= jsonObject.get ("nombre").toString ();
                String apellido= jsonObject.get ("apellido").toString ();
                String email= jsonObject.get ("email").toString ();
                String password= jsonObject.get ("password").toString ();
                String telephone= jsonObject.get ("telephone").toString ();
                String cedula= jsonObject.get ("cedula").toString ();
                String anionac = jsonObject.get ("anionac").toString ();

                userDynamicArray.push (new User (nombre,apellido,email,password,telephone,cedula,anionac,false));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();

        return finishLoadData - initLoadData;
    }

    public static long loadDataUser (LinkedList<User> userLinkedList, int dataSize){
        long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("Data\\User\\%d.json",dataSize)));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            initLoadData = System.nanoTime ();
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String nombre= jsonObject.get ("nombre").toString ();
                String apellido= jsonObject.get ("apellido").toString ();
                String email= jsonObject.get ("email").toString ();
                String password= jsonObject.get ("password").toString ();
                String telephone= jsonObject.get ("telephone").toString ();
                String cedula= jsonObject.get ("cedula").toString ();
                String anionac = jsonObject.get ("anionac").toString ();

                userLinkedList.pushBack (new User (nombre,apellido,email,password,telephone,cedula,anionac,false));
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }
    
    public static long loadDataUser (HashMap<String,User> userHashMap, int dataSize){
        long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse (new FileReader (String.format ("Data\\User\\%d.json",dataSize)));
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            initLoadData = System.nanoTime ();
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
    
    public static long loadDataRutas (HashMap<String,Ruta> userHashMap,int dataSize){
        long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj;
            if(dataSize == 0){
                 obj = parser.parse (new FileReader (String.format ("Data\\Rutas\\RutasTM.json")));
            } else {
                 obj = parser.parse (new FileReader (String.format ("Data\\Rutas\\RutasTM%d.json",dataSize)));
            }
            JSONArray jsonArray = (JSONArray) obj;
            initLoadData = System.nanoTime (); 
            System.out.println (jsonArray.size ());
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String Nombre= jsonObject.get ("Nombre").toString ();
                String Origen = jsonObject.get("Origen").toString();
                String Destino = jsonObject.get("Destino").toString();

                
                Ruta ruta = new Ruta(Nombre,Origen,Destino);
                userHashMap.put(Nombre,ruta);
                DataManipulation.colaPrioridadRuta.insert(ruta);
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }
    

    public static long loadDataEstaciones(HashMap<String, Estacion> listaEstacionesHM,int dataSize) {
       long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj;
            if(dataSize == 0){
              obj  = parser.parse (new FileReader (String.format ("Data\\Estaciones\\EstacionesTM.json")));
            }else{
                obj  = parser.parse (new FileReader (String.format ("Data\\Estaciones\\EstacionesTM%d.json",dataSize)));
            }
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            initLoadData = System.nanoTime ();
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String Nombre= jsonObject.get ("Nombre").toString ();
                int NVagones = Integer.parseInt(jsonObject.get("NVagones").toString());
                int NEntradas  = Integer.parseInt(jsonObject.get("NEntradas").toString());
                float Latitude =  Float.parseFloat(jsonObject.get("Latitud").toString());
                float Longitude = Float.parseFloat(jsonObject.get("Longitud").toString());
                
                Estacion estacion = new Estacion(Nombre, NVagones,NEntradas, initLoadData, initLoadData);
                listaEstacionesHM.put(Nombre,estacion);
                DataManipulation.colaPrioridadEstaciones.insert(estacion);
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
    }
    
      static void loadDataSpecify() {
        boolean exec = true;
        
        while (exec){

            System.out.println ("MoviliAPP");
            System.out.println ("ESTRUCTURAS A USAR. \n");
            System.out.println ("1.Lista Usuarios DynamicArray");
            System.out.println ("2.Lista Usuarios Linked List");
            System.out.println ("3.Lista Usuarios Hash Map \n");         
            System.out.println ("4.Lista Rutas AVL");           
            System.out.println ("5.Lista Rutas HashMap\n");
            System.out.println ("6.Lista Estaciones AVL");
            System.out.println ("7.Lista Estaciones HashMap\n");
            System.out.println ("8.Litsa Rutas con Estaciones\n ");
            System.out.println("9. SALIR\n");

            int option = 0;
            Scanner scanner = new Scanner(System.in);
            try{
                option = scanner.nextInt ();
                scanner.nextLine ();
            }catch (Exception e){
                System.out.println ("Verifique que su entrada este en las opciones");
            }
            
            System.out.println("Indique la cantidad de los datos a almacenar:");
            int cantidadDatos = scanner.nextInt();

            switch (option) {
                case 1: System.out.println("Tiempo Carga Usuarios DynamicArray: "+ loadDataUser(DataManipulation.listaUsuariosDA, cantidadDatos)/1000000 +" milliseg");
                    break;
                case 2: System.out.println("Tiempo Carga Usuarios LinkedList: "+ loadDataUser(DataManipulation.listaUsuariosLK, cantidadDatos)/1000000 +" milliseg");
                    break;
                case 3: System.out.println("Tiempo Carga Usuarios HashMap: " +loadDataUser(DataManipulation.listaUsuariosHM,cantidadDatos)/1000000 +" milliseg");
                    break;
                case 4: System.out.println("Tiempo Carga Rutas AVLTree: " + loadDataRutas(DataManipulation.listaRutasAVL,cantidadDatos)/1000000 +" milliseg");             
                    break;
                case 5: System.out.println("Tiempo Carga Rutas HashMap: " + loadDataRutas(DataManipulation.listaRutasHM,cantidadDatos)/1000000 +" milliseg");
                    break;
                case 6: System.out.println("Tiempo Carga Estaciones AVLTree: " +loadDataEstaciones(DataManipulation.listaEstacionesAVL,cantidadDatos)/1000000 +" milliseg");
                    break;
                case 7: System.out.println("Tiempo Carga Estaciones HashMap: " + loadDataEstaciones(DataManipulation.listaEstacionesHM,cantidadDatos)/1000000 +" milliseg");
                    break;                 
                case 8: System.out.println("Tiempo Carga Estaciones HashMap: " + loadDataAll(cantidadDatos)/1000000 +" milliseg");
                    break;
                case 9: exec =  false;   
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;
            }
        }
    }

      public static long loadDataRutas(AVLTree<Ruta> listaRutasAVL,int dataSize){
         
          long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj;
            if(dataSize == 0){
                 obj = parser.parse (new FileReader (String.format ("Data\\Rutas\\RutasTM.json")));
            } else {
                 obj = parser.parse (new FileReader (String.format ("Data\\Rutas\\RutasTM%d.json",dataSize)));
            }
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
             initLoadData = System.nanoTime ();
            for(int i = 0; i < jsonArray.size ();i++){
            
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String Nombre= jsonObject.get ("Nombre").toString ();
                String Origen = jsonObject.get("Origen").toString();
                String Destino = jsonObject.get("Destino").toString();
                 
                Ruta ruta = new Ruta(Nombre,Origen,Destino);
                listaRutasAVL.insert(ruta);
                DataManipulation.colaPrioridadRuta.insert(ruta);
               }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
      }
    
      public static long loadDataEstaciones(AVLTree<Estacion> listaEstacionesAVL,int dataSize){
          long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj;
            if(dataSize == 0){
              obj  = parser.parse (new FileReader (String.format ("Data\\Estaciones\\EstacionesTM.json")));
            }else{
                obj  = parser.parse (new FileReader (String.format ("Data\\Estaciones\\EstacionesTM%d.json",dataSize)));
            }
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            initLoadData = System.nanoTime ();
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                String Nombre= jsonObject.get ("Nombre").toString ();
                int NVagones = Integer.parseInt(jsonObject.get("NVagones").toString());
                int NEntradas  = Integer.parseInt(jsonObject.get("NEntradas").toString());
                float Latitude =  Float.parseFloat(jsonObject.get("Latitud").toString());
                float Longitude = Float.parseFloat(jsonObject.get("Longitud").toString());
                Estacion estacion = new Estacion(Nombre, NVagones,NEntradas,Latitude,Longitude);
                listaEstacionesAVL.insert(estacion);
                DataManipulation.colaPrioridadEstaciones.insert(estacion);
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
      }
      
      public static long loadDataAll(int dataSize){
          long initLoadData = 0;
        JSONParser parser = new JSONParser();
        try {
            Object obj;
            if(dataSize == 0){
              obj  = parser.parse (new FileReader (String.format ("Data\\JsonRutasListEsta.json")));
            }else{
                obj  = parser.parse (new FileReader (String.format ("Data\\JsonRutasListEsta%d.json",dataSize)));
            }
            JSONArray jsonArray = (JSONArray) obj;

            System.out.println (jsonArray.size ());
            initLoadData = System.nanoTime ();
            for(int i = 0; i < jsonArray.size ();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get (i);
                
                String Nombre= jsonObject.get ("Ruta").toString ();
                Ruta rutaPut = new Ruta(Nombre);
                
                JSONArray arrayEstacion = (JSONArray) jsonObject.get("ListaParadas");
                for(int j = 0;j<arrayEstacion.size();j++){
                    Estacion estacion = new Estacion(arrayEstacion.get(j).toString());
                    rutaPut.getParadas().add(estacion);                            
                }
                DataManipulation.listaRutasHM.put(Nombre,rutaPut);
                
                
            }
        }catch (Exception e){
            e.printStackTrace ();
        }
        long finishLoadData = System.nanoTime ();
        return finishLoadData-initLoadData;
      }

    
}
