package EJ2;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ej2Main {
    public static void main(String[] args) {

        Almacen almacen=new Almacen(100);
        Clientes[] clientes=new Clientes[300];
        ExecutorService executor= Executors.newFixedThreadPool(10);

        for (int i=0;i<300;i++){
            clientes[i]=new Clientes(i+1,almacen);
            executor.execute(clientes[i]);
        }
        executor.shutdown();
    }
}
