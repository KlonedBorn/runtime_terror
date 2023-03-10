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

package edu.uwi.projects;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class MainMenuController implements Initializable {

    @FXML private void OnActionStart(ActionEvent evt){
        try {
            Launcher.setRoot("settings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML private void OnActionOptions(ActionEvent evt){

    }

    @FXML private void OnActionExit(ActionEvent evt){
        Platform.exit();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Controller loaded");
    }

    @FXML private Button btn_start , btn_options , btn_exit ;
}