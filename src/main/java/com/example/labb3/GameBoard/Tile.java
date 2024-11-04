package com.example.labb3.GameBoard;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class Tile {
    private StackPane pane;
    private Label label;


    public Tile(){
        pane = new StackPane();
        pane.setMinSize(100,100);

        Rectangle border = new Rectangle();
        border.setWidth(100);
        border.setHeight(100);
        border.setFill(Color.web("#14BDAC"));
        border.setStroke(Color.BLACK);
        pane.getChildren().add(border);

        label = new Label();
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font(40));
        pane.getChildren().add(label);
    }

    public StackPane getStackPane(){
        return pane;
    }

    public String getLabel(){
        return label.getText();
    }

    public void setLabel(String text){
        label.setText(text);
    }
}
