parser
====

This project implements a development environment that helps users write SLogo programs.

Names:
* Rodrigo Araujo
* Jackson McNabb
* Kyle Brisky
* Thomas Quesadilla
* Muthu Arivoli


### Timeline

Start Date: Feb 22, 2020

Finish Date: Mar 7, 2020

Hours Spent: 120+

### Primary Roles
* Kyle: I worked primarily on the back-end, initialy working on a system to be able to read a logo file and execute commands on a dummy class that would become a template for a front-end api based on what we had disscussed. Although not recommended I went for a recursive parsing of the input code which would return a single class that would function as running the entire code on the front-end api. Then I created a simple back-end api that function as an interface to deal with anything necessary like changing language. I then ended up creating the front-end api which basically had control over the visuals (turtle and lines) and implemented all the necessary functionality for fully working control with the back-end. I also spent a lot of time refactoring the front end by having a single class deal with the buttons and using injection to correctly format them in the visualizer. I made sure that many of the front-end component functioned correctly with the back-end and front-end api.
* Jackson: I helped everywhere help was needed, but Muthu and I prioritized the configuration between Kyle's work and the front end throughout the project's development. Designing, implementing, and updating the turtle interface, consolidating to make backend and front end API's for designing access, and masking inheritance with general class hiding and configuration, etc. were all things on our plate, for example. I also chiefly worked on the XML file and handling errors to be printed on Alert boxes instead of console errors. I also specifically patched hard-to-tackle backend problems, like setting the turtle image. We also both led the charge on considering macro-code design structure and eliminating Code Smells throughout the project.
* Rodrigo: I worked on the front-end portion of the project with Thomas. For the BASIC implementation, the UI was split into three classes, but for the COMPLETE implementation, I worked with Thomas on breaking those three down into more specific classes to achieve the required features. For example, historyView was changed into a TextFlow and implemented hyperlinks to allow the user to access older scripts ran in the console. The pen, palette, and help buttons were added to the workspace and their functionalities were added as methods to the appropriate classes in the Visualizer folder.  
* Thomas: I worked mostly on the front-end with Rodrigo. Since we were working together, we decided to divy up the work in sets of features. Therefore, the commits made by me may seem sporadic. Some of the main implemented features I worked on in the front end include implementing the VariableViewer table, activatable turtles, and controlling the Turtle through the UI. Many of the components were separated into separate classes so that we could better separate the internal and external frontend APIs. I also served as the Git expert of the group, where I helped teammates handle merge conflicts and explained basic Git etiquette, and handled much of the refactoring that took place near the later stages.
* Muthu: I worked with Jackson and primarly helped where needed. I also did error handling with getting the errors to show up as visual alert boxes in the GUI as well as some of the overall design of how the backend and the frontend would work together, like defining how the overall Turtle interface would work. I also helped with refactoring the code and abiding by good design practices, to ensure that our code would remain extendable and modular. I also assisted with the XML file handling and developed code to allow for us to create workspaces.

### Resources Used
Turtle icons are located within the resources folder, where there are four different turtle icons to use and one greyed out icon to showcase a deactivated turtle. Also the data folder contains the xml files that will be saved and loaded into. Also, within the data folder, there is a folder called examples, where the user can run those predefined examples on the program.  

### Running the Program

Main class: Main

Data files needed: data and resources folders

Features implemented:
* click to execute commands from the history or user-defined commands (provide a means to enter needed parameters)
* click to edit the value of user-defined variables
* click to toggle which turtles are currently active (active turtles should be graphically distinct from inactive ones)
* provide a way to move the current turtle(s) graphically (at least FD, BK, LT, and RT by a fixed amount)
* provide a way to change the pen's current properties graphically (up/down, thickness, etc.)
* hovering the mouse over a turtle will show the specific turtle's properties.
* the user can save and load files that contain the script, turtle properties, number of turtles, background color, and more.
* added the option to change background color of the turtle view.
* add the option to change languages to write the script in.
* Save and load local turtle environments to XML files in the /data folder. You can save background and pen colors, preferred number of turtles and preferred current text to be ran immediately at program start in the script box.



### Notes/Assumptions

Assumptions or Simplifications:

Interesting data files: 
Within our data folder, there is a folder called, "examples." This is full of different premade scripts that make cool designs. These are given. Additionally, there is a Showcase file that showcases the XML saving capabilties.


