package src.view;

import src.view.Grafico;
import src.view.SetorScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Screen extends JFrame implements ActionListener {

    JTextField num1, num2, num3, num4, num5, num6, num7, num8, num9, num10, num11, num12;

    // Criação do Frame
    public Screen() {
        setVisible(true);
        setSize(1200, 800);
        setTitle("Projeto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

        // Crianção do Botão
        JButton jButton = new JButton("Calcule Anualmente");
        jButton.setBounds(490, 475, 350, 70);
        jButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        jButton.setForeground(new Color(255, 255, 255));
        jButton.setBackground(new Color(11, 10, 10));
        add(jButton);

        // Crianção do Botão Gráfico
        JButton BGrafico = new JButton("Gerar Grafico");
        BGrafico.setBounds(490, 575, 350, 70);
        BGrafico.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        BGrafico.setForeground(new Color(255, 255, 255));
        BGrafico.setBackground(new Color(0, 123, 255));
        add(BGrafico);

        // Crição do Botão de Continue
        JButton BContinue = new JButton("Continue >");
        BContinue.setBounds(1075, 575, 250, 70);
        BContinue.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        BContinue.setForeground(new Color(255, 255, 255));
        BContinue.setBackground(new Color(47, 234, 47));
        add(BContinue);

        // Ação do botão Grafico
        jButton.addActionListener(this);
        BGrafico.addActionListener(e -> {
            SwingUtilities.invokeLater(() -> {
                src.view.Grafico grafico = new src.view.Grafico(getMonthlyValues(), getMetaValues());
                grafico.setVisible(true);
            });
        });

        // Ação do botão Continue
        BContinue.addActionListener(e -> {
            new src.view.SetorScreen();
            this.dispose();
        });

        // Criando caixas de texto
        num1 = new JTextField("100");
        num1.setBounds(475, 390, 190, 50);
        num1.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num1);

        num2 = new JTextField("100");
        num2.setBounds(675, 390, 190, 50);
        num2.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num2);

        num3 = new JTextField("100");
        num3.setBounds(875, 390, 190, 50);
        num3.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num3);

        num4 = new JTextField("100");
        num4.setBounds(275, 390, 190, 50);
        num4.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num4);

        num5 = new JTextField("100");
        num5.setBounds(275, 290, 190, 50);
        num5.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num5);

        num6 = new JTextField("100");
        num6.setBounds(475, 290, 190, 50);
        num6.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num6);

        num7 = new JTextField("100");
        num7.setBounds(675, 290, 190, 50);
        num7.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num7);

        num8 = new JTextField("100");
        num8.setBounds(875, 290, 190, 50);
        num8.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num8);

        num9 = new JTextField("100");
        num9.setBounds(875, 190, 190, 50);
        num9.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num9);

        num10 = new JTextField("100");
        num10.setBounds(675, 190, 190, 50);
        num10.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num10);

        num11 = new JTextField("100");
        num11.setBounds(475, 190, 190, 50);
        num11.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num11);

        num12 = new JTextField("100");
        num12.setBounds(275, 190, 190, 50);
        num12.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num12);

        // Nome dos meses
        addLabel("Janeiro", 345, 150);
        addLabel("Fevereiro", 540, 150);
        addLabel("Março", 745, 150);
        addLabel("Abril", 950, 150);
        addLabel("Maio", 355, 250);
        addLabel("Junho", 550, 250);
        addLabel("Julho", 750, 250);
        addLabel("Agosto", 945, 250);
        addLabel("Setembro", 345, 350);
        addLabel("Outubro", 545, 350);
        addLabel("Novembro", 735, 350);
        addLabel("Dezembro", 935, 350);

        // Titulo
        JLabel Titulo = new JLabel("Vamos calcular a geração de lixo");
        Titulo.setBounds(450, 50, 700, 50);
        Titulo.setFont(new Font("Negrito", Font.PLAIN, 30));
        add(Titulo);

        // Subtitulo
        JLabel Subtitulo = new JLabel("Meta anual: 1000 Kg");
        Subtitulo.setBounds(590, 80, 190, 50);
        Subtitulo.setFont(new Font("Negrito", Font.PLAIN, 14));
        add(Subtitulo);
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 190, 50);
        add(label);
    }

    // Inserção valor digitado pelo usuario na variavel
    private Integer[] getMonthlyValues() {
        return new Integer[]{
                Integer.parseInt(num1.getText()), Integer.parseInt(num2.getText()), Integer.parseInt(num3.getText()),
                Integer.parseInt(num4.getText()), Integer.parseInt(num5.getText()), Integer.parseInt(num6.getText()),
                Integer.parseInt(num7.getText()), Integer.parseInt(num8.getText()), Integer.parseInt(num9.getText()),
                Integer.parseInt(num10.getText()), Integer.parseInt(num11.getText()), Integer.parseInt(num12.getText())
        };
    }

    private Integer[] getMetaValues() {
        // Retornando os valores de meta definidos
        return new Integer[]{100, 200, 150, 180, 220, 210, 190, 230, 240, 250, 270, 300};
    }

    // Frame mostrando a media dos valores
    @Override
    public void actionPerformed(ActionEvent e) {
        Integer[] nums = getMonthlyValues();
        int soma = 0;
        for (int num : nums) {
            soma += num;
        }
        int calcular = soma / nums.length;
        JOptionPane.showMessageDialog(null, "Baseado na meta, a sua geração de lixo Anualmente foi: " + calcular + " Toneladas", "Geração De Lixo", JOptionPane.INFORMATION_MESSAGE);
    }
}
