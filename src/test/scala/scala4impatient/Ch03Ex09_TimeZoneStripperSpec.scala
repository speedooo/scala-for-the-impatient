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

package scala4impatient

import java.util.TimeZone

import org.scalatest.{ FlatSpec, Matchers }

import scala.util.Sorting.quickSort
import scala4impatient.Ch03Ex09_TimeZoneStripper._

object Ch03Ex09_TimeZoneStripper {
  def strip(): Array[String] = {
    val availableIDsInUS: Array[String] = for (e <- TimeZone.getAvailableIDs if e.startsWith("America/")) yield e.replaceAll("^America/", "")
    quickSort(availableIDsInUS)
    availableIDsInUS
  }
}

class Ch03Ex09_TimeZoneStripperSpec extends FlatSpec with Matchers {
  "stripped american time zone identifiers" should "be listed below" in {
    val actual: Array[String] = strip()
    val expected: Array[String] = Array(
      "Adak",
      "Anchorage",
      "Anguilla",
      "Antigua",
      "Araguaina",
      "Argentina/Buenos_Aires",
      "Argentina/Catamarca",
      "Argentina/ComodRivadavia",
      "Argentina/Cordoba",
      "Argentina/Jujuy",
      "Argentina/La_Rioja",
      "Argentina/Mendoza",
      "Argentina/Rio_Gallegos",
      "Argentina/Salta",
      "Argentina/San_Juan",
      "Argentina/San_Luis",
      "Argentina/Tucuman",
      "Argentina/Ushuaia",
      "Aruba",
      "Asuncion",
      "Atikokan",
      "Atka",
      "Bahia",
      "Bahia_Banderas",
      "Barbados",
      "Belem",
      "Belize",
      "Blanc-Sablon",
      "Boa_Vista",
      "Bogota",
      "Boise",
      "Buenos_Aires",
      "Cambridge_Bay",
      "Campo_Grande",
      "Cancun",
      "Caracas",
      "Catamarca",
      "Cayenne",
      "Cayman",
      "Chicago",
      "Chihuahua",
      "Coral_Harbour",
      "Cordoba",
      "Costa_Rica",
      "Creston",
      "Cuiaba",
      "Curacao",
      "Danmarkshavn",
      "Dawson",
      "Dawson_Creek",
      "Denver",
      "Detroit",
      "Dominica",
      "Edmonton",
      "Eirunepe",
      "El_Salvador",
      "Ensenada",
      "Fort_Wayne",
      "Fortaleza",
      "Glace_Bay",
      "Godthab",
      "Goose_Bay",
      "Grand_Turk",
      "Grenada",
      "Guadeloupe",
      "Guatemala",
      "Guayaquil",
      "Guyana",
      "Halifax",
      "Havana",
      "Hermosillo",
      "Indiana/Indianapolis",
      "Indiana/Knox",
      "Indiana/Marengo",
      "Indiana/Petersburg",
      "Indiana/Tell_City",
      "Indiana/Vevay",
      "Indiana/Vincennes",
      "Indiana/Winamac",
      "Indianapolis",
      "Inuvik",
      "Iqaluit",
      "Jamaica",
      "Jujuy",
      "Juneau",
      "Kentucky/Louisville",
      "Kentucky/Monticello",
      "Knox_IN",
      "Kralendijk",
      "La_Paz",
      "Lima",
      "Los_Angeles",
      "Louisville",
      "Lower_Princes",
      "Maceio",
      "Managua",
      "Manaus",
      "Marigot",
      "Martinique",
      "Matamoros",
      "Mazatlan",
      "Mendoza",
      "Menominee",
      "Merida",
      "Metlakatla",
      "Mexico_City",
      "Miquelon",
      "Moncton",
      "Monterrey",
      "Montevideo",
      "Montreal",
      "Montserrat",
      "Nassau",
      "New_York",
      "Nipigon",
      "Nome",
      "Noronha",
      "North_Dakota/Beulah",
      "North_Dakota/Center",
      "North_Dakota/New_Salem",
      "Ojinaga",
      "Panama",
      "Pangnirtung",
      "Paramaribo",
      "Phoenix",
      "Port-au-Prince",
      "Port_of_Spain",
      "Porto_Acre",
      "Porto_Velho",
      "Puerto_Rico",
      "Rainy_River",
      "Rankin_Inlet",
      "Recife",
      "Regina",
      "Resolute",
      "Rio_Branco",
      "Rosario",
      "Santa_Isabel",
      "Santarem",
      "Santiago",
      "Santo_Domingo",
      "Sao_Paulo",
      "Scoresbysund",
      "Shiprock",
      "Sitka",
      "St_Barthelemy",
      "St_Johns",
      "St_Kitts",
      "St_Lucia",
      "St_Thomas",
      "St_Vincent",
      "Swift_Current",
      "Tegucigalpa",
      "Thule",
      "Thunder_Bay",
      "Tijuana",
      "Toronto",
      "Tortola",
      "Vancouver",
      "Virgin",
      "Whitehorse",
      "Winnipeg",
      "Yakutat",
      "Yellowknife"
    )
    actual.deep == expected.deep should be(right = true)
  }
}
