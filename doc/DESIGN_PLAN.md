# DESIGN_PLAN

## External
We will have two external APIs, one for the visualization of the turtle on the UI and one for modifying and acessing logic that makes the turtle move.

Axiomatically, the visualization API will be able to call methods to alter the current visualization of the turtle. Methods like .hide, .show, and .reset will allow users to seemlessly interact with the turtle in an intuitive interface. This API will have a number of preset grid types and colors to be accessed as well. In addition, it can feature a class to handle turtle visualization, with methods like .setImage or .hideTurtle. There can be a grid class and a turtle class for example to handle the different components of visualization. There won't be much need to read the grid in the turtle class and vice versa; the data types will be hidden. Errors may be thrown in the cases that the XML-read files don't provide recognizable inputs or if inputted commands contain the same unrecognizable data.


Similarly, the external API for the logic of making the turtle move will handle all commands entered into the console like .read, or .ignore. This means that the console input can be directly inputted to this API, and it will hide everything from the user. If the user were to write code that is not formated correctly, it should throw an error repeating the user's command and saying it could not be found. The commands to update the turtle themselves will be made publicly accessible, however the grid object won't be accessible, much like in Simulation. The command methods will be used for communication, sending the view the necessary information to update the turtle based on commands. The coding text will be encapsulated within the parser class, and call the commands corresponding to what the user had in their script.


## Internal
These API’s would be designed to allow for the easy implementaion of new features. This would include adding the option for new syntax. Future programmers should not need to modify our code to add new commands. The APIs would allow the addition of more visual options, like addNewImage for the background, or .addTurtleImage for the turtle. It would also be able to add new commands that build off of current ones, like .moveQuickly would move the turtle faster than the Normative move command. Errors will be thrown if these commands are called incorrectly (e.g. with the wrong parameters) or it interferes with a current method or class logic.

Data closed for modification will be limited. We expect that the main class and entire internal API's will be closed for modification. The only additional code that a user will have to produce is the logic nessesary to add new commands or movement patterns. 

## Introduction
This program will tackle the problem of handling user input, parsing through it, and translating that to movement or a function which controls turtle movement on a grid. The primary architecture of the design at a general level will consist of a back-end and a front-end. The back-end will consist of Turtle class that handles the calculations for the movements of the turtle, whether or not the pen is up or down, indicating if the turtle can leave a trail or not, and handles most of the calculations for the program in general. 

The turtle will then send the calculated information to the front-end, which would consist of a visualizer class that would use a grid or map to read in values and then display the location of the turtle and the color values for each cell/location on the grid.

This leaves us with a few design goals. How the turtle moves will be closed for already written methods, but the visualization class will be able to operate on a number of grid data structures. Commands will also be flexible, in the sense that team members can add, remove, or alter commands using the internal APIs.

## Overview
The four api's that will need to be made are the commands, operations, parser, and variable API's. The commands API will hold all of the possible turtle commands that will create it's movement and drawing logic. This will be externally called by the visual class in order to call external logic from the backend. The operations API will hold all mathematical and boolean logic to be used for designing the turtle's paths. This is chiefly back-end. The parser API will be able to translate the user's written commands and translate it into the command API logic to be then sent to the visualizer to display it. Finally, the variable API will be able to store any data sent to the turtle by the operations API. A basic, colorful illustration is depicted below.

![](https://i.imgur.com/rT1ChRB.jpg)


Describe two different implementations & design method signatures approriately... 

## User Interface
The user will be able to write in a textbox along the right of the window and there will be a grid with the turtle to the left of the textbox, showing the results of any functioning code written in the textbox. There should be a menu row at the very top where the user can switch languages and run the program. At the very bottom of the textbox section, there will be a designated help button to allow the user to get a description of all commands and what they do. Any errors will be represented with a pop-up box explaining the error that was triggered. 

![](https://i.imgur.com/7vxdV76.jpg)

## Design Details
The three classes that will be necessary will be for this project will be the turtle, parser, and visualizer class. The parser class will parse all the of the commands written by the user and translate it into commands usable by the turtle. The visualizer will then display the commands that the turtle will follow and reflect it on the display. More classes will be needed to represent the operations and commands for the turtle class, and they should be added as needed.
The core of the code will be based on abstraction of an executable class. The visulized will be able to construct the runnable code from the recieved string by careful parsing. The backend can parse the recieved code into a tree heiarchy of Executable classes and can return a runnable Executable. That return will be able to take in a class that interfaces with the Visulizer. This interface will be handed through the class structure which will allow the backend to run nessissary commands on the visualizer.
The visualizer will only recieve relevant information through the backend and will have to figure out what to display based on this. The Backend will only tell the Frontend when the turtle moves, one of the states change or important visual information like clear screen. 


## API as Code

In considering a framework of API's to complete this project, it may be useful for the parser to access an executable class that will allow us to partition off commands which can compartamentalize what we send to both illustrate the turtle in visualization and calculate the logic without sending data to any other class. This means that a command API will act as a "backend" internal API, while calling external "frontend" API's to govern movemement/illustrations. The visualization classes will be simple. Public methods will be called appropriately from the executable-called command and will internally interact with the turtle object to move it or illustrate the change.

Some of the exceptions that will be needed to throw include any typing errors by the user if they input the wrong command, throwing errors for importing the wrong files, or throwing errors for asking for impossible tasks (such as dividing by zero).

For the given Use Cases, UI command will pass any command, including "fd 50," to the parser, creating an appropriate executable which calls the cooresponding command and visualization methods. If the user wished to set the pen color, the UI will parse, and would still create a command object, but instead of changing the turtle object, the command class would call the appropriate methods in only visualization to change the color. All commands written through the UI line will be handled through this workflow.

## Design Considerations
Each class, should have a single responsibility. For example, the turtle class should only have the responsibility of handling the logistics for the turtle's movements and whether or not a trail is being drawn at that moment. All of the command classes should be open for extension and closed for modification, meaning that their logic should be unchanging; however, they should be inheritables by all classes that are dependent on them (such as the turtle class or parser class).

It will be important to be open to having multiple abstract classes to accomplish specific goals, rather than attempting to have one large abstract class to try to fit all of the goals. For example, it would be best to have multiple small abstract classes for different types of visualizations (such as implementing a finite, torroidal, or infinite grid) rather than having one large abstract grid class to accomplish all of these roles. 

## Team Responsibilities
Rodrigo - Work on visualization (front-end)
Thomas - Work on visualization (front-end)
Kyle - Back end and parsing
Jackson - Controller interface
Muthu - Controller interface


