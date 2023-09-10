Feature: Cleartrip flight booking Navigation feature

  Background: User launches cleartrip website
    Given User launches the Browser
    When  User is in flight booking website page and browse for flights
      | CWebsite                  |
      | https://www.cleartrip.com |

  @cleartrip @oneway
  Scenario Outline: Navigate to Cleartrip flight booking website and browse for the  flight details

    Given User enters his choices for booking the flight for the "<triptype>" trip
    And   User entering the "<triptype>" trip details and search for the flights
      | Fromplace           | Destinationplace    | traveldt        |
      | BLR - Bangalore, IN | DEL - New Delhi, IN | Tue Aug 08 2023 |


    Examples:
      | triptype |
      | One way  |