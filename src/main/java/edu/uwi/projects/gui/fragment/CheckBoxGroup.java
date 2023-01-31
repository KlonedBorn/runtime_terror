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

import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CheckBoxGroup {
    private List<CheckBox> checkBoxes;
    private Pane parentPane;

    public CheckBoxGroup() {
        checkBoxes = new ArrayList<>();
    }

    public CheckBoxGroup(Pane parentPane) {
        this();
        this.parentPane = parentPane;
        findCheckBoxes();
    }

    public void addCheckBox(CheckBox checkBox) {
        checkBoxes.add(checkBox);
    }

    public void findCheckBoxes() {
        if (parentPane == null) {
            throw new IllegalStateException("Parent Pane is not set");
        }
        for (var node : parentPane.getChildren()) {
            if (node instanceof CheckBox) {
                checkBoxes.add((CheckBox) node);
            }
        }
    }

    public List<String> getSelectedCheckBoxText() {
        List<String> selectedCheckBoxText = new ArrayList<>();
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                selectedCheckBoxText.add(checkBox.getText());
            }
        }
        return selectedCheckBoxText;
    }

    public void selectAll() {
        for (CheckBox checkBox : checkBoxes)
            checkBox.setSelected(true);
        
    }

    public void unselectAll() {
        for (CheckBox checkBox : checkBoxes) 
            checkBox.setSelected(false);
        
    }

    public void randomSelect() {
        unselectAll();
        Random random = new Random();
        for (CheckBox checkBox : checkBoxes) 
            checkBox.setSelected(random.nextBoolean());
    }
}