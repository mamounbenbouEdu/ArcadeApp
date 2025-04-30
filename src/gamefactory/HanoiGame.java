package gamefactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import persistence.Resultado;
import persistence.ResultadoDAO;

public class HanoiGame implements Game {
    private JPanel mainPanel;
    private JTextField inputField;
    private JButton solveButton;
    private JTextArea resultArea;

    @Override
    public JPanel getGamePanel() {
        mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Número de discos:"));
        inputField = new JTextField("3", 5);
        solveButton = new JButton("Resolver");
        topPanel.add(inputField);
        topPanel.add(solveButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        resultArea = new JTextArea(15, 30);
        resultArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        solveButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());
                if (n < 1 || n > 8) {
                    JOptionPane.showMessageDialog(mainPanel, "Ingresa un número entre 1 y 8.");
                    return;
                }

                resultArea.setText("");
                List<String> pasos = new ArrayList<>();
                hanoi(n, "A", "C", "B", pasos);
                for (String paso : pasos) resultArea.append(paso + "\n");

                int totalMov = (int) Math.pow(2, n) - 1;
                resultArea.append("\nTotal de movimientos: " + totalMov);

                Resultado res = new Resultado("Hanoi", "Discos = " + n, true, totalMov);
                ResultadoDAO.guardar(res);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Introduce un número válido.");
            }
        });

        return mainPanel;
    }

    private void hanoi(int n, String origen, String destino, String auxiliar, List<String> pasos) {
        if (n == 1) {
            pasos.add("Mover disco 1 de " + origen + " a " + destino);
        } else {
            hanoi(n - 1, origen, auxiliar, destino, pasos);
            pasos.add("Mover disco " + n + " de " + origen + " a " + destino);
            hanoi(n - 1, auxiliar, destino, origen, pasos);
        }
    }
}
