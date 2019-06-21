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

package org.apache.submarine.tony.rpc.impl.pb;

import org.apache.submarine.tony.rpc.HeartbeatResponse;
import org.apache.submarine.tony.rpc.proto.YarnTensorFlowClusterProtos.HeartbeatResponseProto;


public class HeartbeatResponsePBImpl implements HeartbeatResponse {
  private HeartbeatResponseProto proto = HeartbeatResponseProto.getDefaultInstance();
  private HeartbeatResponseProto.Builder builder = null;
  private boolean viaProto = false;

  private boolean rebuild = false;

  public HeartbeatResponsePBImpl() {
    builder = HeartbeatResponseProto.newBuilder();
  }

  public HeartbeatResponsePBImpl(HeartbeatResponseProto proto) {
    this.proto = proto;
    viaProto = true;
  }

  private void mergeLocalToProto() {
    if (viaProto) {
      maybeInitBuilder();
    }
    proto = builder.build();
    rebuild = false;
    viaProto = true;
  }

  public HeartbeatResponseProto getProto() {
    if (rebuild) {
      mergeLocalToProto();
    }
    proto = viaProto ? proto : builder.build();
    viaProto = true;
    return proto;
  }

  private void maybeInitBuilder() {
    if (viaProto || builder == null) {
      builder = HeartbeatResponseProto.newBuilder(proto);
    }
    viaProto = false;
  }
}
