package EJBarberos;

import EJ2.Clientes;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainBarberos {
    public static void main(String[] args) {
        ExecutorService executor= Executors.newFixedThreadPool(25);
        Barberia barberia=new Barberia();
        Clientes[] clientes=new Clientes[50];

        for (int i=0;i< clientes.length;i++){
            executor.execute(new Clientes2(i,barberia));
        }
        executor.shutdown();
    }
}
