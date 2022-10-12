Implementation

Jacob Chlebowski - jachlebowski@wpi.edu
Zaq Humphrey 	 - zihumphrey@wpi.edu


RUN/INSTALLATION INSTRUCTIONS (server)
==========================================================================================
1) Open `main.py` in VSCode (main.py is located in `/29-implementations/Server`)
2) Click "run" to run `main.py`
3) If it doesn't run:
	-->cd to `/29-implementations`
	-->run `pip install -r requirements.txt`
	-->Try again

NOTE: The server must be running in order for the "DATES" Implementation to work properly
==========================================================================================




NEW/MODIFIED SECTIONS REPORT
===============================================================================================
Since the midterm (requirements) report, we have changed our implementation for the better.

Added:
-CardioActivity (cardio workouts)
-CoreActivity (core workouts)
-LowerActivity (lower body workouts)
-TimerActivity (60 second timer, saves data upon screen rotation)
-RecyclerAdapter (adding dates via CalendarView)
-MongoDB
-Fully functional python server `main.py` for POST, DELETE, etc. data to and from MongdoDB database


Removed:
-Outlook Calendar API in exchange for Pymongo and Volley API
-

Modified:
-Activity bar on bottom (removed outlook calendar button)
-Date input to CalendarView so only valid dates are accepted into the database

==============================================================================================





REQUIREMENTS SATISFIED
========================================================
Baseline Goals:
-Screens are implemented (MainActivity, CardioActivity, CoreActivity, LowerActivity, SecondActivity, ThirdActivity, TimerActivity) 
-Viewgroups are implemented (ex of a few: RecyclerView, TextView, CalendarView
-Intent extras are used when favoriting a workout for example. The intent is switched upon favoriting activities. The intent extra is the workout that is being favorited.
-Screen rotation is accessible on the `TimerActivity.kt`. The timer time saves upon rotation.
-For long-term storage (SEE IN TECHNICAL ACHIEVEMENTS), we use a client/server interaction where the server contacts MongoDB (a longterm database storage)
-For sensor, we implement a sensor that allows you to log your workouts efficiently
-Networking/Fetching is utilized within the server/client implementation. For the dates specifically, upon an automatic GET request, you have the additional option to POST and DELETE dates from the client/server, which also interacts with the long-term storage database.

Non-functional:
-The application has good performance due to the simple and structured UI design. The treshold for performance might entail a user "spamming" too many dates. In other words, when a user performs too many requests. Performance is also great because data is stored on MongoDB and NOT locally.
-The security of our application is acceptable. Data is stored within the MongoDB long-term storage database and is NOT stored locally at all. That way, if anything happens to the user's local device, MongoDB will still have the data stored securely.

Professionalism:
-No uncommented code or chunks of code that aren't used. Professional write-up.

TECHNICAL ACHIEVEMENT #1 - UI
-For our UI technical achievement, we utilized a RecyclerView that gets its information DIRECTLY from a database. Deleting in the RecyclerView will ALSO delete data from the database as well. This is proficient for UI technicality because our UI and database implementations are working together.

TECHNICAL ACHIEVEMENT #2 - System Design
-For our system design technical achievement, we make use of the MongoDB (cloud database), which is used mainly for our system security, but also helpful for storing information NON-locally.

=======================================================



