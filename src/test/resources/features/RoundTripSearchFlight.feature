Feature: ClearTrip Booking search for roundtrip flights

  Background: User launches cleartrip website
    Given User launches the Browser
    When  User is in flight booking website page and browse for flights
      | CWebsite                  |
      | https://www.cleartrip.com |


  @roundtripflights
  Scenario Outline: Navigate to Cleartrip flight booking website and browse for the roundtrip flights

    Given User enters his choices for booking the flight for the "<triptype>" trip
    And   User entering the "<triptype>" trip details and search for the flights
      | Fromplace           | Destinationplace    | traveldt        |
      | BLR - Bangalore, IN | DEL - New Delhi, IN | Tue Aug 01 2023 |
    Then User is browsing for earlymorning "<earlymorningflight>" flights
    And  Verify whether the earlymorning flights are available



    Examples:
      | earlymorningflight | triptype   |
      | Midnight - 8 am    | Round trip |