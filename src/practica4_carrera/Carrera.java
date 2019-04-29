/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica4_carrera;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam12
 */
public class Carrera {
    private int inscripciones;
    Scanner teclado = new Scanner(System.in);
    ArrayList<Corredores>bbdd = new ArrayList<>();
    
    public void generar_Corredores(int inscripciones) throws IOException{
        this.inscripciones = inscripciones;
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        String [] nombres = {"Pedro","Aaron","Dani","Javier","Juanjo","Diego","Luis",};
        String [] categoria = {"M","F"};
        String [] edad = {"Senior","Veterano"};
        String [] tiempo = {"0s"};
        
        try {
            fos = new FileOutputStream("carrera.pop");
            oos = new ObjectOutputStream(fos);
            
            for (int i = 0; i < inscripciones ; i++){
                Corredores tmp = new Corredores();
                tmp.setNombre(nombres[(int)(Math.random()*7)]);
                tmp.setCategoria(categoria[(int)(Math.random()*2)]);
                tmp.setEdad(edad[(int)(Math.random()*2)]);
                tmp.setTiempo(tiempo[(int)(Math.random()*1)]);
                tmp.setDorsal(i);
                oos.writeObject(tmp);
                bbdd.add(tmp);
            }
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void mostrarFichero(){
        FileInputStream fis;
        ObjectInputStream ois;
        Corredores tmp;
        
        try {
            fis = new FileInputStream("carrera.pop");
            ois = new ObjectInputStream(fis);
            
            while (true){
                tmp = (Corredores)ois.readObject();
                System.out.println(tmp.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EOFException ex){
        } catch (IOException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void actualizarCarrera(){
        FileOutputStream fos;
        ObjectOutputStream oos;
        
        try {
            fos = new FileOutputStream("carrera.pop");
            oos = new ObjectOutputStream(fos);
            for (int i = 0; i < inscripciones ; i++){
                Corredores tmp;
                int tiempo = ThreadLocalRandom.current().nextInt(1800,7200);
                tmp = bbdd.get(i);
                tmp.setTiempo(tiempo+"s");
                oos.writeObject(tmp);    
            } 
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void actualizarCorredor(int dorsal){
        FileOutputStream fos;
        ObjectOutputStream oos;
        Scanner teclado2 = new Scanner(System.in);
        
        try {
            fos = new FileOutputStream("carrera.pop");
            oos = new ObjectOutputStream(fos);
        for (int i = 0; i < inscripciones ; i++){
            Corredores tmp;
            tmp = bbdd.get(i);
            if (tmp.getDorsal()==dorsal){
                System.out.println("Introduzca el Nombre");
                String nombre = teclado2.nextLine();
                System.out.println("Introduzca la Categoria M o F");
                String categoria = teclado2.nextLine();
                System.out.println("Introduzca la Edad");
                String edad = teclado2.nextLine();
                System.out.println("Introduzca el tiempo realizado");
                String tiempo = teclado2.nextLine();
                tmp.setNombre(nombre);
                tmp.setCategoria(categoria);
                tmp.setEdad(edad);
                tmp.setTiempo(tiempo+"s");
            }
            oos.writeObject(tmp);
        }
            fos.close();
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Carrera.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void menu() throws IOException{
        int opcion = 1;
        while (opcion!=0){
            System.out.println("0. Salir");
            System.out.println("1. Introduzca el numero de corredores");
            System.out.println("2. Mostrar Corredores");
            System.out.println("3. Generar Carrera");
            System.out.println("4. Mostrar Carrera");
            System.out.println("5. Actualizar Corredor");
            opcion = teclado.nextInt();
            if (opcion==1){
                int num = teclado.nextInt();
                generar_Corredores(num);
            }
            if (opcion==2){
                mostrarFichero();
            }
            if (opcion==3){
                actualizarCarrera();
            }
            if (opcion==4){
                mostrarFichero();
            }
            if (opcion==5){
                System.out.println("Introduzca el dorsal del corredor a actulizar");
                int dorsal = teclado.nextInt();
                actualizarCorredor(dorsal);
            }
        }
    }

}
