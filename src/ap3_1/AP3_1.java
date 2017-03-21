package ap3_1;

import java.util.Scanner;
/**
 * 
 * @author Jandro
 * @version 27/10/2016
 */
public class AP3_1 extends Thread {

    static int num, prioridad;
    static String nombre;
    static boolean padreV, hijoV, nietoV;
    /**
     * Constructor de los hilos. Los creamos sin ningun valor, por eso esta vacío.
     */
    public AP3_1() {

    }
    /**
     * Metodo al que van todos los hilos al iniciarse su ejecución
     */
    public void run() {
        if (this.padreV == true) {//si es padre entra
            padreV = false;
            crearHijo();
        } else if (this.hijoV == true) {//si es hijo entra
            hijoV = false;
            crearNieto();
        } else if (this.nietoV == true) {//si es nieto entra
            nietoV = false;
            hacerleCosasAlNieto();
        }
    }
    /**
     * Metodo en el que el padre crea al hijo, lo hace demonio, lo inicia y espera a que este termine.
     */
    public void crearHijo() {
        System.out.println("Iniciamos el trabajo del padre:");
        Thread hijo = new AP3_1(); //Creamos al hijo.
        hijoV = true;
        System.out.println("Hijo creado.");
        //Dormimos al padre durante 1 segundo
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println(Thread.currentThread().toString());
        
            System.out.println("El hijo esta vivo!");
            try {
                hijo.setDaemon(true);//convertimos al hijo en Daemon
                hijo.start();//iniciamos al hijo
                hijo.join();//hara que el padre espere a que el hijo muera
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        
        System.out.println("Finaliza el proceso padre!");
    }
    /**
     * Metodo en el que se comprueba que el hijo sea un demonio, se realiza una
     * modificacion a la variable num, se crea al nieto, se inicia y el hijo
     * espera a que termine el nieto.
     */
    public void crearNieto() {
        Scanner lector = new Scanner(System.in);
        System.out.println("Iniciamos el trabajo del hijo:");
        hijoV = false;
        System.out.println("Demonio creado");
        if (Thread.currentThread().isDaemon()) {
            System.out.println("El hijo es un demonio");
        } else {
            System.out.println("Demoio fallido");
        }
        System.out.println("Dale un nombre al hijo");
        Thread.currentThread().setName(lector.next());
        System.out.println("Introducir prioridad [1-10]:");
        Thread.currentThread().setPriority(lector.nextInt());
        System.out.println(Thread.currentThread().toString());
        num*=10;
        System.out.println("Variable num: " + num);
        Thread.currentThread().setPriority(prioridad+2);
        System.out.println("Aumentamos en 2 la prioridad:");
        System.out.println(Thread.currentThread().getPriority());
        Thread nieto = new AP3_1();
        try {
            System.out.println("Dormimos al hijo");
            Thread.sleep(3000);
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        nieto.start();
        nietoV=true;
        try{
            nieto.join();
        } catch (InterruptedException ex) {
            System.out.println(ex);
        }
        System.out.println("Finalizamos al hijo.");
    }
    /**
     * Se le da un nombre al nieto, se le asigna una prioridad normal y modificamos
     * la variable num. Finalmente el nieto muere.
     */
    public void hacerleCosasAlNieto() {
        Scanner lector = new Scanner(System.in);
        nietoV=false;
        System.out.println("Iniciamos al nieto en el camino de la fuerza");
        System.out.println("Darle un nombre al nieto");
        Thread.currentThread().setName(lector.next());
        System.out.println("Asignamos prioridad normal al nieto");
        Thread.currentThread().setPriority(NORM_PRIORITY);
        System.out.println(Thread.currentThread().toString());
        num-=5;
        System.out.println("El nieto ha dado a la variable num el valor: " + num);
        System.out.println("Matamos al nieto...");
    }
    /**
     * Creamos al padre y lo iniciamos.
     * @param args 
     */
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        System.out.println("Bienvenido a la vida de la familia.");
        System.out.println("Introduce el nombre del padre:");
        nombre = lector.nextLine();
        System.out.println("Introduce un entero para dar trabajo a la familia:");
        num = lector.nextInt();
        System.out.println("Introduce un entero para dar prioridad al padre:");
        prioridad = lector.nextInt();

        Thread padre = new AP3_1();//Creamos al padre
        System.out.println("Padre creado.");
        padre.setPriority(prioridad);//indicamos la prioridad
        padre.setName(nombre);//le asignamos nombre
        padreV = true;//Controlamos al padre con el true
        padre.start();//iniciamos la ejecución del padre
    }
}
