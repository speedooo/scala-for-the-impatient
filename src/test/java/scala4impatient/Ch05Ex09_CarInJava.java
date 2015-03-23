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

package scala4impatient;

public class Ch05Ex09_CarInJava {
    private final String manufacturer;
    private final String modelName;
    private int modelYear = -1;
    private String licensePlate = "";

    public Ch05Ex09_CarInJava(String manufacturer, String modelName) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
    }

    public Ch05Ex09_CarInJava(String manufacturer, String modelName, int modelYear) {
        this(manufacturer, modelName);
        this.modelYear = modelYear;
    }

    public Ch05Ex09_CarInJava(String manufacturer, String modelName, String licensePlate) {
        this(manufacturer, modelName);
        this.licensePlate = licensePlate;
    }

    public Ch05Ex09_CarInJava(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this(manufacturer, modelName, modelYear);
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
