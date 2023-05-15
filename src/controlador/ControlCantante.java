package controlador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modelo.ConsultasCantante;
import modelo.Cantante;
import vista.Ventana;

public class ControlCantante extends JPanel implements ActionListener  {

    private Cantante cant;
    private ConsultasCantante consu;
    private Ventana ven;
 

    public ControlCantante(Cantante cant, ConsultasCantante consu, Ventana ven) {
        this.cant = cant;
        this.consu = consu;
        this.ven = ven;        
        this.ven.bGuardar.addActionListener(this);
        this.ven.bModificar.addActionListener(this);
        this.ven.bEliminar.addActionListener(this);
        this.ven.bLimpiar.addActionListener(this);
        this.ven.bBuscar.addActionListener(this);
    }
    
     public void setImagenFondo(String rutaImagen) {
        ImageIcon imagen = new ImageIcon(rutaImagen);
        Image img = imagen.getImage();
        Image imagenEscalada = img.getScaledInstance(ven.panel1.getWidth(), ven.panel1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imagenFondo = new ImageIcon(imagenEscalada);
        ven.panel1.setOpaque(false);
        ven.panel1.setBackground(new Color(0, 0, 0, 0));
        ven.panel1.setBorder(null);
        ven.panel1.setLayout(new BorderLayout());
        JLabel etiquetaImagen = new JLabel(imagenFondo);
        ven.panel1.add(etiquetaImagen, BorderLayout.CENTER);
        ven.panel1.repaint();
    }
  
    
   
    public void iniciarVista() {
        ven.setTitle("CANTANTES");
        ven.setLocationRelativeTo(null);
        String rutaImagen = "C:\\Users\\javie\\NetBeansProjects\\ProyectoCantantes\\src\\controlador\\V1.jpg";
        setImagenFondo(rutaImagen);

    }

  
    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getSource() == ven.bGuardar) {
            try {
                cant.setId(Integer.parseInt(ven.tId2.getText()));
                cant.setNombre(ven.tNombre.getText());
                cant.setApellido(ven.tApellido.getText());
                cant.setEstilo(ven.tEstilo.getText());
                if (consu.registrar(cant)) {
                    JOptionPane.showMessageDialog(null, "Cantante guardado");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                    limpiar();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error al guardar");
            }

        }
        if (evento.getSource() == ven.bModificar) {
            cant.setId(Integer.parseInt(ven.tId2.getText()));
            cant.setNombre(ven.tNombre.getText());
            cant.setApellido(ven.tApellido.getText());
            cant.setEstilo(ven.tEstilo.getText());
            if (consu.modificar(cant)) {
                JOptionPane.showMessageDialog(null, "Cantante modificado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al modificar");
                limpiar();
            }
        }
        if (evento.getSource() == ven.bEliminar) {
            cant.setId(Integer.parseInt(ven.tId2.getText()));

            if (consu.eliminar(cant)) {
                JOptionPane.showMessageDialog(null, "Cantante eliminado");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar");
                limpiar();
            }
        }
        if (evento.getSource() == ven.bBuscar) {
            cant.setId(Integer.parseInt(ven.tId2.getText()));
            if (consu.buscar(cant)) {
                ven.tId2.setText(String.valueOf(cant.getId()));
                ven.tNombre.setText(cant.getNombre());
                ven.tApellido.setText(cant.getApellido());
                ven.tEstilo.setText(cant.getEstilo());
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ningún cantante");
                limpiar();
            }
        }
        if (evento.getSource() == ven.bLimpiar) {
            limpiar();
        }
    }
    
      private Ventana ventana;
    
  

    /**
     * Método que limpia las líneas de texto.
     */
    public void limpiar() {
        ven.tId2.setText(null);
        ven.tNombre.setText(null);
        ven.tApellido.setText(null);
        ven.tEstilo.setText(null);
    }

}
