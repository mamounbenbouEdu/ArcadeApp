package gamefactory;

import javax.swing.*;

public class NReinasGame implements Game {
    @Override
    public JPanel getGamePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Aquí va el juego de N Reinas"));
        return panel;
    }
}
