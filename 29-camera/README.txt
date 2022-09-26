Basic Camera

Jacob Chlebowski - jachlebowski@wpi.edu
Zaq Humprhey	 - zihumprhey@wpi.edu


This assignment allows you to take a photo, or retake a photo, and
save it to a directory while also displaying on the screen. We also save the 
meta-data of the application to another directory. If the user of the application
does not have these directories, they are created upon taking photos. More
is described below.


Requirements Satisfied:
-Project has a unique name ("Basic Camera")
-Our android project is NOT a direct copy and paste of the CameraIntent demo. We used some components as necessary, but did NOT build from the demo. Instead, we started from scratch.
-Our app provides the simple feature of taking a photo. The screen includes an ImageView for previewing the image and a capture button. A retake option is also available while taking the photo.
-Our app implements a fileprovider for the built-in camera app to store the image (activity_main.xml and MainActivity.kt)
-We use implicit intent method to implement the photo-taking feature (MainActivity.kt)
-Our app stores the photos in its internal storage with the following directory structure: data/data/com.example.basic_camera/files/cs4518_photos/
-For each photo taken, we also keep track of a piece of metadata about the photo. We logged the DATE/TIME the photo was taken. Our app's metadata is within the app's internal storage within the following directory: data/data/com.example.basic_camera/files/cs4518_logs/

-As seen in the recording (.webm), we take 3 photos, and our directories have a total of 6 files (3 photos, 3 logs) in their respective subdirectories. The files for the subdirectories are located in our (.zip) submission.
-MAKE SURE FILES ARE DELETED MANUALLY Used app to take at least three photos and take a screenshot of the Device File Explorer that shows the files, 6 files total in EACH subdirectory
-Downloaded the "files" directory and included it in the assignment submission.
