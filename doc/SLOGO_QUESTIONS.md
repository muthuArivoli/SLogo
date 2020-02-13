# SLOGO_QUESTIONS
Rodrigo Araujo (rea20)
Kyle Brisky (kb325)
Muthu Arivoli (ma381)
Thomas Quintanilla (tq11)
Jackson McNabb (jdm109)
### When does parsing need to take place and what does it need to start properly?
Parsing happens after the written code is complied and it needs all the written code to be error free.

### What is the result of parsing and who receives it?
The result of parsing is the written code being translated by the API, which then gets received by the turtle and results in its movements.

### When are errors detected and how are they reported?
Once parsing has begun, the parser will first detect any syntax errors and invalid arguments to functions. This will result in UI text, alerting the user to the error in their command.

### What do commands know, when do they know it, and how do they get it?
Commands know what has been assigned to them by the API. They know it once parsing has been done. The commands would get this information once being passed the parsed code from the user.

### How is the GUI updated after a command has completed execution?
The GUI would get updated by showing the change in location of the turtle. Text also appears indicating the ability for another command.
