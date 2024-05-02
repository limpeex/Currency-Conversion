package com.example.currencytranslator;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Mainscreen extends ControllerAbstractions implements Initializable {
    @FXML
    private Pane defaultPane;
    @FXML
    private ChoiceBox<String> firstChoiceBox;
    @FXML
    private Label firstLabel;
    @FXML
    private Label secondLabel;
    @FXML
    private ChoiceBox<String> secondChoiceBox;
    @FXML
    private Button translateButton;
    @FXML
    private TextField textField;

    String[] firstBoxList = {"$", "€", "TL"};
    String[] secondBoxList = {"$", "€", "TL"};

    public void changeColor() {
        defaultPane.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        callAllMethods(firstChoiceBox, firstBoxList, firstLabel);
        callAllMethods(secondChoiceBox, secondBoxList, secondLabel);
        textField.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textField.getText() != null && !(firstChoiceBox.getValue() == null)) {
                    firstLabel.setText(textField.getText() + " " + firstChoiceBox.getValue());
                    switch (firstChoiceBox.getValue()) {
                        case "$":
                            if (secondChoiceBox.getValue() == null) {
                                break;
                            } else if (secondChoiceBox.getValue().equals("$")) {
                                secondLabel.setText(textField.getText() + " " + secondChoiceBox.getValue());
                            } else if (secondChoiceBox.getValue().equals("€")) {
                                doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD", Integer.parseInt(textField.getText()), "EUR", secondLabel, secondChoiceBox, textField);
                            } else if (secondChoiceBox.getValue().equals("TL")) {
                                doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD", Integer.parseInt(textField.getText()), "TRY", secondLabel, secondChoiceBox, textField);
                            } else if (secondChoiceBox.getValue().equals("")) {
                                break;
                            }
                            break;
                        case "€":
                            if (secondChoiceBox.getValue() == null) {
                                break;
                            } else if (secondChoiceBox.getValue().equals("$")) {
                                doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/EUR", Integer.parseInt(textField.getText()), "USD", secondLabel, secondChoiceBox, textField);
                            } else if (secondChoiceBox.getValue().equals("€")) {
                                secondLabel.setText(textField.getText() + " " + secondChoiceBox.getValue());
                            } else if (secondChoiceBox.getValue().equals("TL")) {
                                doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/EUR", Integer.parseInt(textField.getText()), "TRY", secondLabel, secondChoiceBox, textField);
                            }
                            break;
                        case "TL":
                            if (secondChoiceBox.getValue() == null) {
                                break;
                            } else if (secondChoiceBox.getValue().equals("$")) {
                                doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/TRY", Integer.parseInt(textField.getText()), "USD", secondLabel, secondChoiceBox, textField);
                            } else if (secondChoiceBox.getValue().equals("€")) {
                                doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/TRY", Integer.parseInt(textField.getText()), "EUR", secondLabel, secondChoiceBox, textField);
                            } else if (secondChoiceBox.getValue().equals("TL")) {
                                secondLabel.setText(textField.getText() + " " + secondChoiceBox.getValue());
                            } else if (secondChoiceBox.getValue().equals("")) {
                                break;
                            }
                            break;

                        case "":
                            break;
                    }
                }
            }
        });
    }

    public void onButtonClicked(ActionEvent e) {
        if (textField.getText() != null && !(firstChoiceBox.getValue() == null)) {
            firstLabel.setText(textField.getText() + " " + firstChoiceBox.getValue());
            switch (firstChoiceBox.getValue()) {
                case "$":
                    if (secondChoiceBox.getValue() == null) {
                        break;
                    } else if (secondChoiceBox.getValue().equals("$")) {
                        secondLabel.setText(textField.getText() + " " + secondChoiceBox.getValue());
                    } else if (secondChoiceBox.getValue().equals("€")) {
                        doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD", Integer.parseInt(textField.getText()), "EUR", secondLabel, secondChoiceBox, textField);
                    } else if (secondChoiceBox.getValue().equals("TL")) {
                        doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/USD", Integer.parseInt(textField.getText()), "TRY", secondLabel, secondChoiceBox, textField);
                    } else if (secondChoiceBox.getValue().equals("")) {
                        break;
                    }
                    break;
                case "€":
                    if (secondChoiceBox.getValue() == null) {
                        break;
                    } else if (secondChoiceBox.getValue().equals("$")) {
                        doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/EUR", Integer.parseInt(textField.getText()), "USD", secondLabel, secondChoiceBox, textField);
                    } else if (secondChoiceBox.getValue().equals("€")) {
                        secondLabel.setText(textField.getText() + " " + secondChoiceBox.getValue());
                    } else if (secondChoiceBox.getValue().equals("TL")) {
                        doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/EUR", Integer.parseInt(textField.getText()), "TRY", secondLabel, secondChoiceBox, textField);
                    }
                    break;
                case "TL":
                    if (secondChoiceBox.getValue() == null) {
                        break;
                    } else if (secondChoiceBox.getValue().equals("$")) {
                        doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/TRY", Integer.parseInt(textField.getText()), "USD", secondLabel, secondChoiceBox, textField);
                    } else if (secondChoiceBox.getValue().equals("€")) {
                        doWork("https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/TRY", Integer.parseInt(textField.getText()), "EUR", secondLabel, secondChoiceBox, textField);
                    } else if (secondChoiceBox.getValue().equals("TL")) {
                        secondLabel.setText(textField.getText() + " " + secondChoiceBox.getValue());
                    } else if (secondChoiceBox.getValue().equals("")) {
                        break;
                    }
                    break;

                case "":
                    break;
            }
        }
    }


}
