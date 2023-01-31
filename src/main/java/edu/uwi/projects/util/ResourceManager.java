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

package edu.uwi.projects.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ResourceManager extends Properties{
    
    public ResourceManager() {}

    public ResourceManager(Properties defaults) { super(defaults);}

    /**
     * Singleton design pattern. Creates a single instance of the {@code ResourceManager} class.
     * @param is InputStream to a .properties file containing system configurations.
     * @return A single instance of {@code ResourceManager}.
     * @throws IOException When load fails.
     */
    public static ResourceManager getInstance(InputStream is) throws IOException {
        if(ResourceManager.instance == null) {
            Properties defaults;
            ResourceManager.instance = new ResourceManager();
            if(is == null ){
                defaults = new Properties();
                defaults.setProperty("screen-width", "900.0f");
                defaults.setProperty("screen-height", "600.0f");
                ResourceManager.instance = new ResourceManager(defaults);
            }
            ResourceManager.instance.load(is);
        }
        return ResourceManager.instance;
    }

    private static ResourceManager instance;
}