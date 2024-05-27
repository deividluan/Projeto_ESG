package src.view;

import src.controller.SetorController;
import src.model.LixoCalculator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class SetorScreen extends JFrame {
    private JTextField num1, num2, num3, num4, num5, num6, num7, num8, num9, num10;
    private SetorController controller;

    public SetorScreen() {
        LixoCalculator calculator = new LixoCalculator();
        controller = new SetorController(calculator);

        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle("Coleta de Lixo por Setor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel titleLabel = new JLabel("Coleta de Lixo por Setor");
        titleLabel.setBounds(530, 30, 500, 50);
        titleLabel.setFont(new Font("Negrito", Font.PLAIN, 30));
        add(titleLabel);

        num1 = new JTextField("10");
        num1.setBounds(489, 130, 190, 50);
        num1.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num1);

        num2 = new JTextField("10");
        num2.setBounds(700, 130, 190, 50);
        num2.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num2);

        num3 = new JTextField("10");
        num3.setBounds(489, 205, 190, 50);
        num3.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num3);

        num4 = new JTextField("10");
        num4.setBounds(700, 205, 190, 50);
        num4.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num4);

        num5 = new JTextField("10");
        num5.setBounds(489, 280, 190, 50);
        num5.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num5);

        num6 = new JTextField("10");
        num6.setBounds(700, 280, 190, 50);
        num6.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num6);

        num7 = new JTextField("10");
        num7.setBounds(489, 355, 190, 50);
        num7.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num7);

        num8 = new JTextField("10");
        num8.setBounds(700, 355, 190, 50);
        num8.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num8);

        num9 = new JTextField("10");
        num9.setBounds(489, 430, 190, 50);
        num9.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num9);

        num10 = new JTextField("10");
        num10.setBounds(700, 430, 190, 50);
        num10.setFont(new Font("Arial", Font.ITALIC, 12));
        add(num10);

        addLabel("Almoxarifado", 489, 95);
        addLabel("RH", 700, 95);
        addLabel("CME", 489, 170);
        addLabel("Faturamento", 700, 170);
        addLabel("Juridico", 489, 245);
        addLabel("TI", 700, 245);
        addLabel("Higiene", 489, 320);
        addLabel("SESMT", 700, 320);
        addLabel("Fabricação", 489, 395);
        addLabel("Laboratório", 700, 395);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.setBounds(490, 510, 400, 70);
        calculateButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        calculateButton.setForeground(new Color(255, 255, 255));
        calculateButton.setBackground(new Color(11, 10, 10));
        add(calculateButton);

        calculateButton.addActionListener(e -> {
            int[] valores = getSectorValues();
            int total = controller.calcularTotalLixo(valores);
            JOptionPane.showMessageDialog(null, "Total de lixo gerado pelos setores: " + total + " Kg", "Total de Lixo", JOptionPane.INFORMATION_MESSAGE);
        });

        JButton backButton = new JButton("Voltar");
        backButton.setBounds(25, 590, 250, 70);
        backButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setBackground(new Color(255, 0, 0));
        backButton.addActionListener(e -> {
            dispose();
            new src.view.Screen();
        });
        add(backButton);

        JButton graphButton = new JButton("Gerar Gráfico");
        graphButton.setBounds(490, 590, 400, 70);
        graphButton.setFont(new Font("Arial", Font.CENTER_BASELINE, 30));
        graphButton.setForeground(new Color(255, 255, 255));
        graphButton.setBackground(new Color(0, 123, 255));
        graphButton.addActionListener(e -> gerarGraficoPizza());
        add(graphButton);
    }

    private JTextField[] getSectorFields() {
        return new JTextField[]{num1, num2, num3, num4, num5, num6, num7, num8, num9, num10};
    }

    private int[] getSectorValues() {
        JTextField[] fields = getSectorFields();
        int[] values = new int[fields.length];
        for (int i = 0; i < fields.length; i++) {
            values[i] = Integer.parseInt(fields[i].getText());
        }
        return values;
    }

    private void addLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 190, 50);
        add(label);
    }

    private void gerarGraficoPizza() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        String[] setores = {"Almoxarifado", "RH", "CME", "Faturamento", "Juridico", "TI", "Higiene", "SESMT", "Fabricação", "Laboratório"};
        int[] valores = getSectorValues();

        for (int i = 0; i < valores.length; i++) {
            dataset.setValue(setores[i], valores[i]);
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Distribuição de Lixo por Setor",
                dataset,
                true,
                true,
                false
        );

        ChartPanel chartPanel = new ChartPanel(chart);
        JFrame chartFrame = new JFrame("Gráfico de Pizza");
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.setSize(800, 600);
        chartFrame.add(chartPanel);
        chartFrame.setLocationRelativeTo(null);
        chartFrame.setVisible(true);
    }
}
