import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.sql.ResultSet;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import javax.swing.filechooser.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument.Content;
import javax.swing.text.AttributeSet.ColorAttribute;

import com.mysql.cj.x.protobuf.MysqlxNotice.Frame;

public class Ventana2 extends JFrame {

  public JPanel panel;
  public JPanel menu, panel_1_init, panel_1, panel_2, panel_3;
  public JLabel imagenEmpresa, botonDesplegue, pedidos, eliminados;
  public ActionListener one;
  public Color azul = new Color(65, 103, 178);
  public Color fond = new Color(205, 205, 205);

  private Color mostazaClaro = new Color(199,147,22);
  private Color mostazaOscuro = new Color(247,217,23);
  private Color mostazaBorder = new Color(160,113,17);

  private ImageIcon iconoImagen = new ImageIcon();
  private JLabel imageContend = new JLabel();
  public Font tipoLetra = new Font("calibri", Font.PLAIN, 11);
  public Font tipoLetra2 = new Font("calibri", Font.PLAIN, 13);
  public int par = 0, response;
  private int medio = 1200 / 2;
  String fecha;

  public Ventana2() {

    setSize(1200, 700);

    setLocationRelativeTo(null);

    setMinimumSize(new DimensionUIResource(300, 300));
    this.getContentPane();

    iniciarPartes();

    setDefaultCloseOperation(EXIT_ON_CLOSE);
  }

  private void iniciarPartes() {
    colocarPaneles();
    colocarLabelsMenu();
    textoPanel1();
    oyenteReservas();
    oyenteCumplidos();
  }

