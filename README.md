# amon-sul-Release-3
###_Version 5 of the WeatherTop viewing app_

## New Features:

- [x] **User Personal Details**:
    - [x] Users can view their personal info.
    - [x] Users can edit their personal info.
    - [x] Users can add a profile picture by linking to it.
    - [x] Default user profile pic added on registration.
  

- [x] **Date and Time stamps** added for Readings:
    - [x] Date in yyyy/MM/dd format.
    - [x] time in HH:mm:ss format.
    - [x] All new readings created with date and time stamp.
  

- [x] Dashboard now shows **"All Stations Summary"**:
    -[x] Every Station on the Dashboard now shows latest weather cards.


- [x] **Trends** analyses the three most recent Readings from a station.
    - [x] Trends can show if these Readings are:
        - [x] Rising
        - [x] Falling
    - [x] Trends are now available for:
        - [x] Temperature
        - [x] Wind Speed
        - [x] Pressure
    - [x] If the Readings are rising or falling, an appropriate arrow displays
    to indicate this.
    - [x] Otherwise, no arrow is displayed on the latest readings cards.


- [x] User can now **DELETE** the following data:
    - [x] Readings from a Station.
    - [x] Stations from their Dashboard.


-[x] **DEPLOYED TO THE CLOUD**

## Description:

In this version the User update the personal details on their account. Profile pictures have been added,
and these can be changed by supplying a URL to their image on the web.

Each Reading now displays a Date and Time stamp showing to the exact second when it was created.

The User can now delete individual Readings from a Station, or delete and entire Station and 
its Readings from their account.

The list of Stations on the User's Dashboard now shows the latest weather and trend cards
as a Station Summary.

Trends have been added to the Station Summary. By analyising the most recent 3 Readings
from a Station, the Station Summary will show an UP arrow if the values for these most recent
three readings are increasing, or a DOWN arrow if they are falling. In the event that they are
neither rising nor falling, no arrow will be displayed.

## How to Run:

Download the repository from GitHub:

* [Amon Sul Release 3 (Version 5)](https://github.com/diarmuidoriordan/amon-sul-Release-3)

_(Make sure you have [Play 1.5.3](https://www.playframework.com/releases) installed on your computer.)_

Navigate to the Project folder in _**Terminal**_ or the _**Command Prompt**_, and run the following commands:

* ```play idealize```

* ```play run```

In your browser, enter ```localhost:9000``` in the URL search bar.
Press the return key on your keyboard to view the project.

