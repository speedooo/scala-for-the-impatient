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

import java.awt.Point
import java.beans.{ PropertyChangeEvent, PropertyChangeListener, PropertyChangeSupport }

import org.scalatest.{ FlatSpec, Matchers }

// @BasileDuPlessis - delegation pattern credits

trait Ch10Ex05_PropertyChangeSupport {
  val delegate: PropertyChangeSupport = new PropertyChangeSupport(this)

  def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener): Unit = {
    delegate.addPropertyChangeListener(propertyName, listener)
  }

  def firePropertyChange(event: PropertyChangeEvent): Unit = {
    delegate.firePropertyChange(event)
  }
}

class Ch10Ex05_PropertyChangeSupportSpec extends FlatSpec with Matchers {
  "PropertyChangeSupport" should "mixed into Java AWT Point" in {
    var newValueX: Double = 0
    var newValueY: Double = 0

    val point = new Point() with Ch10Ex05_PropertyChangeSupport {
      override def setLocation(x: Double, y: Double): Unit = {
        val oldValueX: Double = getX
        val oldValueY: Double = getY

        super.setLocation(x, y)

        firePropertyChange(new PropertyChangeEvent(this, "x", oldValueX, getX))
        firePropertyChange(new PropertyChangeEvent(this, "y", oldValueY, getY))
      }
    }

    point.addPropertyChangeListener("x", new PropertyChangeListener {
      override def propertyChange(event: PropertyChangeEvent): Unit = newValueX = event.getNewValue.toString.toDouble
    })
    point.addPropertyChangeListener("y", new PropertyChangeListener {
      override def propertyChange(event: PropertyChangeEvent): Unit = newValueY = event.getNewValue.toString.toDouble
    })

    point.setLocation(1.0, 2.0)

    newValueX should be(1.0)
    newValueY should be(2.0)
  }
}
