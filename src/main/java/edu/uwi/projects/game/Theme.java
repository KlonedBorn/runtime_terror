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

package edu.uwi.projects.game;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;
import javafx.util.Pair;

public enum Theme {
    RED("Red", Color.RED),
    ORANGE("Orange", Color.ORANGE),
    YELLOW("Yellow", Color.YELLOW),
    GREEN("Green", Color.GREEN),
    BLUE("Blue", Color.BLUE),
    PURPLE("Purple", Color.PURPLE),
    PINK("Pink", Color.PINK),
    BROWN("Brown", Color.BROWN),
    GRAY("Gray", Color.GRAY),
    BLACK("Black", Color.BLACK),
    // WHITE("White", Color.WHITE),
    LIGHTGRAY("Light gray", Color.LIGHTGRAY);

    private final String name;
    private final Color color;

    Theme(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public static List<Pair<String, Color>> getList() {
        List<Pair<String, Color>> list = new ArrayList<>();
        for (Theme theme : Theme.values()) {
            list.add(new Pair<>(theme.getName(), theme.getColor()));
        }
        return list;
    }

    @Override
    public String toString(){
        return this.name;
    }

    public String toHex() {
        String hex = String.format("#%02X%02X%02X",
        (int)(color.getRed() * 255),
        (int)(color.getGreen() * 255),
        (int)(color.getBlue() * 255));
        return hex;
    }
}