package chapter_twenty_five;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * ***25.17 (Data compression: Huffman coding animation) Write a program that enables
 * the user to enter text and displays the Huffman coding tree based on the text, as
 * shown in Figure 25.21a. Display the weight of the subtree inside the subtree’s
 * root circle. Display each leaf node’s character. Display the encoded bits for
 * the text in a label. When the user clicks the Decode Text button, a bit string is
 * decoded into text displayed in the label, as shown in Figure 25.21b.
 *
 *
 * @author Sharaf Qeshta
 * */
public class Problem$17 extends Application
{
    private Tree tree;
    @Override
    public void start(Stage primaryStage)
    {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        Label enterText = new Label("Enter a text: ");
        TextField text = new TextField();
        text.setPrefColumnCount(12);
        Button viewHuffman = new Button("Show Huffman Tree");
        HBox huffmanTreeSettings = new HBox(5, enterText, text, viewHuffman);
        huffmanTreeSettings.setAlignment(Pos.CENTER);
        pane.getChildren().add(huffmanTreeSettings);

        Label enterBitString = new Label("Enter a bit string: ");
        TextField bitString = new TextField();
        bitString.setPrefColumnCount(12);
        Button decode = new Button("Decode to Text");
        HBox decoderContainer = new HBox(5, enterBitString, bitString, decode);
        decoderContainer.setAlignment(Pos.CENTER);
        pane.getChildren().add(decoderContainer);


        int[] counts = getCharacterFrequency("");
        tree = getHuffmanTree(counts);
        Pane huffmanTree = new TreePane(tree, 500, 500);
        pane.getChildren().add(huffmanTree);

        Label status = new Label();
        pane.getChildren().add(status);


        viewHuffman.setOnAction(e ->
        {
            String originalText = text.getText();
            int[] counts_ = getCharacterFrequency(originalText);
            tree = getHuffmanTree(counts_);
            pane.getChildren().set(2,new TreePane(tree, 500, 500));
            status.setText(originalText + " is encoded to " + getEncoded(originalText, tree));
        });

        decode.setOnAction(e ->
        {
            String bitString_ = bitString.getText();
            status.setText(bitString_ + " is decoded to " + tree.decode(bitString_));
        });

        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Problem$17");
        primaryStage.show();
    }

    public String getEncoded(String text, Tree tree)
    {
        String encoded = "";
        for (int i = 0; i < text.length(); i++)
            encoded += tree.getCode(text.charAt(i));
        return encoded;
    }

    /**
     * Get a Huffman tree from the codes
     */
    public static Tree getHuffmanTree(int[] counts)
    {
        // Create a heap to hold trees
        Heap<Tree> heap = new Heap<>();
        for (int i = 0; i < counts.length; i++)
        {
            if (counts[i] > 0)
                heap.add(new Tree(counts[i], (char) i)); // A leaf node tree
        }

        while (heap.getSize() > 1)
        {
            Tree t1 = heap.remove(); // Remove the smallest−weight tree
            Tree t2 = heap.remove(); // Remove the next smallest
            heap.add(new Tree(t1, t2)); // Combine two trees
        }

        return heap.remove(); // The final tree
    }

    /**
     * Get the frequency of the characters
     */
    public static int[] getCharacterFrequency(String text)
    {
        int[] counts = new int[256]; // 256 ASCII characters

        for (int i = 0; i < text.length(); i++)
            counts[(int) text.charAt(i)]++; // Count the characters in text

        return counts;
    }
}
