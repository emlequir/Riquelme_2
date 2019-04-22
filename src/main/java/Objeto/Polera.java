
package Objeto;

/**
 *
 * @author Erick
 */
public class Polera {
    private String talla;
    private String material;
    private boolean estampado;

    public Polera(String talla, String material, boolean estampado) {
        this.talla = talla;
        this.material = material;
        this.estampado = estampado;
    }

    public String getTalla() {
        return talla;
    }

    public String getMaterial() {
        return material;
    }

    public boolean isEstampado() {
        return estampado;
    }
    
    

    public void printEstampado() {
        if(this.estampado){
            System.out.println("Posee estampado");
        }else{
            System.out.println("No posee estampado");
        }
    }
    
    
}
