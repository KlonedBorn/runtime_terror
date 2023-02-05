# Copyright 2023 Kyle King
# 
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
# 
#     http://www.apache.org/licenses/LICENSE-2.0
# 
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import os

def get_fxid_values(file_path):
    with open(file_path, 'r') as f:
        lines = f.readlines()
    values = []
    for line in lines:
        if 'fx:id=' in line:
            start_index = line.index('fx:id=') + 8
            end_index = line.index('"', start_index)
            values.append(line[start_index:end_index])
    return values

def generate_inject_file(values):
    with open('inject.txt', 'w') as f:
        for value in values:
            f.write('@FXML private <type> %s;\n' % value)

if __name__ == '__main__':
    directory_path = '.'
    values = []
    for filename in os.listdir(directory_path):
        if filename.endswith('.fxml'):
            file_path = os.path.join(directory_path, filename)
            values += get_fxid_values(file_path)
    generate_inject_file(values)