  private void colocarPaneles() {
    panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(fond);

    menu = new JPanel();
    menu.setBounds(5, 5, 200, 657);
    menu.setBackground(mostazaClaro);
    menu.setLayout(null);
    menu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED)));

    panel_1_init = new JPanel();
    panel_1_init.setBounds(210, 5, 970, 657);
    panel_1_init.setLayout(null);
    panel_1_init.setBackground(mostazaOscuro);

    panel_1 = new JPanel();
    panel_1.setBounds(210, 5, 970, 657);
    panel_1.setLayout(null);
    panel_1.setBackground(Color.WHITE);

    this.getContentPane().add(panel);

    panel.add(panel_1_init);
    panel.add(menu);

    add(panel);

  }

  private void colocarLabelsMenu() {

    botonDesplegue = new JLabel("Panchita");
    botonDesplegue.setHorizontalAlignment(SwingConstants.CENTER);
    botonDesplegue.setVerticalAlignment(SwingConstants.CENTER);
    botonDesplegue.setOpaque(true);
    botonDesplegue.setFont(tipoLetra);
    botonDesplegue.setBounds(5, 5, 187, 90);

    botonDesplegue.setBackground(mostazaClaro);
    botonDesplegue.setFont(new Font("calibri", Font.BOLD, 15));
    botonDesplegue.setLayout(null);

    pedidos = new JLabel("Pedidos");

    pedidos.setHorizontalAlignment(SwingConstants.CENTER);
    pedidos.setVerticalAlignment(SwingConstants.CENTER);
    pedidos.setBorder(BorderFactory.createLineBorder(new Color(160,113,17), 2, false));
    pedidos.setBounds(5, 95, 187, 40);
    pedidos.setOpaque(true);
    pedidos.setFont(tipoLetra);

    pedidos.setBackground(Color.WHITE);
    pedidos.setLayout(null);

    menu.add(imageContend);

    menu.add(botonDesplegue);
    menu.add(pedidos);

    eliminados = new JLabel("Cumplidos");
    eliminados.setBorder(BorderFactory.createLineBorder(new Color(160,113,17), 2, false));

    eliminados.setHorizontalAlignment(SwingConstants.CENTER);
    eliminados.setVerticalAlignment(SwingConstants.CENTER);
    eliminados.setBounds(5, 140, 187, 40);
    eliminados.setOpaque(true);
    eliminados.setFont(tipoLetra);

    eliminados.setBackground(Color.WHITE);
    eliminados.setLayout(null);

    JLabel vaciar = new JLabel("Vaciar");

    // scroll.setBounds(10,10, 840, 640);

    vaciar.setHorizontalAlignment(SwingConstants.CENTER);
    vaciar.setVerticalAlignment(SwingConstants.CENTER);
    vaciar.setBounds(5, 600, 187, 40);
    vaciar.setOpaque(true);
    vaciar.setFont(tipoLetra);
    vaciar.setBorder(BorderFactory.createLineBorder(mostazaBorder, 2, false));
    vaciar.setBackground(Color.WHITE);
    vaciar.setLayout(null);
    
    vaciar.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        confirmar valor = new confirmar();
        valor.setVisible(true);
       
      }

      @Override
      public void mousePressed(MouseEvent me) {
        vaciar.setBackground(Color.LIGHT_GRAY);

      }

      @Override
      public void mouseReleased(MouseEvent me) {

      }

      @Override
      public void mouseEntered(MouseEvent me) {

      }

      @Override
      public void mouseExited(MouseEvent me) {
        vaciar.setBackground(Color.WHITE);

      }
    });

    menu.add(vaciar);
    menu.add(eliminados);
  }

  private void textoPanel1() {

    JLabel texto = new JLabel();
    JLabel texto2 = new JLabel();
    JLabel texto3 = new JLabel();
    JLabel texto4 = new JLabel();

    texto.setText("Bienvenido al panel de administracion");

    texto2.setText("disfrute su estadia, la guia ..");
    texto2.setOpaque(false);
    texto2.setFont(tipoLetra2);
    texto2.setForeground(Color.BLACK);
    texto2.setBackground(Color.GRAY);
    texto2.setBounds(320, 330, 400, 15);

    texto3.setText("de uso esta ahi en el enlace adjunto ");

    texto4.setText("http://localhost:8080/licenses/guia.pdf");
    texto.setOpaque(false);
    texto.setFont(tipoLetra2);
    texto.setForeground(Color.BLACK);
    texto.setBackground(Color.GRAY);
    texto.setBounds(320, 310, 400, 15);

    texto3.setOpaque(false);
    texto3.setFont(tipoLetra2);
    texto3.setForeground(Color.BLACK);
    texto3.setBackground(Color.GRAY);
    texto3.setBounds(320, 350, 400, 15);

    texto4.setOpaque(false);
    texto4.setFont(tipoLetra2);
    texto4.setForeground(Color.BLACK);
    texto4.setBackground(Color.GRAY);
    texto4.setBounds(320, 370, 400, 15);

    panel_1_init.add(texto);
    panel_1_init.add(texto2);
    panel_1_init.add(texto3);
    panel_1_init.add(texto4);

  }

  private void oyenteReservas() {

    MouseListener primerClick = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {
        botones();
        String[][] matriz = new String[40][40];

        String id_almacen = "0";
        String tipo_almacen = "0";
        String cantidad_almacen = "0";
        String precio_almacen = "0";

        Conexion primera = new Conexion("prueba3");

        PilaC contenedor = new PilaC();
        Pila id_pedido = new Pila();
        Pila cantidad = new Pila();
        Pila precio = new Pila();
        PilaC tipo_plato = new PilaC();

        PilaC contenedor2 = new PilaC();
        Pila id_pedido2 = new Pila();
        Pila cantidad2 = new Pila();
        Pila precio2 = new Pila();
        PilaC tipo_plato2 = new PilaC();

        Statement st;
        ResultSet rs;

        try {
          st = primera.conectart().createStatement();
          rs = st.executeQuery("select * from registro");

          while (rs.next()) {

            if (rs.getBoolean("estado")) {
              id_pedido.adicionar(rs.getInt("id_registro"));
              tipo_plato.adicionar(rs.getString("tipo_plato"));
              cantidad.adicionar(rs.getInt("cantidad"));
              precio.adicionar(rs.getInt("precio"));
            } else {
              id_pedido2.adicionar(rs.getInt("id_registro"));
              tipo_plato2.adicionar(rs.getString("tipo_plato"));
              cantidad2.adicionar(rs.getInt("cantidad"));
              precio2.adicionar(rs.getInt("precio"));
            }

          }
        } catch (Exception e) {
          // TODO: handle exception
        }
        int tok = 0;
        while (!id_pedido.esVacia()) {
          id_almacen = String.valueOf(id_pedido.eliminar());
          tipo_almacen = tipo_plato.eliminar();
          cantidad_almacen = String.valueOf(cantidad.eliminar());
          precio_almacen = String.valueOf(precio.eliminar());

          String[] matsuma = { id_almacen, tipo_almacen, cantidad_almacen, precio_almacen };

          matriz[tok] = matsuma;
          tok = tok + 1;

        }

        panel_1_init.removeAll();

        panel_1_init.revalidate();
        panel_1_init.repaint();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id");
        model.addColumn("tipo de plato");
        model.addColumn("cantidad");
        model.addColumn("precio");

        for (int i = 0; i < 38; i++) {
          model.addRow(matriz[i]);
        }

        JTable dado = new JTable(model);
        dado.setBounds(10, 10, 840, 640);
        dado.setEnabled(false);
        botones();
        // panel_1_init.add(dado);

        JScrollPane scroll = new JScrollPane(dado, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scroll.setBounds(10, 10, 940, 640);
        scroll.setBounds(10, 10, 840, 640);

        panel_1_init.add(scroll);
        panel_1_init.revalidate();
        panel_1_init.repaint();

      }

      @Override
      public void mousePressed(MouseEvent me) {
        pedidos.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void mouseReleased(MouseEvent me) {

      }

      @Override
      public void mouseEntered(MouseEvent me) {

      }

      @Override
      public void mouseExited(MouseEvent me) {
        pedidos.setBackground(Color.WHITE);
      }
    };
    pedidos.addMouseListener(primerClick);

  }

  private void oyenteCumplidos() {
    MouseListener primerClick = new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {

        String[][] matriz = new String[40][40];

        String id_almacen = "0";
        String tipo_almacen = "0";
        String cantidad_almacen = "0";
        String precio_almacen = "0";

        Conexion primera = new Conexion("prueba3");

        PilaC contenedor = new PilaC();
        Pila id_pedido = new Pila();
        Pila cantidad = new Pila();
        Pila precio = new Pila();
        PilaC tipo_plato = new PilaC();

        PilaC contenedor2 = new PilaC();
        Pila id_pedido2 = new Pila();
        Pila cantidad2 = new Pila();
        Pila precio2 = new Pila();
        PilaC tipo_plato2 = new PilaC();

        Statement st;
        ResultSet rs;

        try {
          st = primera.conectart().createStatement();
          rs = st.executeQuery("select * from registro");

          while (rs.next()) {
            // System.out.println(rs.getInt("id_pedido")+" "+ rs.getString("tipo_plato")+"
            // "+ rs.getInt("cantidad")+" "+ rs.getInt("precio"));

            if (!rs.getBoolean("estado")) {
              id_pedido.adicionar(rs.getInt("id_registro"));
              tipo_plato.adicionar(rs.getString("tipo_plato"));
              cantidad.adicionar(rs.getInt("cantidad"));
              precio.adicionar(rs.getInt("precio"));
            } else {
              id_pedido2.adicionar(rs.getInt("id_registro"));
              tipo_plato2.adicionar(rs.getString("tipo_plato"));
              cantidad2.adicionar(rs.getInt("cantidad"));
              precio2.adicionar(rs.getInt("precio"));
            }

          }
        } catch (Exception e) {
          // TODO: handle exception
        }
        int tok = 0;
        while (!id_pedido.esVacia()) {
          id_almacen = String.valueOf(id_pedido.eliminar());
          tipo_almacen = tipo_plato.eliminar();
          cantidad_almacen = String.valueOf(cantidad.eliminar());
          precio_almacen = String.valueOf(precio.eliminar());

          String[] matsuma = { id_almacen, tipo_almacen, cantidad_almacen, precio_almacen };

          matriz[tok] = matsuma;
          tok = tok + 1;

        }
        // panel1 pan = new panel1();
        // pan.setSize(970, 657);
        // pan.setLocation(0, 0);
        panel_1_init.removeAll();
        // panel_1_init.add(pan, BorderLayout.CENTER);
        panel_1_init.revalidate();
        panel_1_init.repaint();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id");
        model.addColumn("tipo de plato");
        model.addColumn("cantidad");
        model.addColumn("precio");

        // String[][] matriz = {{"1","POLLO ECONOMICO","3","30"},{"2","POLLO
        // ENTERO","1","80"}};

        for (int i = 0; i < 38; i++) {
          model.addRow(matriz[i]);
        }

        JTable dado = new JTable(model);
        dado.setBounds(10, 10, 940, 640);

        panel_1_init.add(dado);

        JScrollPane scroll = new JScrollPane(dado, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(10, 10, 940, 640);

        panel_1_init.add(scroll);
        panel_1_init.revalidate();
        panel_1_init.repaint();

      }

      @Override
      public void mousePressed(MouseEvent me) {
        eliminados.setBackground(Color.LIGHT_GRAY);
      }

      @Override
      public void mouseReleased(MouseEvent me) {

      }

      @Override
      public void mouseEntered(MouseEvent me) {

      }

      @Override
      public void mouseExited(MouseEvent me) {
        eliminados.setBackground(Color.WHITE);
      }
    };
    eliminados.addMouseListener(primerClick);
  }

  public String fechaReturn() {

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
    String fecha2 = dtf.format(LocalDateTime.now());

    return fecha2;
  }

  public void botones() {
    JButton eliminar = new JButton();
    JTextArea nota_mora = new JTextArea();
    // scroll.setBounds(10,10, 840, 640);

    eliminar.setLayout(null);
    eliminar.setOpaque(false);
    eliminar.setSize(30, 300);
    eliminar.setBounds(855, 10, 110, 40);
    eliminar.setVisible(true);

    eliminar.setOpaque(false);
    eliminar.setText("Eliminar");
    eliminar.setForeground(Color.WHITE);
    //eliminar.setBorderPainted(false);
    eliminar.setFocusable(false);
    eliminar.setVisible(true);
    eliminar.setBackground(Color.WHITE);
    eliminar.setFont(new Font("arial", Font.BOLD, 15));
    eliminar.setBorder(BorderFactory.createLineBorder(mostazaBorder, 2, false));

    eliminar.setForeground(Color.black);
    eliminar.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {
        // parte de la base de datos
        Conexion segunda = new Conexion("prueba3");
        Statement st2;
        ResultSet rs2, rs3;
        int contador = 0;
        try {
          st2 = segunda.conectart().createStatement();
          rs2 = st2.executeQuery("select * from registro");

          while (rs2.next()) {
            // System.out.println(rs.getInt("id_pedido")+" "+ rs.getString("tipo_plato")+"
            // "+ rs.getInt("cantidad")+" "+ rs.getInt("precio"));

            if (rs2.getBoolean("estado")) {
              
              st2.executeUpdate("UPDATE registro SET estado=0 WHERE id_registro=" + (contador + 1) + " AND estado=1");

              JOptionPane.showMessageDialog(null, "El pedido se elimino con exito");

              break;
            } else {
              contador = contador + 1;
            }

          }
        } catch (Exception e) {
          // TODO: handle exception
        }

        String[][] matriz = new String[40][40];

        String id_almacen = "0";
        String tipo_almacen = "0";
        String cantidad_almacen = "0";
        String precio_almacen = "0";

        Conexion primera = new Conexion("prueba3");

        PilaC contenedor = new PilaC();
        Pila id_pedido = new Pila();
        Pila cantidad = new Pila();
        Pila precio = new Pila();
        PilaC tipo_plato = new PilaC();

        PilaC contenedor2 = new PilaC();
        Pila id_pedido2 = new Pila();
        Pila cantidad2 = new Pila();
        Pila precio2 = new Pila();
        PilaC tipo_plato2 = new PilaC();

        Statement st;
        ResultSet rs;

        try {
          st = primera.conectart().createStatement();
          rs = st.executeQuery("select * from registro");

          while (rs.next()) {
            // System.out.println(rs.getInt("id_pedido")+" "+ rs.getString("tipo_plato")+"
            // "+ rs.getInt("cantidad")+" "+ rs.getInt("precio"));

            if (rs.getBoolean("estado")) {
              id_pedido.adicionar(rs.getInt("id_registro"));
              tipo_plato.adicionar(rs.getString("tipo_plato"));
              cantidad.adicionar(rs.getInt("cantidad"));
              precio.adicionar(rs.getInt("precio"));
            } else {
              id_pedido2.adicionar(rs.getInt("id_registro"));
              tipo_plato2.adicionar(rs.getString("tipo_plato"));
              cantidad2.adicionar(rs.getInt("cantidad"));
              precio2.adicionar(rs.getInt("precio"));
            }

          }
        } catch (Exception e) {
          // TODO: handle exception
        }
        int tok = 0;
        while (!id_pedido.esVacia()) {
          id_almacen = String.valueOf(id_pedido.eliminar());
          tipo_almacen = tipo_plato.eliminar();
          cantidad_almacen = String.valueOf(cantidad.eliminar());
          precio_almacen = String.valueOf(precio.eliminar());

          String[] matsuma = { id_almacen, tipo_almacen, cantidad_almacen, precio_almacen };

          matriz[tok] = matsuma;
          tok = tok + 1;

        }

        panel_1_init.removeAll();

        panel_1_init.revalidate();
        panel_1_init.repaint();

        DefaultTableModel model = new DefaultTableModel();

        model.addColumn("id");
        model.addColumn("tipo de plato");
        model.addColumn("cantidad");
        model.addColumn("precio");

        for (int i = 0; i < 38; i++) {
          model.addRow(matriz[i]);
        }

        JTable dado = new JTable(model);
        // dado.setBounds(10, 10, 840, 640);

        dado.setBounds(10, 10, 840, 640);

        dado.setEnabled(false);
        botones();
        // panel_1_init.add(dado);

        JScrollPane scroll = new JScrollPane(dado, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        // scroll.setBounds(10, 10, 940, 640);
        scroll.setBounds(10, 10, 840, 640);

        panel_1_init.add(scroll);
        panel_1_init.revalidate();
        panel_1_init.repaint();

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

    panel_1_init.add(eliminar);

    JButton guardar = new JButton();

    // scroll.setBounds(10,10, 840, 640);

    guardar.setLayout(null);
    guardar.setOpaque(false);
    guardar.setSize(30, 300);
    guardar.setBounds(855, 60, 110, 40);
    guardar.setVisible(true);

    guardar.setOpaque(false);
    guardar.setText("Guardar");
    guardar.setForeground(Color.black);
    //guardar.setBorderPainted(false);
    guardar.setFocusable(false);
    guardar.setVisible(true);

    guardar.setBackground(Color.WHITE);
    guardar.setFont(new Font("arial", Font.BOLD, 15));
    guardar.setBorder(BorderFactory.createLineBorder(mostazaBorder, 2, false));

    guardar.setForeground(Color.black);

    guardar.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent me) {
        // parte de la base de datos
        File archivo;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        fecha = fechaReturn();
        try {
          archivo = new File("/home/kali/Desktop/registro" + fecha + ".csv");

          w = new FileWriter(archivo);
          bw = new BufferedWriter(w);
          wr = new PrintWriter(bw);

          Conexion primera = new Conexion("prueba3");

          Statement st;
          ResultSet rs;
          wr.write("ID   ,PLATO PEDIDO   ,CANTIDAD PEDIDA    ,PRECIO   \n");
          try {
            st = primera.conectart().createStatement();
            rs = st.executeQuery("select * from registro");

            while (rs.next()) {
              // System.out.println(rs.getInt("id_pedido")+" "+ rs.getString("tipo_plato")+"
              // "+ rs.getInt("cantidad")+" "+ rs.getInt("precio"));
              wr.append(rs.getString("id_registro") + "," + rs.getString("tipo_plato") + "," + rs.getString("cantidad")
                  + "," + rs.getString("precio") + " Bs\n");

            }
          } catch (Exception e) {
            // TODO: handle exception
          }

          try {
            String cmd = "libreoffice /home/kali/Desktop/registro" + fecha + ".csv";
            Runtime.getRuntime().exec(cmd);
          } catch (IOException ioe) {
            System.out.println(ioe);
          }

          wr.close();
          bw.close();
          JOptionPane.showMessageDialog(null, "Se creo su archivo en el\n escritorio");

        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "A ocurrido un error " + e);
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

    panel_1_init.add(guardar);

    nota_mora.setBounds(855, 110, 110, 400);

    nota_mora.setLayout(null);

    nota_mora.setVisible(true);
    nota_mora.setLayout(null);
    nota_mora.setOpaque(true);
    nota_mora.setBackground(mostazaClaro);

    nota_mora.setForeground(Color.black);

    panel_1_init.add(nota_mora);

    JLabel mensaje = new JLabel();

    mensaje.setLayout(null);
    mensaje.setBounds(855, 550, 110, 100);

    mensaje.setText("Admin Acces");
    mensaje.setBackground(Color.GRAY);
    mensaje.setForeground(Color.white);
    mensaje.setVisible(true);
    mensaje.setLayout(null);
    mensaje.setHorizontalAlignment(SwingConstants.CENTER);
    mensaje.setOpaque(true);

    JLabel mensaje2 = new JLabel();

    panel_1_init.add(mensaje);
    mensaje2.setLayout(null);
    mensaje2.setBounds(855, 490, 110, 50);

    mensaje2.setText("mora");
    mensaje2.setBackground(mostazaClaro);
    mensaje2.setForeground(Color.white);
    mensaje2.setVisible(true);
    mensaje2.setLayout(null);
    mensaje2.setHorizontalAlignment(SwingConstants.CENTER);
    mensaje2.setOpaque(true);

    panel_1_init.add(mensaje2);

    // Evento de eliminar

  }

}