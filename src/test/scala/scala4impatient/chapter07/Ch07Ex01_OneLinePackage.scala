/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com {
  object Com {
    // NOP
  }

  package horstmann {
    object Horstmann {
      // NOP
    }

    package impatient {
      object Impatient {
        // NOP
      }
    }
  }
}

package com.horstmann.impatient {
  object ComHorstmannImpatient {
    Impatient.toString

    // can't make any reference to object from parent package Com (without importing it)
    import com.Com
    Com.toString

    // can't make any reference to object from parent package Horstmann (without importing it)
    import com.horstmann.Horstmann
    Horstmann.toString
  }
}
