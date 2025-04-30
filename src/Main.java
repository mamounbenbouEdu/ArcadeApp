import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gamefactory.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainMenu();
        });
    }
}

class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Máquina Arcade de Lógica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // Centrar ventana

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JLabel label = new JLabel("Selecciona un juego:", SwingConstants.CENTER);
        panel.add(label);

        JButton btnNReinas = new JButton("N Reinas");
        JButton btnCaballo = new JButton("Recorrido del Caballo");
        JButton btnHanoi = new JButton("Torres de Hanói");

        panel.add(btnNReinas);
        panel.add(btnCaballo);
        panel.add(btnHanoi);

        btnNReinas.addActionListener(e -> openGame("NReinas"));
        btnCaballo.addActionListener(e -> openGame("Caballo"));
        btnHanoi.addActionListener(e -> openGame("Hanoi"));


        add(panel);
        setVisible(true);
    }

    private void openGame(String gameType) {
        gamefactory.Game juego = gamefactory.GameFactory.createGame(gameType);
        if (juego != null) {
            JFrame ventanaJuego = new JFrame("Juego: " + gameType);
            ventanaJuego.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            ventanaJuego.setSize(500, 500);
            ventanaJuego.setLocationRelativeTo(null);
            ventanaJuego.add(juego.getGamePanel());
            ventanaJuego.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Juego no encontrado.");
        }
    }

}
