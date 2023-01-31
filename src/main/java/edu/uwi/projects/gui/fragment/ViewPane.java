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

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ViewPane extends Pane {

    private final BorderPane borderPane;

    public ViewPane() {
        // create the BorderPane for holding the FXML content
        borderPane = new BorderPane();
        getChildren().add(borderPane);
    }

    /**
     * Renders an external FXML file within the ViewPane.
     *
     * @param fxmlFilePath the path of the FXML file to be rendered
     * @throws IOException if there is an error loading the FXML file
     */
    public void renderFXML(String fxmlFilePath) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFilePath));
        Parent fxml = (Parent)loader.load();
        borderPane.setCenter(fxml);
    }
}