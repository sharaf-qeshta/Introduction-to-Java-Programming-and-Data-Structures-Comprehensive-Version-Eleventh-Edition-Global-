package chapter_fifteen;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ***15.34 (Simulation: self-avoiding random walk) A self-avoiding walk in a lattice is a
 * path from one point to another that does not visit the same point twice. Self avoiding
 * walks have applications in physics, chemistry, and mathematics. They
 * can be used to model chain-like entities such as solvents and polymers. Write
 * a program that displays a random path that starts from the center and ends at a
 * point on the boundary, as shown in Figure 15.39a, or ends at a dead-end point
 * (i.e., surrounded by four points that have already been visited), as shown in
 * Figure 15.39b. Assume the size of the lattice is 16 by 16.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$34 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        LatticePane pane = new LatticePane();
        Path path  = new Path(pane, pane.getVerticalStep(), pane.getHorizontalStep());

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Problem$34");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
