package ar.com.kevinrios.javaadv.clase01;

public class Clase01 {
    public static void main(String[] args) {
       
        
        System.out.println("Version de Java: "
                +System.getProperty("java.version"));
        System.out.println("Cantidad de nucleos: "
                +Runtime.getRuntime().availableProcessors());
        
        
        /*
            Tarea 1: cargar file1 de medio a    10 s
            Tarea 2: cargar file2 de medio b    10 s
            Tarea 3: abrir form y mostrar contenidio de los files.  1 s
        
                10 s        10 s   1 s
            |----------|----------|-|
               Tarea 1    Tarea 2  Tarea 3
        
            Total: 21 s
        
                10 s 
            |----------|
               Tarea 1
        
                10 s 
            |----------|
               Tarea 2   
                        1 s
                       |-|
                        Tarea 3
        
            Total: 11 s
        
        
                10 s 
            |----------|
               Tarea 1
        
                10 s 
            |----------|
               Tarea 2   
             1 s
            |-|
             Tarea 3
        
        */
        
        //declaración de clase interna
        class Hilo extends Thread{
            private String nombre;
            public Hilo(String nombre) {
                this.nombre = nombre;
            }
            @Override public void run(){
                //Este método se ejecuta en un hilo nuevo.
                for(int a=1;a<=10;a++){
                    System.out.println(nombre+" "+a);
                    try { Thread.sleep(1000); }catch(Exception e){}
                }
            }
        }//end class Hilo
        
        Hilo hilo1=new Hilo("hilo1");
        Hilo hilo2=new Hilo("hilo2");
        Hilo hilo3=new Hilo("hilo3");
        Hilo hilo4=new Hilo("hilo4");
        
        //El método run() no ejecuta en un nuevo.
        //hilo1.run();
        //hilo2.run();
        //hilo3.run();
        //hilo4.run();
        
        //El método start() ejecuta el método run() en un hilo nuevo
        //hilo1.start();
        //hilo2.start();
        //hilo3.start();
        //hilo4.start();
        
        //Hilo anonimo
        //new Hilo("hilo5").start();
        
        //lanza java.lang.IllegalThreadStateException
        //hilo1.start();
        
        //Interface Runnable
        class HiloRunnable implements Runnable{
            private String nombre;
            public HiloRunnable(String nombre) {
                this.nombre = nombre;
            }
            @Override public void run(){
                for(int a=1;a<=10;a++){
                    System.out.println(nombre+" "+a);
                    try { Thread.sleep(1000); } catch(Exception e) {}
                }
            }
        }//end class HiloRunnable
        
        HiloRunnable hiloR1=new HiloRunnable("hiloR1");
        HiloRunnable hiloR2=new HiloRunnable("hiloR2");
        HiloRunnable hiloR3=new HiloRunnable("hiloR3");
        HiloRunnable hiloR4=new HiloRunnable("hiloR4");
        
        Thread tHiloR1=new Thread(hiloR1);
        Thread tHiloR2=new Thread(hiloR2);
        Thread tHiloR3=new Thread(hiloR3);
        Thread tHiloR4=new Thread(hiloR4);
        
        tHiloR1.start();
        tHiloR2.start();
        tHiloR3.start();
        tHiloR4.start();
        
        //HiloRunnable Anonimo
        new Thread(new HiloRunnable("hiloR5")).start();
        
    }// end main
}// end class Clase01
