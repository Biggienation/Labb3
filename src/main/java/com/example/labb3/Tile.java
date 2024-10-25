package com.example.labb3;

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
        pane.setMinSize(50,50);

        Rectangle border = new Rectangle();
        border.setWidth(50);
        border.setHeight(50);
        border.setFill(Color.AQUA);
        border.setStroke(Color.BLACK);
        pane.getChildren().add(border);

        label = new Label();
        label.setAlignment(Pos.CENTER);
        label.setFont(Font.font(24));
        pane.getChildren().add(label);

        pane.setOnMouseClicked(e ->{
            System.out.println("clicked on");
        });
    }

    public StackPane getStackPane(){
        return pane;
    }

    public String getText(){
        return label.getText();
    }

    public void setLabel(String text){
        label.setText(text);
    }
}
