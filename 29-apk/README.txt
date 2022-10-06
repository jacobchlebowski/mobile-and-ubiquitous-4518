Permissions

Jacob Chlebowski - jachlebowski@wpi.edu
Zaq Humphrey     - zihumphrey@wpi.edu



Permissions Requested by this app:
-CAMERA 		"android.permissions.CAMERA"
-RECORD_AUDIO		"android.permissions.RECORD_AUDIO"
-WRITE_EXTERNAL_STORAGE	"android.permissions.WRITE_EXTERNAL_STORAGE"


Type of Each Permission:

-For the CAMERA permission, it's type of permission is a RUNTIME 
PERMISSION. This is because the camera is dangerous for exposing
sensitive information about the user. This poses a great risk to
the user's privacy.


-For the RECORD_AUDIO permission, it's type of permission is a
RUNTIME PERMISSION. This is because you're essentially giving
potential permission for invasion of user's privacy. This poses a
great risk to user's privacy even if its main intention was to audio
record certain things presented by the user. Ultimately, you never
know if it will be audio recording when the application is not
in use by the user. It is dangerous, and a risk to privacy user data.


-For the WRITE_EXTERNAL_STORAGE permission, it's type of permission
is a INSTALL-TIME PERMISSION. This is because you're giving
restricted access to WRITE to EXTERNAL storage. The permissions 
will be granted when installing the app. In other words, you will
be choosing where to write data (in storage) when installing.
For this particular permission, it is probably a NORMAL INSTALL-TIME
PERMISSION since it poses little risk to the user's privacy. It
only WRITES and not READ any user information.




All information on permissions found on https://developer.android.com/guide/topics/permissions/overview