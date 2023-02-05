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

import java.util.ArrayList;
import java.util.List;

import edu.uwi.projects.game.Topic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.CheckBox;

public class CheckBoxGroup {
    private ObservableList<CheckBox> checkBoxes;
    private CheckBox lastChecked;
    
    public CheckBoxGroup() {
        checkBoxes = FXCollections.observableArrayList();
        lastChecked = null;
    }
    
    public void addCheckBox(CheckBox checkBox) {
        checkBoxes.add(checkBox);
        
        checkBox.setOnAction(event -> {
            if (!checkBox.isSelected() && checkBoxes.stream().noneMatch(CheckBox::isSelected)) {
                lastChecked.setSelected(true);
            } else {
                lastChecked = checkBox;
            }
        });
    }
    public List<String> getSelectedCheckBoxTexts() {
        List<String> selectedTexts = new ArrayList<>();
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedTexts.add(checkBox.getText());
            }
        }
        return selectedTexts;
    }
    
    public List<Topic> getSelectedTopics() {
        List<Topic> selectedTopics = new ArrayList<>();
        for (String checkBoxText : getSelectedCheckBoxTexts()) {
            for (Topic topic : Topic.values()) {
                if (topic.getFullName().equals(checkBoxText)) {
                    selectedTopics.add(topic);
                    break;
                }
            }
        }
        return selectedTopics;
    }
}