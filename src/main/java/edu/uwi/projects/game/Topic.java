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

public enum Topic {
    DST("Data Structure Theory"),
    OOP("Object-Oriented Programming"),
    ABS("Abstraction"),
    AAT("Algorithm Analysis Theorem");
    
    private final String fullName;
    
    Topic(String fullName) {
        this.fullName = fullName;
    }
    
    public String getFullName() {
        return fullName;
    }
}