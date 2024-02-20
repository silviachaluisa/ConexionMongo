import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Form1 {
    JPanel Registro;
    private JButton ingresarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton borrarButton;
    private JButton actualizarButton;
    private JTextField textField4;
    private String CampoaBorrar="";
    ConexionMongoDB mongo;

    public Form1() {

        // Asignar un nombre a los campos
        textField1.setName("Nombre");
        textField2.setName("Materia");
        textField3.setName("Calificacion");
        textField4.setName("Codigo_Unico");


        // Capturas el campo con foco
        textField1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                CampoaBorrar=textField1.getName();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                CampoaBorrar=textField2.getName();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        textField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                CampoaBorrar=textField3.getName();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        textField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                CampoaBorrar=textField4.getName();
            }

            @Override
            public void focusLost(FocusEvent e) {

            }
        });

        mongo = new ConexionMongoDB("mongodb://localhost:27017");
        mongo.getAcceso("Registros", "Registros1");
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document documento = new Document("Codigo_Unico", textField4.getText())
                        .append("Nombre", textField1.getText())
                        .append("Materia", textField2.getText())
                        .append("Calificacion", textField3.getText());
                mongo.Insertar_documento(documento);
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Nombre=textField1.getText();
                String Materia=textField2.getText();
                String Calif=textField3.getText();
                String Codigo=textField4.getText();
                // Comprobar el campo con foco
                if (CampoaBorrar.equals("Nombre")){
                    if (!Nombre.isEmpty()){
                        textField1.setText(Nombre.substring(0, Nombre.length()-1));
                    }
                }

                if (CampoaBorrar.equals("Materia")){
                    if (!Materia.isEmpty()){
                        textField2.setText(Materia.substring(0, Materia.length()-1));
                    }
                }

                if (CampoaBorrar.equals("Calificacion")){
                    if (!Calif.isEmpty()){
                        textField3.setText(Calif.substring(0, Calif.length()-1));
                    }
                }

                if (CampoaBorrar.equals("Codigo_Unico")){
                    if (!Codigo.isEmpty()){
                        textField4.setText(Codigo.substring(0, Codigo.length()-1));
                    }
                }
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filtro = textField4.getText();
                String Calificacion = textField3.getText();

                mongo.Actualizar_documento(filtro, Calificacion);
            }
        });
    }
}
