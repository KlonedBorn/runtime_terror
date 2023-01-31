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

import javafx.event.Event;
import javafx.event.EventType;

public class ChoiceBoxEvent<T> extends Event {
    public static final EventType<ChoiceBoxEvent<?>> ANY = new EventType<>(Event.ANY, "CHOICE_BOX_EVENT");
    public static final EventType<ChoiceBoxEvent<?>> SUCCESS = new EventType<>(ANY, "CHOICE_BOX_SUCCESS");
    public static final EventType<ChoiceBoxEvent<?>> FAIL = new EventType<>(ANY, "CHOICE_BOX_FAIL");

    private final T selection;

    public ChoiceBoxEvent(EventType<? extends Event> eventType, T selection) {
        super(eventType);
        this.selection = selection;
    }

    public T getSelection() {
        return selection;
    }
}