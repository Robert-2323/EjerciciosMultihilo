package EJBarberos;

import java.util.Random;

public class Clientes2 implements Runnable{
    private int numCliente;
    Barberia barberia;
    private boolean afeitado=false;
    Random random=new Random();

    public Clientes2(int numCliente, Barberia barberia){
        this.numCliente=numCliente;
        this.barberia=barberia;
    }

    @Override
    public void run() {
        if (barberia.isSillasLibre()){
            barberia.cogerSilla();
            try{
                Thread.sleep(random.nextInt(200)+100);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
            afeitado=true;
            barberia.liberarSilla();
            System.out.println("El cliente "+numCliente+" ha sido atendido.");
        }else {
            System.out.println("Todas las sillas estan ocupadas, el cliente"+numCliente+" se va.");
        }
    }
}
