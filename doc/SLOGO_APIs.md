# SLOGO_APIs
Rodrigo Araujo (rea20)
Kyle Brisky (kb325)
Muthu Arivoli (ma381)
Thomas Quintanilla (tq11)
Jackson McNabb (jdm109)

**2 External APIs**
We will have two external APIs, one for the visualization of the turtle on the UI and one for modifying and acessing logic that makes the turtle move.

Axiomatically, the visualization API will be able to call methods to alter the current visualization of the turtle. Methods like .hide, .show, and .reset will allow users to seemlessly interact with the turtle in an intuitive interface. This API will have a number of preset grid types and colors to be accessed as well. In addition, it can feature a class to handle turtle visualization, with methods like .setimage or .hideTurtle.

Similarly, the external API for the logic of making the turtle move will handle all commands entered into the consol like .read, or .ignore. This means that the console input can be directly inputted to this API, and it will hide everything from the user.


**2 Internal APIs**
These API's would be design to allow for the easy implementaion of new features. This would include adding the option for new syntax. It would allow the addition of more visual options ,like addNewImage for the background, or .addTurtleImage for the turtle. It would also be able to add new commands that build off of current ones, like .moveQuickly would move the turtle fadster than the Normative move command


* The user types 'fd 50' in the command window, sees the turtle move in the display window leaving a trail, and has the command added to the environment's history.
    * The moveTurtle() method would be used to accomplish this scenario by changing the location within the turtle class. Then, the turtle class would update the visualizer class, allowing for its change in position to be visually represented.
* The user types '50 fd' in the command window and sees an error message that the command was not formatted correctly.
    * The Parser class would be used to first parse the line of code and then locate that there is a syntax error. It will cease parsing and instead an exception to the ExceptionHandler Class, which will return an error message to be displayed in the front end
* The user types 'pu fd 50 pd fd 50' in the command window and sees the turtle move twice (once without a trail and once with a trail).
    * The methods toggleTrail() and moveTurtle() would be used in the turtle class to update its position and whether or not it has a trail for the display. The turtle class would then update the visualizer class, allowing for it to display the change in position and the trail when needed.
* The user changes the color of the environment's background.
    * The method setBackgroundColor() would be used in the visualizer of the turtle's environment and would take in a color parameter to set the color of the background.
