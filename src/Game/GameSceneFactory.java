package Game;

import Game.Games.Hangman.HangmanScene;
import Game.Games.Runner.RunnerScene;
import Game.Games.ConnectFour.ConnectFourScene;
import Game.Games.CookieClicker.CookieClickerScene;
import Game.Games.TicTacToe.TicTacToeScene;
import Map.MapScene;
import Map.Model.History;
import ContestSettings.ContestSettingsScene;
import Online.Client.ClientScene;
import Online.Server.ServerScene;
import OnlineContestMenu.OnlineContestMenuScene;
import Player.Player;
import Scene.Model.SceneEnum;
import Scene.Model.SceneFactoryInterface;
import Training.TrainingMenuScene;

public class GameSceneFactory implements SceneFactoryInterface {

    private Player[] playersList;
    private boolean isTraining;
    private History history;

    public GameSceneFactory(Player[] listPlayers, boolean isTraining) {
        this.playersList = listPlayers;
        this.isTraining = isTraining;
    }

    /**
     * Create a game associated to an game
     */
    public GameScene createScene(SceneEnum gameEnum) {
        // TODO fill the switch when scenes will be created
        switch (gameEnum) {
            case MAP:
                return new MapScene(this.history);
            case TIC_TAC_TOE:
                return new TicTacToeScene(this.playersList, this.isTraining, this.history.getCurrentScore());
            case HANGMAN:
                return new HangmanScene(this.playersList, this.isTraining, this.history.getCurrentScore());
            case RUNNER:
                return new RunnerScene(this.playersList, this.isTraining, this.history.getCurrentScore());
            case CONNECT_FOUR:
                return new ConnectFourScene(this.playersList, this.isTraining, this.history.getCurrentScore());
            case COOKIE_CLICKER:
                return new CookieClickerScene(this.playersList, this.isTraining, this.history.getCurrentScore());
            case TRAINING_MENU:
                return new TrainingMenuScene();
            case CONTEST_MENU:
                return new ContestSettingsScene();
            case ONLINE_CONTEST_MENU:
                return new OnlineContestMenuScene();
            case CREATE_SERVER_SCENE:
                return new ServerScene();
            case JOIN_SERVER_SCENE:
                return new ClientScene();
            default:
                throw new RuntimeException("GameEnum (" + gameEnum + ") is unknown");
        }
    }

    public void updateHistory(History history) {
        this.history = history;
    }

    public void updatePlayersList(Player[] playerList) {
        this.playersList = playerList;
    }
}
