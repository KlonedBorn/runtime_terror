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

import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

import edu.uwi.projects.game.Difficulty;
import edu.uwi.projects.game.Player;
import edu.uwi.projects.game.Topic;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class GameplayController implements Initializable{

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @FXML private void onActionSwitchToNext(ActionEvent evt){
        curr = curr + 1 % 2;
        lb_playerName.setStyle("-fx-background-color:"+plSuite[curr].getTheme().toHex()+";");
        lb_playerName.setText(plSuite[curr].getName());
    }

    @FXML private AnchorPane ap_display;
    @FXML private Label lb_playerName;
    @FXML private Button bt_next;
    static private int curr = new Random().nextInt(2);
    static public Player plSuite[] = new Player[]{new Player(),new Player()};
    static public List<Topic> tpSuite = new ArrayList<>();
    static public Difficulty diff = Difficulty.ANY;
}