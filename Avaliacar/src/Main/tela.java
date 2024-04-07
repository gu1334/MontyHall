package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class tela extends JFrame {

    private JPanel painel = new JPanel();
    private Button JButtonJogar = new Button("Jogar");

    public tela() {
        this.setTitle("MontyHallGUI");
        this.setSize(200, 150);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 40));
        painel.setBackground(new Color(255, 255, 255));
        JButtonJogar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jogar();
            }
        });
        painel.add(JButtonJogar);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

    }

    private static void jogar() {
        String portaEscolhidaStr = JOptionPane.showInputDialog(null, "Escolha uma porta (1, 2 ou 3):");
        int portaEscolhida = Integer.parseInt(portaEscolhidaStr);

        if (portaEscolhida < 1 || portaEscolhida > 3) {
            JOptionPane.showMessageDialog(null, "Opção inválida. Digite uma opção válida.");
        } else {
            Random random = new Random();
            int portaPremiada = random.nextInt(3) + 1;
            int portaVazia = -1;
            do {
                portaVazia = random.nextInt(3) + 1;
            } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);

            JOptionPane.showMessageDialog(null, "O apresentador abriu a porta: " + portaVazia + " que está vazia.");

            String opcao = JOptionPane.showInputDialog(null, "Deseja mudar de porta? (sim ou não)");
            boolean trocarPorta = opcao != null && opcao.equalsIgnoreCase("sim");

            int portaEscolhidaOriginal = portaEscolhida;
            if (trocarPorta) {
                do {
                    portaEscolhida = random.nextInt(3) + 1;
                } while (portaEscolhida == portaVazia || portaEscolhida == portaEscolhidaOriginal);

                if (portaEscolhida == portaPremiada) {
                    JOptionPane.showMessageDialog(null, "Parabéns, você ganhou o prêmio!");
                } else {
                    JOptionPane.showMessageDialog(null, "Infelizmente, você não ganhou o prêmio.");
                }
            } else {
                if (portaEscolhida == portaPremiada) {
                    JOptionPane.showMessageDialog(null, "Parabéns, você ganhou o prêmio!");
                } else {
                    JOptionPane.showMessageDialog(null, "Infelizmente, você não ganhou o prêmio.");
                }
            }
        }
    }

    public static void main(String[] args) {
        new tela();
    }
}



