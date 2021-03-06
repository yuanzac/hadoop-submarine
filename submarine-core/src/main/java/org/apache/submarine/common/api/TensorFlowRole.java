/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. See accompanying LICENSE file.
 */

package org.apache.submarine.common.api;

/**
 * Enum to represent a TensorFlow Role.
 */
public enum TensorFlowRole implements Role {
  PRIMARY_WORKER("master"),
  WORKER("worker"),
  PS("ps"),
  TENSORBOARD("tensorboard");

  private String compName;

  TensorFlowRole(String compName) {
    this.compName = compName;
  }

  @Override
  public String getComponentName() {
    return compName;
  }

  @Override
  public String getName() {
    return name();
  }
}
