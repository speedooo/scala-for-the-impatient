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

package scala4impatient.chapter10

trait Ch10Ex07_Cache {
  def put(key: Any, value: Any): Unit
  def get(key: Any): Any
  def evict(key: Any): Unit
  def clear(): Unit
}

trait Ch10Ex07_NoOpCache extends Ch10Ex07_Cache {
  def put(key: Any, value: Any): Unit = {}
  def get(key: Any): Any = {}
  def evict(key: Any): Unit = {}
  def clear(): Unit = {}
}

trait Ch10Ex07_MapCache extends Ch10Ex07_Cache {
  var map: java.util.Map[Any, Any]

  def put(key: Any, value: Any): Unit = map.put(key, value)
  def get(key: Any): Any = map.get(key)
  def evict(key: Any): Unit = map.remove(key)
  def clear(): Unit = map.clear()
}

trait Ch10Ex07_HashMapCache extends Ch10Ex07_MapCache {
  var map: java.util.Map[Any, Any] = new java.util.HashMap[Any, Any]()
}

trait Ch10Ex07_ConcurrentHashMapCache extends Ch10Ex07_MapCache {
  var map: java.util.Map[Any, Any] = new java.util.concurrent.ConcurrentHashMap[Any, Any]()
}
