package ap3_1;
import java.util.Scanner;

/**
 *
 * @author Alejandro Miralles Villalonga
 * @version 27/10/2016
 */
public class AP3_2 extends Thread{
    public static final int LIMITESUPERIOR = 99;
    public static final int LIMITEINFERIOR = 1;
    static boolean h1, h2, h3, h4, h5;
    static int num1, num2, num3, num4, num5;
    static int [] array;
    
    /**
     * Metodo que guarda en el array 5 numeros aleatorios del 1 al 99.
     */
    public static void arrayInfinito(){
        for (int i = 0; i < array.length; i++){
            array[i]= (int)Math.floor(Math.random()*(LIMITESUPERIOR-LIMITEINFERIOR  +1)  +  LIMITEINFERIOR);
        }
    }
    
    /**
     * Metodo para pedir un entero por teclado.
     *
     * @return Devuelve un entero.
     */
    public static int scannerInt() {
        System.out.print("-->");
        Scanner lector = new Scanner(System.in);
        boolean correcte;
        int entero;
        do {
            correcte = lector.hasNextInt();
            if (!correcte) {
                System.out.print("No has introducido un entero. Introducelo: -->");
                lector.nextLine();
            }
        } while (!correcte);
        entero = lector.nextInt();
        lector.nextLine();
        return entero;
    }
    
    public AP3_2(){
        
    }
    
    public void run(){
        if (h1 == true){
            h1 = false;
            metodoHilo1();
        }else if(h2 == true){
            h2=false;
            metodoHilo2();
        }else if(h3 == true){
            h3=false;
            metodoHilo3();
        }else if(h4 == true){
            h4=false;
            metodoHilo4();
        }else if(h5 == true){
            h5=false;
            metodoHilo5();
        }
    }
    void compararPrioridades(){
        
    }
    void metodoHilo1(){
        
    }
    
    void metodoHilo2(){
        
    }
    void metodoHilo3(){
        
    }
    void metodoHilo4(){
        
    }
    void metodoHilo5(){
        
    }
    
    public static void main(String[] args) {
        System.out.println("Generamos el array");
        arrayInfinito();
        System.out.println("Creamos a hilo1.");
        Thread hilo1 = new AP3_2();
        System.out.print("Asignar prioridad al hilo1:");
        hilo1.setPriority(scannerInt());
        h1=true;
        hilo1.start();
    }
}
