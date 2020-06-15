/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import DataSrc.DataStructures.Array.DynamicArray;
import DataSrc.DataStructures.LinkedList;
import DataSrc.DataStructures.Trees.AVLTree;
import DataSrc.Ruta;
import DataSrc.User;
import java.util.HashMap;
import java.util.Scanner;
import DataSrc.DataStructures.DoublyLinkedList;
import DataSrc.Estacion;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Rubén Darío Martínez
 */
public class DataManipulation extends Thread {
    
    public static Scanner scanner = new Scanner(System.in);
    
    public static LinkedList<User> listaUsuariosLK;
    public static HashMap<String,User> listaUsuariosHM;
    public static DynamicArray<User> listaUsuariosDA;
    public static HashMap<String,Ruta> listaRutasHM;
    public static AVLTree<Ruta> listaRutasAVL;
    public static HashMap<String,Estacion> listaEstacionesHM;
    public static AVLTree<Estacion> listaEstacionesAVL;
    public static HashMap<String,DoublyLinkedList<Ruta>> realTimeInfo;  

    private static void ImprimirTodas() {
         System.out.println("LISTA USUARIOS DYNAMIC ARRAY\n");
                    if(listaUsuariosDA == null){
                        System.out.println("La estructura no ha sido creada...");
                    } else{
                        for(int i = 0; i < listaUsuariosDA.getSize();i++){
                            System.out.println(listaUsuariosDA.get(i));
                        }
                    }                    
                    System.out.println("LISTA USUARIOS LINKED LIST\n");
                    
                
                    if(listaUsuariosLK == null){
                        System.out.println("La estructura no ha sido creada...");
                    } else{
                        for(User user: listaUsuariosLK){
                            System.out.println(user);
                        }
                    }                   
                System.out.println("LISTA USUARIOS HASHMAP (NO IMPLEMENTADO) \n");
                System.out.println("LISTA RUTAS AVLTREE \n");
                System.out.println(listaRutasAVL.toString());
                System.out.println("LISTA RUTAS HASHMAP (NO IMPLEMENTADO) \n");
                   
                System.out.println(listaEstacionesAVL.toString());                
                System.out.println("LISTA ESTACIONES HASHMAP (NO IMPLEMENTADO) \n");
                    
    }

    
            
    
    
    public DataManipulation(String msg){
        super(msg);
        this.listaUsuariosDA = new DynamicArray<>(10);
        this.listaUsuariosHM = new HashMap<>();
        this.listaUsuariosLK = new LinkedList<>();
        this.listaRutasAVL = new AVLTree<>();
        this.listaRutasHM = new HashMap<>();
        this.realTimeInfo = new HashMap<>();
        this.listaEstacionesHM = new HashMap<>();
        this.listaEstacionesAVL = new AVLTree<>();
    }
    
    
    public void run(){
        
        boolean exec = true;
        
        while (exec){

            System.out.println ("MoviliAPP");
            System.out.println ("Seleccione una opción para continuar:");
            System.out.println ("1.Cargar Datos Necesarios.");
            System.out.println ("2.Cargar Datos Especificos.");
            System.out.println ("3.Analizar Rendimientos.");         
            System.out.println ("4.Visualizar Datos.");
            System.out.println ("5.Limpiar Datos.");
            System.out.println ("6.Salir");

            int option = 0;

            try{
                option = scanner.nextInt ();
                scanner.nextLine ();
            }catch (Exception e){
                System.out.println ("Verifique que su entrada este en las opciones");
            }

            switch (option) {
                case 1: JsonLoadData.loadDataNecesary ();
                    break;
                case 2: JsonLoadData.loadDataSpecify();
                    break;
                case 3: analyzeData();
                    break;
                case 4: visualizateData ();
                    break;
                case 5: cleanData();
                    break;
                case 6: exec =  false;
                    break;    
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;
            }
        }
    }
   
    public  void analyzeData () {
        boolean analyzeData = true;
        while (analyzeData){
            System.out.println ("ANALISIS RENDIMIENTO");
            System.out.println ("Seleccione una opción para continuar:");
            System.out.println ("1.Lista Usuarios DynamicArray");
            System.out.println ("2.Lista Usuarios Linked List");
            System.out.println ("3.Lista Usuarios Hash Map \n");         
            System.out.println ("4.Lista Rutas AVL");
            System.out.println ("5.Lista Rutas HashMap\n");
            System.out.println ("6.Lista Estaciones AVL");
            System.out.println ("7.Lista Estaciones HashMap\n");
            System.out.println("8.Analisis de todas las estructuras.");
            System.out.println("9. SALIR\n");

            int option = 0;

            try {
                option = scanner.nextInt ();
                scanner.nextLine ();
            }catch (Exception e) {
                System.out.println ("Verifique que su entrada este en las opciones" + e);
            }
            switch (option) {
                case 1: AnalisisEstructuraUsuario(listaUsuariosDA);
                    break;
                case 2: AnalisisEstructuraUsuario(listaUsuariosLK);
                    break;
                case 3: AnalisisEstructuraUsuario(listaUsuariosHM);
                    break;
                case 4: AnalisisEstructuraRuta(listaRutasAVL);
                    break;
                case 5: AnalisisEstructuraRuta(listaRutasHM);
                    break;
                case 6: AnalisisEstructuraEstacion(listaEstacionesAVL);
                    break;
                case 7: AnalisisEstructuraEstacion(listaEstacionesHM);
                    break;
                case 8: AnalisisTotal();
                    break;
                case 9: analyzeData = false;
                    break;
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;
            }
        }
    }
    
 

