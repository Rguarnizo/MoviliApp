/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Data.DataStructures.Array.DynamicArray;
import Data.DataStructures.LinkedList;
import Data.User;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Rubén Darío Martínez
 */
public class DataManipulation extends Thread {
    
    Scanner scanner = new Scanner(System.in);
    
    public static LinkedList<User> listaUsuariosLK;
    public static HashMap<String,User> listaUsuariosHM;
    public static DynamicArray<User> listaUsuariosDA;
    

    
    public DataManipulation(String msg){
        super(msg);
        this.listaUsuariosDA = new DynamicArray<>(10);
        this.listaUsuariosHM = new HashMap<>();
        this.listaUsuariosLK = new LinkedList<>();
    }
    
    
    public void run(){
        
        boolean exec = true;
        
        while (exec){

            System.out.println ("MoviliAPP");
            System.out.println ("Seleccione una opción para continuar:");
            System.out.println ("1.Cargar Datos Necesarios.");
            System.out.println ("2.Cargar Datos Especificos.");
            System.out.println ("3.Analizar Datos.");         
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
                case 4:
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
            System.out.println ("Analizar Data");
            System.out.println ("Seleccione una opción para continuar:");
            System.out.println ("1.Analisis DynamicArray.");
            System.out.println ("2.Analisis LinkedList.");
            System.out.println ("3.Redimiento Comparado.");
            System.out.println ("4.Limpiar Datos");
            System.out.println ("5.Salir");

            int option = 0;

            try {
                option = scanner.nextInt ();
                scanner.nextLine ();
            }catch (Exception e) {
                System.out.println ("Verifique que su entrada este en las opciones" + e);
            }
            switch (option) {
                case 1: analyzeDynamicArray(listaUsuariosDA);
                    break;
                case 2: analyzeLinkedList(listaUsuariosLK);
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

    private void analyzeLinkedList (LinkedList<User> userLinkedList) {

        boolean analyzeDA = true;

        while (analyzeDA) {
            System.out.println ();
            System.out.println ();
            System.out.println ("Analisis Linked List");
            System.out.println ();
            System.out.println ("Seleccione la cantidad de datos a Analizar:");
            System.out.println ("1. 10 mil.");
            System.out.println ("2. 50 mil.");
            System.out.println ("3. 100 mil.");
            System.out.println ("4. 500 mil.");
            System.out.println ("5. 1 million");
            System.out.println ("6. 10 millones");
            System.out.println ("7. Salir");


            int option = 0;

            try {
                option = scanner.nextInt ();
            } catch (Exception e) {
                System.out.println ("Verifique que su entrada este en las opciones");
            }
            long timeLoadData = 0;
            switch (option) {
                case 1:
                    timeLoadData = JsonLoadData.loadData (userLinkedList, 10000);

                case 2:
                    timeLoadData = JsonLoadData.loadData (userLinkedList, 50000);

                case 3:
                    timeLoadData = JsonLoadData.loadData (userLinkedList, 100000);

                case 4:
                    timeLoadData = JsonLoadData.loadData (userLinkedList, 500000);

                case 5:
                    timeLoadData = JsonLoadData.loadData (userLinkedList, 1000000);

                case 6:
                    timeLoadData = JsonLoadData.loadData (userLinkedList, 10000000);

                case 7:
                    analyzeDA = false;
                    break;
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;

            }
            System.out.println ();
            System.out.println ();
            System.out.println ("Rendimiento Linked List:");
            System.out.println ();
            System.out.println ("Cargar Datos: "+ timeLoadData/1000000  + "ms");
            System.out.println ("Insertar valor: " + userLinkedList.pushBack (new User ("Prueba","Prueba","Prueba","Prueba","Prueba","Prueba","Prueba"))+"ns");
            System.out.println ("Actualizar valor(Ultimo):" + userLinkedList.get (userLinkedList.getSize ()-1));
            System.out.println ("Busqueda por indice (Ultimo): ");
            System.out.println ("Busqueda por valor (Ultimo): ");
            System.out.println ("Eliminar Valor(Ultimo): ");

        }
    }

    private void analyzeDynamicArray (DynamicArray<User> userDynamicArray) {

        boolean analyzeDA = true;

        while (analyzeDA){
            System.out.println ();
            System.out.println ();
            System.out.println ("Analisis Dynamic Array");
            System.out.println ();
            System.out.println ("Seleccione la cantidad de datos a Analizar:");
            System.out.println ("1. 10 mil.");
            System.out.println ("2. 50 mil.");
            System.out.println ("3. 100 mil.");
            System.out.println ("4. 500 mil.");
            System.out.println ("5. 1 million");
            System.out.println ("6. 10 millones");
            System.out.println ("7. Salir");


            int option = 0;

            try{
                option = scanner.nextInt ();
            }catch (Exception e){
                System.out.println ("Verifique que su entrada este en las opciones");
            }
            long timeLoadData = 0;

            switch (option) {
                case 1: timeLoadData = JsonLoadData.loadData (userDynamicArray,10000);
                    break;
                case 2: timeLoadData = JsonLoadData.loadData (userDynamicArray,50000);
                    break;
                case 3: timeLoadData = JsonLoadData.loadData (userDynamicArray,100000);
                    break;
                case 4: timeLoadData = JsonLoadData.loadData (userDynamicArray,500000);
                    break;
                case 5: timeLoadData = JsonLoadData.loadData (userDynamicArray,1000000);
                    break;
                case 6: timeLoadData = JsonLoadData.loadData (userDynamicArray,10000000);
                    break;
                case 7: analyzeDA = false;
                    break;
                default:
                    System.out.println ("Introduzca una opción correcta.");
                    break;
            }
            System.out.println ();
            System.out.println ();
            System.out.println ("Rendimiento Array Dinamico:");
            System.out.println ();
            System.out.println ("Cargar Datos: "+ timeLoadData/1000000  + "ms");
            System.out.println ("Insertar valor: " + userDynamicArray.push (new User ("Prueba","Prueba","Prueba","Prueba","Prueba","Prueba","Prueba"))+"ns");
            System.out.println ("Actualizar valor(Ultimo): ");
            System.out.println ("Busqueda por indice (Ultimo): ");
            System.out.println ("Busqueda por valor (Ultimo): ");
            System.out.println ("Eliminar Valor(Ultimo): ");


        }
    }
    
}
