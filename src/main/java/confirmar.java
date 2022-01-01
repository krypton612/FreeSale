import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class confirmar extends JFrame{
    public confirmar(){
        setSize(300, 220);
        setTitle("Confirmar");
        setLayout(null);
    
        this.getContentPane().setBackground(Color.WHITE);
        
        setLocationRelativeTo(null);
        iniciarComponentes();

    }
    public void iniciarComponentes() {
        confirmar();
    }
    public void confirmar() {
        JButton si = new JButton();
        JButton no = new JButton();

        JLabel mensaje = new JLabel("Esta accion no");

        mensaje.setOpaque(true);
        mensaje.setForeground(Color.BLACK);
        mensaje.setFocusable(false);
        mensaje.setVisible(true);
        mensaje.setFont(new Font("arial",Font.BOLD,12));
        mensaje.setVerticalAlignment(SwingConstants.CENTER);
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje.setBackground(Color.white);
        mensaje.setBounds(40, 100, 300, 25);

        add(mensaje);

        JLabel mensaje2 = new JLabel("se puede desacer");

        mensaje2.setOpaque(true);
        mensaje2.setForeground(Color.black);
        mensaje2.setFocusable(false);
        mensaje2.setVisible(true);
        mensaje2.setVerticalAlignment(SwingConstants.CENTER);
        mensaje2.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje2.setFont(new Font("arial",Font.BOLD,12));
        mensaje2.setBackground(Color.white);
        mensaje2.setBounds(40, 125, 300, 25);

        add(mensaje2);

        si.setOpaque(true);
        si.setText("Si borrar");
        si.setForeground(Color.WHITE);
        si.setBorderPainted(false);
        si.setFocusable(false);
        si.setVisible(true);
        si.setFont(new Font("arial",Font.BOLD,12));
        si.setBackground(Color.GRAY);
        si.setBounds(40, 50, 100, 50);
        si.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Conexion primera = new Conexion("prueba3");

                Statement st;
                ResultSet rs;
              
                try {
                 
                  st = primera.conectart().createStatement();

                  st.executeUpdate("DROP TABLE registro");
                  st.executeUpdate("CREATE TABLE registro(id_registro int(11) NOT NULL AUTO_INCREMENT,tipo_plato varchar(225) NOT NULL,cantidad int(11) NOT NULL,precio int(11) NOT NULL,estado bit(1) NOT NULL, PRIMARY KEY (id_registro))");

                  st.executeUpdate("INSERT INTO registro(tipo_plato, cantidad, precio, estado) VALUES ('En Espera',1,1,1)");
                  //st.executeUpdate("DELETE FROM registro");
                

                  setVisible(false);
                  
                } catch (Exception e) {
        
                }
        
            }
      
            @Override
            public void mousePressed(MouseEvent me) {
             
      
            }
      
            @Override
            public void mouseReleased(MouseEvent me) {
      
            }
      
            @Override
            public void mouseEntered(MouseEvent me) {
      
            }
      
            @Override
            public void mouseExited(MouseEvent me) {
              
      
            }
          });

        add(si);

        no.setOpaque(true);
        no.setText("No borrar");
        no.setForeground(Color.WHITE);
        no.setBorderPainted(false);
        no.setFocusable(false);
        no.setVisible(true);
        no.setFont(new Font("arial",Font.BOLD,12));
        no.setBackground(Color.GRAY);
        no.setBounds(150, 50, 110, 50);

        no.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                
                setVisible(false);
        
            }
      
            @Override
            public void mousePressed(MouseEvent me) {
             
      
            }
      
            @Override
            public void mouseReleased(MouseEvent me) {
      
            }
      
            @Override
            public void mouseEntered(MouseEvent me) {
      
            }
      
            @Override
            public void mouseExited(MouseEvent me) {
              
      
            }
          });
        add(no);
    }
   
}
