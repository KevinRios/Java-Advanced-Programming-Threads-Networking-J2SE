package com.KevinRios.java.ServicioEmail;

import java.util.concurrent.TimeUnit;

public class Servidor {

    public void recibe(Cliente cliente) {

        Runnable tarea = () -> {

            try {
                System.out.println("Enviando un email de " + cliente.getNombre());
                Thread.sleep(10000);
                System.out.println("ENVIADO DE" + cliente.getNombre());

            } catch (Exception e) {
            }
        };
        
        Thread th = new Thread();
       tarea.run();
    }//end method recibe
} // end class
