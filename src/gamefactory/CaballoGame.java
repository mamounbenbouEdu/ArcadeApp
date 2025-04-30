package gamefactory;

import javax.swing.*;

public class CaballoGame implements Game {
    @Override
    public JPanel getGamePanel() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Aquí va el juego del Caballo"));
        return panel;
    }
}
