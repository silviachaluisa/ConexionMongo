import javax.swing.*;

public class Main {
    public static  void main (String[] args){
        JFrame frame=new JFrame("Bienvenido");
        frame.setContentPane(new Form1().Registro);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
