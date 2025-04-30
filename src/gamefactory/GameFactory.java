package gamefactory;

public class GameFactory {

    public static Game createGame(String gameType) {
        return switch (gameType) {
            case "NReinas" -> new NReinasGame();
            case "Caballo" -> new CaballoGame();
            case "Hanoi" -> new HanoiGame();
            default -> null;
        };
    }
}
