package gamefactory;

import javax.swing.*;
import java.awt.*;
import persistence.Resultado;
import persistence.ResultadoDAO;

public class CaballoGame implements Game {
    private JPanel mainPanel;
    private JTextField inputField;
    private JButton solveButton;
    private JPanel boardPanel;
    private final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

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
                int[][] solution = solveKnightTour(n);
                drawBoard(n, solution);

                boolean resuelto = solution != null;
                int pasos = resuelto ? n * n : 0;
                Resultado res = new Resultado("Caballo", "Tablero N = " + n, resuelto, pasos);
                ResultadoDAO.guardar(res);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(mainPanel, "Introduce un número válido.");
            }
        });

        return mainPanel;
    }

    private void drawBoard(int n, int[][] solution) {
        boardPanel.removeAll();
        boardPanel.setLayout(new GridLayout(n, n));

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (solution != null && solution[row][col] > 0) {
                    cell.add(new JLabel(String.valueOf(solution[row][col])));
                }
                boardPanel.add(cell);
            }
        }

        boardPanel.revalidate();
        boardPanel.repaint();
    }

    private int[][] solveKnightTour(int n) {
        int[][] board = new int[n][n];
        board[0][0] = 1;
        if (solve(board, 0, 0, 2, n)) return board;
        return null;
    }

    private boolean solve(int[][] board, int x, int y, int move, int n) {
        if (move > n * n) return true;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny, board, n)) {
                board[nx][ny] = move;
                if (solve(board, nx, ny, move + 1, n)) return true;
                board[nx][ny] = 0;
            }
        }
        return false;
    }

    private boolean isValid(int x, int y, int[][] board, int n) {
        return x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0;
    }
}
