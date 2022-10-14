package chapter_thirty_two;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * *32.1 (Revise Listing 32.1) Rewrite Listing 32.1 to display the output in a text area, as
 * shown in Figure 32.30.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$01 extends Application
{
    private static final TextArea textArea = new TextArea();
    private static String textAreaContent = "";
    @Override
    public void start(Stage stage)
    {
        textArea.setWrapText(true);
        Thread thread1 = new Thread(new PrintChar('a', 100));
        Thread thread2 = new Thread(new PrintChar('b', 100));
        Thread thread3 = new Thread(new PrintNum(100));

        thread1.start();
        thread2.start();
        thread3.start();

        StackPane pane = new StackPane(textArea);

        Scene scene = new Scene(pane, 500, 250);
        stage.setTitle("Problem$01");
        stage.setScene(scene);
        stage.show();
    }


    private static class PrintChar implements Runnable
    {
        private final char x;
        private final int times;

        public PrintChar(char x, int times)
        {
            this.x = x;
            this.times = times;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < times; i++)
            {
                textAreaContent += x;
                Platform.runLater( () -> textArea.setText(textAreaContent));
            }
        }
    }


    private static class PrintNum implements Runnable
    {
        int bound;

        public PrintNum(int bound)
        {
            this.bound = bound;
        }

        @Override
        public void run()
        {
            for (int i = 0; i <= bound; i++)
            {
                textAreaContent += i;
                Platform.runLater( () -> textArea.setText(textAreaContent));
            }
        }
    }
}
