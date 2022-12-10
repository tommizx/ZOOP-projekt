import Stages.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        do {
            if (game.gameStageString.equals("start") || game.gameStageString.equals("logout")) {
                game.userLoginStage();
            }
            if (game.gameStageString.equals("start") || game.gameStageString.equals("logout") || game.gameStageString.equals("selection")) {
                game.categorySelectionStage();
            }
            game.gameStage();
        } while (!(game.gameStageString.equals("exit")));
    }
}