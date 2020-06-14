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
            System.out.println("8. SALIR\n");

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
                case 8: analyzeData = false;
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
            System.out.println("8. SALIR\n");

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
                case 8: analyzeData = false;
                    break;
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
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataUser(listaUsuariosDA, dataSizes[i]);
            long initTime = System.nanoTime();
            listaUsuariosDA.push(new User());
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
        }        
        
    }

    private void AnalisisEstructuraUsuario(LinkedList<User> listaUsuariosLK) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataUser(listaUsuariosLK, dataSizes[i]);
            long initTime = System.nanoTime();
            listaUsuariosLK.pushBack(new User());
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
       for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
        }
        
    }

    private void AnalisisEstructuraUsuario(HashMap<String, User> listaUsuariosHM) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataUser(listaUsuariosHM, dataSizes[i]);
            long initTime = System.nanoTime();
            DataManipulation.listaUsuariosHM.put("Prueba",new User());
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
        }
    }

    private void AnalisisEstructuraRuta(AVLTree<Ruta> listaRutasAVL) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataRutas(listaRutasAVL, dataSizes[i]);
            long initTime = System.nanoTime();
            listaRutasAVL.insert(new Ruta("Prueba","Prueba","Prueba"));
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
            
        }
    }

    private void AnalisisEstructuraRuta(HashMap<String, Ruta> listaRutasHM) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataRutas(listaRutasHM, dataSizes[i]);
            
            long initTime = System.nanoTime();
            listaRutasHM.put("Prueba",new Ruta("Prueba","Prueba","Prueba"));
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
        }
    }

    private void AnalisisEstructuraEstacion(AVLTree<Estacion> listaEstacionesAVL) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataEstaciones(listaEstacionesAVL, dataSizes[i]);
            long initTime = System.nanoTime();
            listaEstacionesAVL.insert(new Estacion("Prueba", i, i, 1, 1));
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = initTime - finalTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
        }
    }

    private void AnalisisEstructuraEstacion(HashMap<String, Estacion> listaEstacionesHM) {
        int dataSizes[] = {10000,100000,500000,1000000};
        long resultTimesAllData[] = new long[4];
        long resultTimesOneData[] = new long[4];
        
        
        //Inserción De Todos los datos!
        try{
        for(int i = 0; i< dataSizes.length;i++){
            resultTimesAllData[i] = JsonLoadData.loadDataEstaciones(listaEstacionesHM, dataSizes[i]);
            long initTime = System.nanoTime();
            listaEstacionesHM.put("Prueba",new Estacion("Prueba", i, i, 1, 1));
            long finalTime = System.nanoTime();
            resultTimesOneData[i] = finalTime - initTime;
            cleanData();
        }
        }catch(Exception e){
            System.out.println("Hubo algun error al cargar grandes cantidades de datos. \n" + e);
        }
        
        for(int i = 0;i < resultTimesAllData.length;i++){
            System.out.println(String.format("Tiempo Inserción de %d datos:" + resultTimesAllData[i]/1000000 + " milliseg ",dataSizes[i] ));
            System.out.println(String.format("Tiempo inserción un solo dato con %d datos introducidos: " + resultTimesOneData[i] + " nanoSeg \n",dataSizes[i]));
        }
    }

    private static void metodoNoImplementado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
