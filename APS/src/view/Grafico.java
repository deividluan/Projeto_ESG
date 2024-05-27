package src.view;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.*;

public class Grafico extends JFrame {
    private Integer[] valoresReais;
    private Integer[] metas;

    public Grafico(Integer[] valoresReais, Integer[] metas) {
        this.valoresReais = valoresReais;
        this.metas = metas;
        initUI();
    }

    private void initUI() {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setSize(800, 600);
        this.setTitle("Gráfico");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Platform.runLater(() -> {
            Scene scene = createScene();
            fxPanel.setScene(scene);
        });
    }

    private Scene createScene() {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Meses");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Valores");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Meta");
        String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
        for (int i = 0; i < metas.length; i++) {
            series1.getData().add(new XYChart.Data<>(months[i], metas[i]));
        }

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Valores Reais");
        for (int i = 0; i < valoresReais.length; i++) {
            series2.getData().add(new XYChart.Data<>(months[i], valoresReais[i]));
        }

        barChart.getData().addAll(series1, series2);
        return new Scene(barChart, 800, 600);
    }
}
