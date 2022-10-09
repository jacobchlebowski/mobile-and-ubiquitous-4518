SQLite

Jacob Chlebowski - jachlebowski@wpi.edu
Zaq Humphrey	 - zihumphrey@wpi.edu


For this particular project, we did NOT extend RecyclerViewRoom demo,
but instead started from scratch and took a different approach rather than
using the "Room" library.


NOTE: Table creation with key and columns are in "SQL_Helper.kt" and a .png is also 
available ("table_creation.png")

=====================================================================================================================================================

Requirements Satisfied:
-Project has a unique name ("SQLite")
-Project is NOT a direct copy and paste of the RecyclerViewRoom demo. We started from scratch.
-The database has a different name from the default Kotlin entity class name

-On our different approach, our "columns" in this case are the id (KEY), name, and email.
SQL_Helper.kt shows ALL of the efforts in creating a table with 3 columns are in
SQL_Helper.kt.

-The application provides the feature of interacting with the database table with the four SQL statements. 
     -INSERT occurs when the "Add" button is interacted with. 
     -SELECT occurs when the user taps on an ITEM in the table. 
     -UPDATE occurs when the user SELECT's the item from the table, makes changes, then interacts with the "Update" button
     -DELETE occurs when the "Delete" button is interacted with on an item

-UI design has no constraints. Everything works as intended since users can interact with the 4 SQL types. Application displays resulting information in the UI.

-------------------------------------------------------------------------------------------------------------------------------------------------

Recording Requirements Satisfied:
-The table starts with three rows before the illustration (ID, NAME, EMAIL)
-Downloaded the table via Device Filer Explorer
-Recorded necessary workflows as we saw fit




