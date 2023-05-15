
package proyectocantantes;

import controlador.ControlCantante;
import modelo.Cantante;
import modelo.ConsultasCantante;
import vista.Ventana;


public class ProyectoCantantes {

 
    public static void main(String[] args) {
      
        Cantante can = new Cantante();
        ConsultasCantante cons = new ConsultasCantante();
        Ventana ven = new Ventana();
        ControlCantante cont = new ControlCantante(can,cons,ven);
        cont.iniciarVista();
        ven.setVisible(true);
        
        
        
    }
    
}
