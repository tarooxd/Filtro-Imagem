package SortingVisualizer;

import sorters.BubbleSort;
import sorters.SortAlgorithm;

import javax.swing.*;
import java.awt.*;

public class SortingVisualizer extends JPanel {
    private int[] array;
    private SortAlgorithm sortAlgorithm; // Adiciona a interface de ordenação

    public SortingVisualizer(int[] array) {
        this.array = array;
        setPreferredSize(new Dimension(1280, 720));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;
        int maxValue = getMaxValue(array); // Obtém o valor máximo do array
        int minValue = getMinValue(array);
        int midY = getHeight() / 2; // Posição do eixo vertical no meio do painel

        for (int i = 0; i < array.length; i++) {
            int height = (int) ((array[i] / (double) maxValue) * (getHeight() / 2)); // Altura proporcional ao eixo

            g.setColor(getColorForValue(array[i], maxValue, minValue));

            if (array[i] >= 0) {
                g.fillRect(i * width, midY - height, width, height); // Acima do eixo
            } else {
                g.fillRect(i * width, midY, width, -height); // Abaixo do eixo
            }

            g.setColor(Color.BLACK); // Garante que o texto fique visível em preto
            g.drawString(String.valueOf(array[i]), i * width + (width / 2) - 10, midY + 15);
        }
    }

    private int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int value : array) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }

    private int getMinValue(int[] array) {
        int minValue = array[0];
        for (int value : array) {
            if (value < minValue) {
                minValue = value;
            }
        }
        return minValue;
    }

    private Color getColorForValue(int value, int maxValue, int minValue) {
        float hue;
        if (value >= 0) {
            hue = (float) (0.15 * value) / (maxValue) + 0.20f;
        } else {
            hue = (float) (0.15f - (Math.abs(value) * 0.15) / Math.abs(minValue));
        }
        return Color.getHSBColor(hue, 0.85f, 0.85f);
    }

    public void updateArray(int[] newArray) {
        this.array = newArray;
        repaint(); // Solicita a atualização da interface gráfica
    }

    public void sortAndVisualize(SortAlgorithm algorithm) {
        new Thread(() -> {
            algorithm.sort(array, this);
        }).start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sorting Visualizer");
        int[] array = {100, -200, 50, -150, 250, -175, 125, 10, 20, 50, 80, 50, 80, 80, 85, 74, 34, 240, 230, 220, -10, -20};

        SortingVisualizer visualizer = new SortingVisualizer(array);


        frame.add(visualizer);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Escolha o algoritmo de ordenação a ser usado
        SortAlgorithm algorithm = new BubbleSort(); // Ou qualquer implementação de sort

        // Inicia o processo de ordenação e visualização
        visualizer.sortAndVisualize(algorithm);
    }
}
