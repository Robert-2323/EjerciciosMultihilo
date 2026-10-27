package EJ2;

import java.util.Random;

public class Clientes implements Runnable {
    private int numero;
    private Almacen almacen;
    private Random random=new Random();

    public Clientes(int num,Almacen almacen){
        this.numero=num;
        this.almacen=almacen;
    }

    @Override
    public void run() {
        boolean haEntrado=false;

        for(int intento=1;intento<=10;intento++){
            if(almacen.entrar()){
                haEntrado=true;
                System.out.println("Cliente "+numero+" ha conseguido entrar");

                //Simula un tiempo de espera
                try{
                    Thread.sleep(random.nextInt(200)+100);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }

                //Comprueba si quedan productos
                if(almacen.cogerProducto()){
                    System.out.println("Cliente "+numero+" ha conseguido un producto");

                }
                else {
                    System.out.println("Cliente "+numero+" entra, pero no quedan productos");
                }

                //Libera puerta
                almacen.liberarPuerta();
                break;
            }
            System.out.println("Cliente "+numero+" no consigue entrar. Intento numero: "+intento);

            try{
                Thread.sleep(random.nextInt(200)+100);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }

        }
        if (!haEntrado){
            System.out.println("Cliente "+numero+" desiste despues de 10 intentos");
        }
    }

}
