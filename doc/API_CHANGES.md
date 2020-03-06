# API_CHANGES
Rodrigo Araujo (rea20)
Kyle Brisky (kb325)
Muthu Arivoli (ma381)
Thomas Quintanilla (tq11)
Jackson McNabb (jdm109)

## Internal
The internal API looks a lot like how we described in our outline file done before starting the project. We built a Turtle interface to allow for the inheritance of public methods to be used by the command implementation of the parser. This proved to be a useful internal API because as the additional assignments came for Complete, we seemlessly added new methods to accomodate for changes to the turtle object becoming a list. Similarly, we don't have a reified internal API, but it takes a similar form to what we outlined in the design document. This is because the front end API doesn't need to be scaled up an entire degree like the backend and would only require interaction with the backend external API to get these functions completed.



## External

Both external API's work exactly as intended and are clearly labeled in .slogo. The external backend API works to give front end needed methods for using commands for moving the turtle via the buttons for example. It also contains the methods wanted for calculating the turtles' positions and manipulating turtle locations on the backend alone. The front end API contains the nessessary methods to be used for the manipulation of the front end depending on the backend. Both of these API's allow for easy scalling to add new functionality and new features, as they seemlessly integrate with the Workspace class to allow for all variables and classes to interact.