    private void cleanData () {
        this.listaUsuariosDA = new DynamicArray<>(10);
        this.listaUsuariosHM = new HashMap<>();
        this.listaUsuariosLK = new LinkedList<>();
        this.listaRutasAVL = new AVLTree<>();
        this.listaRutasHM = new HashMap<>();
        this.realTimeInfo = new HashMap<>();
        this.listaEstacionesHM = new HashMap<>();
        this.listaEstacionesAVL = new AVLTree<>();
    }
    
    private static void visualizateData () {
        boolean analyzeData = true;
        while (analyzeData){
            System.out.println ("VISUALIZAR DATOS");
            System.out.println ("Seleccione una opción para continuar:");
            System.out.println ("1.Lista Usuarios DynamicArray");
            System.out.println ("2.Lista Usuarios Linked List");
            System.out.println ("3.Lista Usuarios Hash Map \n");         
            System.out.println ("4.Lista Rutas AVL");
            System.out.println ("5.Lista Rutas HashMap\n");
            System.out.println ("6.Lista Estaciones AVL");
            System.out.println ("7.Lista Estaciones HashMap\n");
            System.out.println("8.Imprimir Todas las estructuras\n");
            System.out.println("9. SALIR\n");

            int option = 0;

            try {
                option = scanner.nextInt ();
                scanner.nextLine ();
            }catch (Exception e) {
                System.out.println ("Verifique que su entrada este en las opciones" + e);
            }
            switch (option) {
                case 1: 
                    if(listaUsuariosDA == null){
                        System.out.println("La estructura no ha sido creada...");
                    } else{
                        for(int i = 0; i < listaUsuariosDA.getSize();i++){
                            System.out.println(listaUsuariosDA.get(i));
                        }
                    }                    
                    
                    break;
                case 2: 
                    if(listaUsuariosLK == null){
                        System.out.println("La estructura no ha sido creada...");
                    } else{
                        for(User user: listaUsuariosLK){
                            System.out.println(user);
                        }
                    }
                    break;
                case 3: metodoNoImplementado();                
                    break;
                case 4: System.out.println(listaRutasAVL.toString());
                    break;
                case 5: metodoNoImplementado();                
                    break;
                case 6: System.out.println(listaEstacionesAVL.toString());                
                    break;
                case 7: metodoNoImplementado();
                    break;
                case 8: ImprimirTodas(); 
                    break;
                case 9:    analyzeData = false;
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;
            }
        }
    }
    
 
    private void AnalisisEstructuraUsuario(DynamicArray<User> listaUsuariosDA) {
        
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            
            
            resultTimesAllData[i] = JsonLoadData.loadDataUser(listaUsuariosDA, dataSizes[i]);
            
            User usuarioPrueba = new User("Prueba", "Prueba", "Prueba","Prueba","Prueba","Prueba");
            long initTime = System.nanoTime();
            listaUsuariosDA.push(usuarioPrueba);
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            
            
            initTime = System.nanoTime();
            listaUsuariosDA.indexOf(usuarioPrueba);
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaUsuariosDA.indexOf(usuarioPrueba);
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            
            
            cleanData();
            
         
        }
           EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaUsuariosDynamicArray.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        
        
    }

    private void AnalisisEstructuraUsuario(LinkedList<User> listaUsuariosLK) {
        
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataUser(listaUsuariosLK, dataSizes[i]);
            
            User usuarioPrueba = new User("Prueba", "Prueba", "Prueba","Prueba","Prueba","Prueba");
            long initTime = System.nanoTime();
            listaUsuariosLK.pushBack(usuarioPrueba);
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaUsuariosLK.get(dataSizes[i]);
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaUsuariosLK.get(dataSizes[i]);
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            
            cleanData();
        }
        
        EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaUsuariosArrayList.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al procesar grandes cantidades de datos. \n" + e);
        }
        
        
    }

    private void AnalisisEstructuraUsuario(HashMap<String, User> listaUsuariosHM) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            
            resultTimesAllData[i] = JsonLoadData.loadDataUser(listaUsuariosHM, dataSizes[i]);
            
            User usuarioPrueba = new User("Prueba", "Prueba", "Prueba","Prueba","Prueba","Prueba");
            
            long initTime = System.nanoTime();
            listaUsuariosHM.put(usuarioPrueba.getCedula(), usuarioPrueba);
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaUsuariosHM.get("Prueba");
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaUsuariosHM.get("EstaClaveNoDeberiaDeEstar");
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            
                 
            cleanData();
        }
        EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaUsuariosHashMap.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
      
    }

    private void AnalisisEstructuraRuta(AVLTree<Ruta> listaRutasAVL) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataRutas(listaRutasAVL, dataSizes[i]);
            Ruta rutaPrueba = new Ruta("ZZZZZZZ","Prueba","Prueba");
            
            long initTime = System.nanoTime();
            listaRutasAVL.insert(rutaPrueba);
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaRutasAVL.find(rutaPrueba);
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaRutasAVL.toString();
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            
             
            cleanData();
        }
        EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaRutaAVLTree.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
    }

    private void AnalisisEstructuraRuta(HashMap<String, Ruta> listaRutasHM) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataRutas(listaRutasHM, dataSizes[i]);
            
            Ruta rutaPrueba = new Ruta("Prueba","Prueba","Prueba");
            
            long initTime = System.nanoTime();
            listaRutasHM.put("Prueba",rutaPrueba);
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaRutasHM.get("Prueba");
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaRutasHM.containsKey("NoDeberiaEstarEstaKey");
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            
            cleanData();
        }
        EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaRutaHashMap.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
    }

    private void AnalisisEstructuraEstacion(AVLTree<Estacion> listaEstacionesAVL) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataEstaciones(listaEstacionesAVL, dataSizes[i]);
            
            Estacion estacionPrueba = new Estacion("ZZZZZZZ", i, i, i, i);
            
            long initTime = System.nanoTime();
            listaEstacionesAVL.insert(estacionPrueba);
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime-initTime;
            
             initTime = System.nanoTime();
            listaEstacionesAVL.find(estacionPrueba);
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaEstacionesAVL.toString();
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            
             
            cleanData();
        }
        EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaEstacionesAVLTree.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
 
    }

    private void AnalisisEstructuraEstacion(HashMap<String, Estacion> listaEstacionesHM) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        long resultTimesFindData[] = new long[4];
        long resultTimesConsultAll[] = new long[4]; 
        
        
        //Inserción De Todos los datos!
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataEstaciones(listaEstacionesHM, dataSizes[i]);
            long initTime = System.nanoTime();
            listaEstacionesHM.put("Prueba",new Estacion("Prueba", i, i, 1, 1));
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            
            
            initTime = System.nanoTime();
            listaEstacionesHM.get("Prueba");
            finalTime = System.nanoTime();
            resultTimesFindData[i] = finalTime - initTime;
            
            initTime = System.nanoTime();
            listaEstacionesHM.containsKey("NoDeberiaEstarEstaKey");
            finalTime = System.nanoTime();
            resultTimesConsultAll[i] = finalTime - initTime;
            cleanData();
        }
        EscribirArchivoAnalisis(dataSizes, resultTimesAllData, resultTimesOneData, resultTimesFindData, resultTimesConsultAll, "ListaEstacionesHashMap.txt");
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }

    }
    
    
    private void EscribirArchivoAnalisis(int dataSizes[],long[] insertAll,long[] insertOne,long[] searchOne,long[] consultAll,String outFile){
        BufferedWriter bw = null;
        FileWriter fw = null;

    try {
        String data = "Hola stackoverflow.com...";
        File file = new File(outFile);
        // Si el archivo no existe, se crea!
        if (!file.exists()) {
            file.createNewFile();
        }
        // flag true, indica adjuntar información al archivo.
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        
        Date fecha = new Date();
        bw.write("Analisis Estructura   " + fecha + "\n \n" );
        
        for(int i= 0;i < insertAll.length;i++){           
            bw.write(String.format("Insertar %d Datos: " + insertAll[i]/1000000 + " milliSeg \n",dataSizes[i]));
            bw.write(String.format("Insertar un dato con %d datos insertados: " + insertOne[i] + " NanoSeg \n",dataSizes[i]));
            bw.write(String.format("Buscar un dato: " + searchOne[i]+ " NanoSeg \n",dataSizes[i]));
            bw.write(String.format("Consultar todos los datos: " + consultAll[i]/1000000 + " milliSeg \n \n",dataSizes[i]));
        }
       
        System.out.println("información agregada al archivo de texto! \n");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            //Cierra instancias de FileWriter y BufferedWriter
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }

    private static void metodoNoImplementado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void AnalisisTotal() {
                    AnalisisEstructuraUsuario(listaUsuariosDA);
                    AnalisisEstructuraUsuario(listaUsuariosLK);
                    AnalisisEstructuraUsuario(listaUsuariosHM);
                    AnalisisEstructuraRuta(listaRutasAVL);
                    AnalisisEstructuraRuta(listaRutasHM);
                    AnalisisEstructuraEstacion(listaEstacionesAVL);
                    AnalisisEstructuraEstacion(listaEstacionesHM);
    }

}
