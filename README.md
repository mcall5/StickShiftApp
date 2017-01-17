# StickShiftApp
An app to teach the basics of stick shift driving. The project features a flashcard design with navigational buttons and a resource page leading to outside sources.

##Flashcard Screen

![stickshiftflashcard](https://cloud.githubusercontent.com/assets/25094066/22002403/c9af693a-dc00-11e6-87d9-38db392db705.png)

###Features Overview

* Question & Answer Display

* “Next”, “Back” and “Details” navigation buttons

####Question & Answer Display

![stickshiftflashq a 2 _li](https://cloud.githubusercontent.com/assets/25094066/22004137/2a26eda8-dc0e-11e6-861a-c9ffbfa5400e.jpg)


Description: Displays one question at a time and adds the answer with optional details after the user clicks the screen.

Progress: Text displays each question and answer correctly and in succession

####Navigation Buttons

![stickshiftflashcard_li](https://cloud.githubusercontent.com/assets/25094066/22004133/1ef80192-dc0e-11e6-9542-50b48b2bc516.jpg)

Description: Buttons allow the user to click through the flashcards in order, go back to previous questions and read through additional answer details for the current question.

Progress: The “next” button can be clicked directly on the answer View.  When clicked while the answer is not displayed it will display the answer.  When clicked again while the answer is displayed it will move on to the next question and clear the answer screen.
The “details” button is enabled once the answer is displayed.  When clicked it will go through each page of the details section in succession and then wrap back around to the first answer page.  The button is disabled when the answer is not displayed.
The “back” button will go to the previous question and clear the answer screen.

###Other app screen pages

* Start Screen

* Menu Screen

* Question List Screen

* Resource Screen

####Start Screen

![stickshiftstart](https://cloud.githubusercontent.com/assets/25094066/22002409/c9c33ac8-dc00-11e6-8411-90a64a04120f.png)

Description:  Allows the user to start a flashcard session or go to the settings menu.

Progress: Working buttons.

Working on: Layout appearance.

####Main Menu Screen

![stickshiftmenu](https://cloud.githubusercontent.com/assets/25094066/22002407/c9b257bc-dc00-11e6-8168-c0630ea06d57.png)

Description:  Allows the user to go into either the question list or resources menus.

Progress: Simple appearance with working buttons.


####Question List Screen

![stickshiftquestionlist](https://cloud.githubusercontent.com/assets/25094066/22002406/c9b2006e-dc00-11e6-8cf6-e3b50f555dda.png)

Description:  Allows the user to view all of the flashcard questions and select a specific question to go to on the flashcard screen

Progress: Buttons take the user to the flashcard screen and display the question the user selected

Working on: Redesigning the layout to make the text a clickable button.

####Resource Screen

![stickshiftresources](https://cloud.githubusercontent.com/assets/25094066/22002410/c9c56b40-dc00-11e6-8386-b895e602519f.png)

Description:  Allows the user to either search for driving schools on Google maps or browse instructional videos on Youtube.

Progress:  The map search includes an editText View that will accept up to 35 characters.  If the search button is clicked without a location a toast will pop up to prompt the user to specify a location.  The search button is able to connect to Google maps or display an error toast message if the connection fails.  The video search button is able to connect to Youtube or display an error toast message if the connection fails.

Working on:  Hooking up GPS to the map search so the user can search from their location without needing to type it in.

####Driving Schools Search Map

![stickshiftmap](https://cloud.githubusercontent.com/assets/25094066/22002405/c9b1f39e-dc00-11e6-90dc-c77f64e89ccf.png)

Description:  The user can look at nearby driving schools on Google maps.

Progress:  Google maps is able to load from the stick shift app's resource page and automatically bring up a search for driving schools near the location the user specified on the resource page.

####Instructional Videos

![stickshiftvideo](https://cloud.githubusercontent.com/assets/25094066/22002408/c9c2bada-dc00-11e6-8214-2fd524852e19.png)

Description:  The user can look through stick shift instructional videos on Youtube.

Progress:  Youtube is able to load from the stick shift app's resource page and automatically bring up a search for "stick shift how to"

Working on: Having Youtube automatically play the top video on the result list.

