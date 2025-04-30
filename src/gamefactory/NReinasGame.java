package gamefactory;

import javax.swing.*;
import java.awt.*;
import persistence.Resultado;
import persistence.ResultadoDAO;

public class NReinasGame implements Game {
    private JPanel mainPanel;
    private JTextField inputField;
    private JButton solveButton;
    private JPanel boardPanel;

    @Override
    public JPanel getGamePanel() {
        mainPanel = new JPanel(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Tamaño del tablero (N):"));
        inputField = new JTextField("8", 5);
        solveButton = new JButton("Resolver");
        topPanel.add(inputField);
        topPanel.add(solveButton);

        mainPanel.add(topPanel, BorderLayout.NORTH);

        boardPanel = new JPanel();
        mainPanel.add(boardPanel, BorderLayout.CENTER);

        solveButton.addActionListener(e -> {
            try {
                int n = Integer.parseInt(inputField.getText());
                int[] solution = solveNQueens(n);
                drawBoard(n, solution);

                boolean resuelto = solution != null;
                Resultado res = new Resultado("N Reinas", "N = " + n, resuelto, n);
                ResultadoDAO.guardar(res);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Introduce un número válido.");
            }
        });

        return mainPanel;
    }

    private void drawBoard(int n, int[] solution) {
        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(n, n));

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (solution != null && solution[row] == col) {
                    cell.add(new JLabel("♛"));
                }
                boardPanel.add(cell);
            }
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }

    private int[] solveNQueens(int n) {
        int[] queens = new int[n];
        if (placeQueen(queens, 0, n)) return queens;
        return null;
    }

    private boolean placeQueen(int[] queens, int row, int n) {
        if (row == n) return true;
        for (int col = 0; col < n; col++) {
            if (isSafe(queens, row, col)) {
                queens[row] = col;
                if (placeQueen(queens, row + 1, n)) return true;
            }
        }
        return false;
    }

    private boolean isSafe(int[] queens, int row, int col) {
        for (int i = 0; i < row; i++) {
            int qCol = queens[i];
            if (qCol == col || Math.abs(qCol - col) == Math.abs(i - row)) {
                return false;
            }
        }
        return true;
    }
}
