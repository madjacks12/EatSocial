# EatSocial

This app is designed to show you what restaurants are most popular in your social network eventually using Facebook's API. This app is not currently functional and will only display sample data.

## Installation
Clone this repository and import into **Android Studio**
```bash
git clone https://github.com/madjacks12/EatSocial
```

## API instructions. 

In order to use the Google Map used in this app you must get an API key here: https://developers.google.com/maps/documentation/android-api/signup. <br><br> Next,
 you will need to add a new string to the file strings.xml found in <b>app-> res -> values -> strings.xml</b>. Format your string as follows: `<string name="google_maps_key">YOUR_API_KEY_HERE</string>` 
 
##Future Plans

In the near future this app will include a Facebook login which will trigger a Facebook API GET request to gather check-in data from the user's Facebook friends to display which restaurants the user's network has ate at within a specific geographic radius.
 