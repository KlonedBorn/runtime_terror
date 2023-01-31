// Copyright 2023 Kyle King
// 
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
// 
//     http://www.apache.org/licenses/LICENSE-2.0
// 
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package edu.uwi.projects.gui.fragment;

import java.util.List;

import edu.uwi.projects.game.Theme;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.util.Duration;

public class FormManager {
    private TextField nameField;
    private ChoiceBox<Theme> themeBox;
    private Text messageText;
    private Button confirmButton;
    private boolean isValid;
    private Button clearButton;

    public FormManager(TextField nameField, ChoiceBox<Theme> themeBox, Text messageText, Button confirmButton,Button clearButton) {
        if(FormManager.themeManager == null) {
            FormManager.themeManager = new ChoiceBoxGroup<>(List.of(Theme.values()));
        }
        this.nameField = nameField;
        this.themeBox = themeBox;
        this.themeBox.setStyle("-fx-text-fill: white;");
        this.messageText = messageText;
        this.confirmButton = confirmButton;
        this.clearButton = clearButton;
        this.isValid = false;
        
        // Add listener to confirm button to validate input and display message
        this.confirmButton.setOnAction(e -> { 
            if (validateName()) {
                messageText.setText("Success!");
                messageText.setFill(Color.GREEN);
                messageText.setVisible(true);
                this.isValid = true;
            } else {
                this.onErrorShake(Duration.millis(50), this.nameField);
                messageText.setFill(Color.RED);
                messageText.setText("Error: Name must be at least 3 characters and contain only letters.");
                messageText.setVisible(true);
                this.isValid = false;
            }
        });

        this.clearButton.setOnAction(evt->clearFields());

        this.themeBox.addEventHandler(ChoiceBoxEvent.SUCCESS, evt -> {
            ChoiceBox<?> target = (ChoiceBox<?>)evt.getTarget();
            Theme selection = (Theme)evt.getSelection();
            messageText.setVisible(false);
            target.setStyle("-fx-background-color: " + selection.getColor().toString().replace("0x", "#") + ";");
        });

        this.themeBox.addEventHandler(ChoiceBoxEvent.FAIL, evt -> {
            ChoiceBox<?> target = (ChoiceBox<?>)evt.getTarget();
            onErrorShake(Duration.millis(50),target);
            messageText.setFill(Color.RED);
            target.setStyle("-fx-background-color: #FFF;");
            messageText.setText("Error: Must select a unique color as your theme");
            messageText.setVisible(true);
            this.isValid = false;
        });

        this.themeBox.getItems().addAll(List.of(Theme.values()));
        FormManager.themeManager.addChoiceBox(this.themeBox);
    }

    private void clearFields() {
        this.nameField.clear();
        this.themeBox.getSelectionModel().clearSelection();
        messageText.setText("");
        messageText.setStyle("visible:false;");
    }

    private boolean validateName() {
        String name = nameField.getText();
        // check name is at least 3 characters and contains only letters
        return name.length() >= 3 && name.matches("[a-zA-Z]+");
    }

    public static ChoiceBoxGroup<Theme> getThemeManagerInstance(){
        if(FormManager.themeManager == null) {
            FormManager.themeManager = new ChoiceBoxGroup<>(List.of(Theme.values()));
        }
        return FormManager.themeManager;
    }

    private void onErrorShake(Duration duration, Node target ) {
        TranslateTransition shake = new TranslateTransition(duration,target);
        shake.setByX(10);
        shake.setCycleCount(4);
        shake.setAutoReverse(true);
        shake.playFromStart(); 
    }

    // Getters for form fields
    public boolean getIsValid() { return this.isValid;}
    public TextField getNameField() { return nameField; }
    public ChoiceBox<Theme> getThemeBox() { return themeBox; }
    public Text getMessageText() { return messageText; }
    public Button getConfirmButton() { return confirmButton; }
    private static ChoiceBoxGroup<Theme> themeManager;
}