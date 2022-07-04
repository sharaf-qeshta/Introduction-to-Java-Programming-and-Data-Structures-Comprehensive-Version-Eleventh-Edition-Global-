package chapter_sixteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * ***16.31  (Game: connect four) Programming Exercise 8.20 enables two players to play
 * the connect-four game on the console. Rewrite a GUI version for the program,
 * as shown in Figure 16.49c. The program enables two players to place red and
 * yellow discs in turn. To place a disk, the player needs to click an available cell.
 * An available cell is unoccupied and its downward neighbor is occupied. The
 * program flashes the four winning cells if a player wins, and reports no winners
 * if all cells are occupied with no winners.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$31 extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        ConnectFour pane = new ConnectFour(primaryStage);

        Scene scene = new Scene(pane, 600, 500);
        primaryStage.setTitle("Problem$31");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setResizable(false);
    }
}
