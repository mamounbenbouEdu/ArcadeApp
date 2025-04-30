package gamefactory;

import javax.swing.*;

public class HanoiGame implements Game {
    @Override
    public JPanel getGamePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Aquí va el juego de Torres de Hanói"));
        return panel;
    }
}
