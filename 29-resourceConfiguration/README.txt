Simple Calculator Resrouce Configuration

Jacob Chlebowski jachlebowski@wpi.edu
Zaq Humphrey 	 zihumphrey@wpi.edu

Simple Calculator Resource Configuration. Our application satisfies the necessary requirements.

We use a Simple Calculator app which we created and are adding more onto. We utilize a local variable, "outState", which keeps track of the application state. 
For example, when we input numbers into the calculator and flip to a landscape, the numbers stay where they are. In our logcat.png photo, every time onCreate() 
is called, our onSavedInstanceState() or onRestoreInstanceState() is also called. With our local variable, we are able to save and/or restore our data whether we 
are in portrait or landscape mode. In our video of our emulation, upon screen rotation, our data is saved and restored correctly.

Sequence of events upon screen rotation (also in logcat.png):
1) onCreate()
2) onSavedInstanceState()
3) onCreate()
4) onRestoreInstanceState()

image-url: https://www.calculatorsoup.com/calculators/math/basic.php