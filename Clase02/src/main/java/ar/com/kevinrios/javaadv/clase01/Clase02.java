package ar.com.kevinrios.javaadv.clase01;

public class Clase02 {
    public static void main(String[] args) {
        //sincronismo de hilos
        
        class Hilo implements Runnable{
            
            private String nombre;
            private int ms;

            public Hilo(String nombre, int ms) {
                this.nombre = nombre;
                this.ms = ms;
            }
            
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(nombre+" "+i);
                    try {
                        Thread.sleep(ms);
                    } catch (Exception e) {
                    }
                }
            }
            
        } // end class hilo
        
        Thread t1 = new Thread(new Hilo("Hilo 1",1000));
        Thread t2 = new Thread(new Hilo("Hilo 2",500));
        Thread t3 = new Thread(new Hilo("Hilo 3",100));
        Thread t4 = new Thread(new Hilo("Hilo 4",400));
        
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(4);
        
        System.out.println(t1.getState());
        System.out.println(t1.isAlive());
        
        try {
            
            t1.start();
            t2.start();
            t3.start();
            
            // con esto evito que se ejecute el hilo 4, hasta que termine el 3
            //t3.join();
            //t4.start();
            
            // con esto el hilo 3 se une al hilo principal. El hilo principal 
            // no se va a ejecutar hasta que termine el hilo 3
            t3.join();
            
            // detengo la ejecucion del hilo principal hasta que terminen 
            // todos los hilos
           t1.join();
            t2.join();
            t4.join();
            
            
        } catch (Exception e) {
        }
        
        
        try {
            Thread.sleep(200);
        } catch (Exception e) {
        }
        System.out.println(t1.getState());
        System.out.println(t1.isAlive());
        
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        System.out.println(t1.getState());
        System.out.println(t1.isAlive());
        
        
        System.out.println(" -- Fin del Programa -- ");
        
        
    }
}