Known Bugs:
* Turtle goes slightly beyond the group pane and draws over the script box and behind some buttons.
* Creating a variable with a number in the name ends in a nullpointerexception.

Extra credit:
* XML Saving/Loading
    * saves quality of life elements like
        * pen color
        * background color
        * number of turtles
        * current commands in script
    * Can be easily scaled up to integrate any component of the Visualizer, as shown in commented PastScript code.


### Impressions

Rodrigo: During the planning phase of this project, we learned that each one of us had worked on the backend portion of the last project. Knowing that we had a strong backend team, I wanted to pursue working on something I had relatively little experience in: frontend. As the project nears its finishing touches, I reflect back on that decision and think it was a great choice. Although I definitely struggled with learning all of the logic for javafx frontend, I believe this experience has helped me become a more well-rounded coder. 

Kyle: I was very intrigued by the idea of using code to be able to read and execute a different coding language so I very early on jumped into the back-end to test out some theories I had about how it should work based on what we had discussed as a group. I kinda got sucked in and while my solution was not the recommend aproach I was very happy with what I had working and since implementation didn't matter as long as my api did what it needed to, I decided to run with a recursive parsing and abstract class building method. Getting the code working was exremely fun and I ended up working quite a bit with the front end too because I wanted the APIs and code in general to feel very clean when used. Given more time there are still tons of changes I would make to the back-end. The parser is still a bit of a mess and could made into a much simpler class. I liked having a class for each operation being an abstraction of a overall Executable class but I think with better use of abstration and organization I could make everything more straight forward, cleaner and have overall better code. I used a bad form of reflection before I really understood it to construct classes but after it was finished and working it was never a priority to fix it so it remains as is but could be much much better. As it stands right now creating a new command requires another class and a string to be added to a different class seperately which shouldn't be the case. given more time I would have added a robust error checker that could report good information and line number where the error occured. I would also have loved to be able to handle recursive user made functions but given the way the code was created it would have required a complicated way to create a stack that would keep track of past information and time didn't allow it. more casting was used than I realy wanted to and I think if I had, as said early, created better layers of abstraction I could have avoided it entirely. I had origanally planned for handling more than one turtle so it wasn't too hard to implement that but since I want askwith to be able to run any level of complex boolean functions I had to be able to run commands on turtles indivdually which I accomplished by using an interface that both the turtles and the front-end api implemented so that either could be used with the backend but since there were tons of methods that the api could do but the turtles couldn't (like any multiple turtle command or things like changing backgound color) the turtle class ended up with a ton of methods that would essentially just give an error if they were ever called which I really didn't like and I think could have been easily fixed with either a better understanding of interfaces or an more robust backend system. All in all I really liked working on this project and am really happy with what I accomplished but by no means would I call what I managed to do complete and I know I could spend hundereds of more hours fixing and cleaning this project.

Thomas: Overall, I felt that this project was much tougher than Simulation in terms of keeping a clean design. I wasn't really accustomed to working on UI, and that coupled along with working with mutliple people on the same files, made it hard to follow a clean design pattern. Also, to me it felt as if we had miscalculated how the design would work during the planning phase, so much of basic was patching up our design through "hacky" ways. We had a strong backend to work with though, and that eased the stress off of frontend work. Overall, I felt this project was an eyeopening experience for me, as it revealed how much room for improvement I have in coding.

Jackson: On balance, because parts of the project were less calcified in the UI, it was less enjoyable than game or Simulation. Nonetheless, working with a team of smart, dedicated 308er's was a phenomenal experience, and I would love to do it again. I received the organizational brunt of the project, which was fun and gave me a chance to call some shots. Because of this, I worked on configuration, and all together, gave me a great experience of seeing the front end integrate with the backend, and how to use patterns to do so. I generally got to work on what I wanted to initially, and then would go to work on things that still needed to be done past deadlines for others, which, because I worked with so much opportunity, code components, and people, this project was great! I can easily point to a lot of examples through the project of things that I would not have even considered before! 

Muthu: This project was a new experience for me, working in a larger team than I had before. I was however able to oversee the overall integration of the backend with the frontend, thus I believe that I was able to learn many new skills through this project. The design of the code was one of the most important parts of the integration, since it would have been very easy to write code that was not modular and did not properly separate the backend and the frontend, and thus I believe that although I may not have wrote as much code as I had in the previous projects, I still had an equal amount of tough design challenges to solve when trying to design and write the code.

