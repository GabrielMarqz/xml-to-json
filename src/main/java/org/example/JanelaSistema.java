package org.example;

import javax.swing.*;
import java.awt.*;

public class JanelaSistema extends JFrame {

    /*public String resultadoDoEnvio(){
        String valorDoEnvio = "Teste";
        return valorDoEnvio;
    }*/

    private JLabel armazenandoTexto;
    public JanelaSistema(String retorno){
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("COTRAMOL");
        setLocationRelativeTo(null);
        setLayout(new FlowLayout(FlowLayout.RIGHT, 100, 100));
        armazenandoTexto = new JLabel();
        add(armazenandoTexto);
        setVisible(true);
        armazenandoTexto.setText(retorno);
    }
}
