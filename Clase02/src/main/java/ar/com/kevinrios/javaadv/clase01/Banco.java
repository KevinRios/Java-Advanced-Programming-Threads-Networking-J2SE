package ar.com.kevinrios.javaadv.clase01;

public class Banco {

    public static void main(String[] args) {
        //sincronismo de hilos

        class Cuenta {

            private float saldo = 1000;

            public  void debitar(float monto) {
                System.out.println(" -- Iniciando Debito-- ");
                synchronized (this) {
                    if (saldo >= monto) {
                        try {
                            Thread.sleep(2000);
                        } catch (Exception e) {
                        }

                        saldo -= monto;
                        System.out.println("Debito Realizado.");
                        System.out.println("Saldo= " + saldo);
                    } else {
                        System.out.println("Saldo Insuficiente");
                    }
                }
                System.out.println(" -- Finalizando Debito -- ");
            }
        } /// end class cuenta

        class Cliente implements Runnable {

            Cuenta cuenta;

            public Cliente(Cuenta cuenta) {
                this.cuenta = cuenta;
            }

            @Override
            public void run() {
                cuenta.debitar(1000);
            }
        } // end class cliente

        // El sincronismo funciona sobre un unico objeto
        Cuenta cuenta = new Cuenta();

        Thread tCliente1 = new Thread(new Cliente(cuenta));
        Thread tCliente2 = new Thread(new Cliente(cuenta));

        tCliente1.start();
        tCliente2.start();

    }
}
