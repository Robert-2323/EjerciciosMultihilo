package EJBarberos;

public class Barberia {
    private int numSillas=10;
    private boolean sillasLibre=true;


    public int getNumSillas() {
        return numSillas;
    }

    public void setNumSillas(int numSillas) {
        this.numSillas = numSillas;
    }

    public boolean isSillasLibre() {
        return sillasLibre;
    }

    public void setSillasLibre(boolean sillasLibre) {
        this.sillasLibre = sillasLibre;
    }

    public synchronized void cogerSilla(){
        if(numSillas>0 &&sillasLibre){
            numSillas--;
        }
        else {
            sillasLibre=false;
        }
    }

    public synchronized void liberarSilla() {
        numSillas++;
    }

}
