package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton eraser;

    @FXML
    private RadioButton pen;

    @FXML
    private ToggleGroup tool;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        if (event.getX() <= 0 || event.getY() <= 0) return;
        Circle newCircle = null;
        if (pen.selectedProperty().get())
        {
            newCircle = new Circle(event.getX(),
                    event.getY(), 4, Color.BLACK);
        }
        else if (eraser.selectedProperty().get())
        {
            newCircle = new Circle(event.getX(),
                    event.getY(), 10, Color.WHITE);
        }
        drawingAreaPane.getChildren().add(newCircle);
    }

}
