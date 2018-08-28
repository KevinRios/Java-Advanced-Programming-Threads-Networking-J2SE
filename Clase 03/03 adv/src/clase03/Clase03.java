package clase03;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Clase03 {

    public static void main(String[] args) {

        class Saludo {

            public synchronized void saludar(String nombre, boolean esJefe) {

                if (esJefe) {
                    System.out.println("Jefe-> Hola a todos");
                    try {
                        synchronized(this){
                            notify();
                                    
                        }
                    } catch (Exception e) {
                    }
                } else {
                    try {
                        synchronized (this) {
                            wait();
                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Clase03.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.printf("%s -> Hola jefe \n", nombre);
                }
            } // end method saludar
        } // end class saludo

        class Empleado implements Runnable {

            private String nombre;
            private boolean esJefe;
            private Saludo saludo;

            public Empleado(String nombre, boolean esJefe, Saludo saludo) {
                this.nombre = nombre;
                this.esJefe = esJefe;
                this.saludo = saludo;
            }

            @Override
            public void run() {
                System.out.printf("%s  Llego\n", nombre);
                saludo.saludar(nombre, esJefe);

            }

        } // end clas Empleadoo
        // esta clase se ejecuta en un hilo y produce el saludo

        Saludo saludo = new Saludo();
        Empleado e1 = new Empleado("Mario", false, saludo);
        Empleado e2 = new Empleado("Ana", false, saludo);
        Empleado e3 = new Empleado("Luis", false, saludo);
        Empleado e4 = new Empleado("Dario", false, saludo);
        Empleado e5 = new Empleado("Big Boss", true, saludo);

        try {
            new Thread(e1).start();
            new Thread(e2).start();
            new Thread(e3).start();
            new Thread(e4).start();
            Thread.sleep(200);
            new Thread(e5).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        /*
        
                            Conexion TCP
            SERVER                                 CLIENT
            ------------                          ------------
            ServerSocket(port)                    Socket(IP,port);
            .accept();                            
            .close();
            ------------                          ------------


            OutputStream  ----------------->      InputStream
            InputStream   <-----------------      OutputStream

            ------------                          ------------
            .close();                             .close();
        
        
        DataOutputSrteam    DataInputStream      -- Datos Primitivos de Java(ccontra- java en ambos lados cl, ser)
        ObjectOutputStream  ObjectOutputStream   -- Objetos de java
        
        
        
        
        */

    } // end main

} // end clase 03
