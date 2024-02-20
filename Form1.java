import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form1 {
    JPanel Registro;
    private JButton ingresarButton;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton borrarButton;
    ConexionMongoDB mongo;

    public Form1() {
        mongo = new ConexionMongoDB("mongodb://localhost:27017");
        mongo.getAcceso("Registros", "Registros1");
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Document documento = new Document("Nombre", textField1.getText())
                        .append("Materia", textField2.getText())
                        .append("Calificacion", textField3.getText());
                mongo.Insertar_documento(documento);
            }
        });
    }
}
