
package javaapplication1;

import java.util.List;


public class TspSol {
    
    private List<ciudad> ciudades;
    private int id;

    public TspSol(int id, List<ciudad> ciudades) {
        this.ciudades = ciudades;
        this.id = id;
    }

    @Override
    public String toString() {
        return "TspSol {" + id + " " + ciudades + "} = " + this.getFitness();
    }
    
    public double getFitness(){
        double salida =0.0;
        
        for (int i=0; i < ciudades.size()-1; i++){
            salida += ciudades.get(i).distancia(ciudades.get(i+1));
        }
        salida += ciudades.get(0).distancia(ciudades.get(ciudades.size()-1));
        
        return salida;
    }
    
    
}
