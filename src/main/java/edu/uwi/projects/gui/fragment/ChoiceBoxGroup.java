package edu.uwi.projects.gui.fragment;

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

import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.control.ChoiceBox;

public class ChoiceBoxGroup<T> {
    private final List<ChoiceBox<T>> choiceBoxes;
    private final List<T> options;
    private final List<T> selectedOptions;

    public ChoiceBoxGroup(List<T> options) {
        this.options = options;
        this.choiceBoxes = new ArrayList<>();
        this.selectedOptions = new ArrayList<>();
    }

    public void addChoiceBox(ChoiceBox<T> choiceBox) {
        choiceBox.setItems(FXCollections.observableArrayList(options));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (selectedOptions.contains(newValue)) {
                    choiceBox.getSelectionModel().clearSelection();
                    choiceBox.fireEvent(new ChoiceBoxEvent<T>(ChoiceBoxEvent.FAIL, newValue));
                } else {
                    selectedOptions.add(newValue);
                    choiceBox.fireEvent(new ChoiceBoxEvent<T>(ChoiceBoxEvent.SUCCESS, newValue));
                }
            }
            if (oldValue != null) {
                selectedOptions.remove(oldValue);
            }
        });
        choiceBoxes.add(choiceBox);
    }

    public List<ChoiceBox<T>> getChoiceBoxes() {
        return choiceBoxes;
    }
}