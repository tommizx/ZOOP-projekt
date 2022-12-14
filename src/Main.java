import Stages.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        do {
            if (game.gameStageString.equals("admin")){
                game.adminStage();
            }
            if (game.gameStageString.equals("start") || game.gameStageString.equals("logout")) {
                game.userLoginStage();
            }
            if (game.gameStageString.equals("selection")) {
                game.categorySelectionStage();
            }
            if (game.gameStageString.equals("leaderboard")){
                game.leaderboardStage();
            }
            if (game.gameStageString.equals("play")){
                game.gameStage();
            }
        } while (!(game.gameStageString.equals("exit")));
    }
}