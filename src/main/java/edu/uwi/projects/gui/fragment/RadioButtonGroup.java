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

import edu.uwi.projects.game.Difficulty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.RadioButton;

public class RadioButtonGroup {
    private ObservableList<RadioButton> buttons;
    
    public RadioButtonGroup() {
        buttons = FXCollections.observableArrayList();
    }
    
    public void addButton(RadioButton button) {
        buttons.add(button);
        
        button.setOnAction(event -> {
            selectButton(button);
        });
    }

    public RadioButton getSelectedRadioButton() {
        for (RadioButton radioButton : buttons) {
            if (radioButton.isSelected()) {
                return radioButton;
            }
        }
        return null;
    }

    public void selectButton(RadioButton button) {
        for (RadioButton btn : buttons) {
            if (btn == button) {
                btn.setSelected(true);
            } else {
                btn.setSelected(false);
            }
        }
    }
    public String getSelectedRadioButtonValueAsString() {
        RadioButton selectedRadioButton = getSelectedRadioButton();
        return selectedRadioButton != null ? selectedRadioButton.getText() : null;
    }

    public Difficulty getSelectedRadioButtonValueAsDifficulty() {
        String selectedRadioButtonValueAsString = getSelectedRadioButtonValueAsString();
        if (selectedRadioButtonValueAsString != null) {
            for (Difficulty difficulty : Difficulty.values()) {
                if (difficulty.toString().equals(selectedRadioButtonValueAsString)) {
                    return difficulty;
                }
            }
        }
        return Difficulty.ANY;
    }
}
