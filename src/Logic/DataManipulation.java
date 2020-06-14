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
            System.out.println ("4.Visualizar Data.");
            System.out.println ("5.Salir");

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
                case 3: 
                    break;
                case 4: visualizateData ();
                    break;
                case 5: exec =  false;
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
                case 1: 
                    break;
                case 2: 
                    break;
                case 3:
                    break;
                case 4: cleanData(listaUsuariosDA,listaUsuariosLK);
                    break;
                case 5: analyzeData =  false;
                    break;
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;
            }
        }
    }

    private void cleanData (DynamicArray<User> userDynamicArray, LinkedList<User> userLinkedList) {
        userDynamicArray.makeEmpty ();
        userLinkedList.makeEmpty ();
    }
    
    private static void visualizateData () {
        for (int i = 0; i < listaUsuariosDA.getSize ();i++){
            System.out.println (listaUsuariosDA.get (i).toString ());
        }
        System.out.println (listaUsuariosDA.getSize ());
    }
    
}
