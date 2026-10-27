package EJ2;

public class Almacen {
    private int productos;
   private  boolean puertaOcupada;

    public Almacen(int productos){
        this.productos=productos;
        this.puertaOcupada=false;
    }

    //Intenca entrar por la puerta
    public synchronized boolean entrar(){
        if(puertaOcupada){return false; }
        puertaOcupada=true;
        return true;
    }

    //liberar puerta
    public synchronized void liberarPuerta(){puertaOcupada=false;}

    //intenta coger un producto
    public synchronized boolean cogerProducto(){
       if(productos==0){return false;}
       productos--;
       return true;
    }

    //Devuelve los prductos restantes
    public synchronized int getProductos(){
       return productos;
    }
}
