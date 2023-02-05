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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import edu.uwi.projects.game.Difficulty;
import edu.uwi.projects.game.Player;
import edu.uwi.projects.game.QuizMatch;
import edu.uwi.projects.game.Theme;
import edu.uwi.projects.game.Topic;
import edu.uwi.projects.gui.fragment.CheckBoxGroup;
import edu.uwi.projects.gui.fragment.FormManager;
import edu.uwi.projects.gui.fragment.RadioButtonGroup;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SettingsController implements Initializable{

    @FXML private void OnClickedConfirm(){
        if(this.p1FormManager.confirmFields()) this.p1FormManager.configPlayer(plSuite[0]);
        if(this.p2FormManager.confirmFields()) this.p2FormManager.configPlayer(plSuite[1]);
        this.tpSuite = this.topicManager.getSelectedTopics();
        this.diff = diffManager.getSelectedRadioButtonValueAsDifficulty();
        System.out.println(new QuizMatch(plSuite, tpSuite, diff));
    }

    @FXML private void OnClickedBack(){
        try {
            Launcher.setRoot("main-menu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override public void initialize(URL location, ResourceBundle resources) {
        plSuite = new Player[]{
            new Player(),
            new Player()
        };
        tpSuite = new ArrayList<>();
        diff = Difficulty.ANY;
        this.p1FormManager = new FormManager(tf_p1Name, cb_p1Theme, tx_p1Message);
        this.p2FormManager = new FormManager(tf_p2Name, cb_p2Theme, tx_p2Message);
        this.topicManager = new CheckBoxGroup();
        this.topicManager.addCheckBox(cx_dst);
        this.topicManager.addCheckBox(cx_aat);
        this.topicManager.addCheckBox(cx_oop);
        this.topicManager.addCheckBox(cx_abs);
        this.diffManager = new RadioButtonGroup();
        this.diffManager.addButton(rb_easy);
        this.diffManager.addButton(rb_medium);
        this.diffManager.addButton(rb_advanced);
        this.diffManager.addButton(rb_hard);
        this.diffManager.addButton(rb_any);
    }

    private Player plSuite[];
    private List<Topic> tpSuite;
    private Difficulty diff;
    private CheckBoxGroup topicManager;
    private RadioButtonGroup diffManager;
    private FormManager p1FormManager , p2FormManager;
    @FXML private VBox vb_topic,vb_difficulty;
    @FXML private TextField tf_p1Name;
    @FXML private ChoiceBox<Theme> cb_p1Theme;
    @FXML private Text tx_p1Message;
    @FXML private TextField tf_p2Name;
    @FXML private ChoiceBox<Theme> cb_p2Theme;
    @FXML private Text tx_p2Message;
    @FXML private CheckBox cx_dst;
    @FXML private CheckBox cx_oop;
    @FXML private CheckBox cx_abs;
    @FXML private CheckBox cx_aat;
    @FXML private Text tx_topicMessage;
    @FXML private RadioButton rb_easy;
    @FXML private RadioButton rb_medium;
    @FXML private RadioButton rb_advanced;
    @FXML private RadioButton rb_hard;
    @FXML private RadioButton rb_any;
    @FXML private Text tx_difficultyMessage;
    @FXML private Button bt_back;
    @FXML private Button bt_continue;
}