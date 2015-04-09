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

import org.scalatest.{ FlatSpec, Matchers }

import scala.collection.mutable
import scala.reflect.runtime.universe._

/**
 * I tried to do this by hand ... easy to start, hard to complete!
 */
class Ch10Ex03_LinearizationSpec extends FlatSpec with Matchers {
  "BitSet" should "have this linearization" in {
    val actualBaseClasses: Array[String] = typeOf[mutable.BitSet]
      .baseClasses
      .map(_.fullName)
      .toArray

    val expectedBaseClasses: Array[String] = Array[String](
      "scala.collection.mutable.BitSet",
      "scala.Serializable",
      "java.io.Serializable",
      "scala.collection.BitSet",
      "scala.collection.BitSetLike",
      "scala.collection.mutable.SortedSet",
      "scala.collection.SortedSet",
      "scala.collection.SortedSetLike",
      "scala.collection.generic.Sorted",
      "scala.collection.mutable.AbstractSet",
      "scala.collection.mutable.Set",
      "scala.collection.mutable.SetLike",
      "scala.collection.mutable.Cloneable",
      "scala.Cloneable",
      "java.lang.Cloneable",
      "scala.collection.generic.Shrinkable",
      "scala.collection.mutable.Builder",
      "scala.collection.generic.Growable",
      "scala.collection.generic.Clearable",
      "scala.collection.script.Scriptable",
      "scala.collection.Set",
      "scala.collection.SetLike",
      "scala.collection.generic.Subtractable",
      "scala.collection.GenSet",
      "scala.collection.generic.GenericSetTemplate",
      "scala.collection.GenSetLike",
      "scala.Function1",
      "scala.collection.mutable.AbstractIterable",
      "scala.collection.mutable.Iterable",
      "scala.collection.mutable.Traversable",
      "scala.Mutable",
      "scala.collection.AbstractIterable",
      "scala.collection.Iterable",
      "scala.collection.IterableLike",
      "scala.Equals",
      "scala.collection.GenIterable",
      "scala.collection.GenIterableLike",
      "scala.collection.AbstractTraversable",
      "scala.collection.Traversable",
      "scala.collection.GenTraversable",
      "scala.collection.generic.GenericTraversableTemplate",
      "scala.collection.TraversableLike",
      "scala.collection.GenTraversableLike",
      "scala.collection.Parallelizable",
      "scala.collection.TraversableOnce",
      "scala.collection.GenTraversableOnce",
      "scala.collection.generic.FilterMonadic",
      "scala.collection.generic.HasNewBuilder",
      "java.lang.Object",
      "scala.Any"
    )

    actualBaseClasses.deep == expectedBaseClasses.deep should be(right = true)
  }
}
