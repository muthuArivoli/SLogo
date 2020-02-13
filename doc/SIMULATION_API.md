# simulationAPI
Rodrigo Araujo (rea20)
Kyle Brisky (kb325)
Muthu Arivoli (ma381)
Thomas Quintanilla (tq11)
Jackson McNabb (jdm109)
## External
Our external API would be able to start and return information about requested simulations.
For example, someone using the external API would be able to call predprey simulation and be able to edit the starting configurations of that simulation. Some example of methods that we would include are:

.createSimulation(Grid, Type) this would create a new simulation using the given grid and simulation type.

.runSimulation() would run a simulation of a preset logic, like fire or predprey. This would then seemlessley show up for the user to see. This would update values in the given grid.

Question: external: as a client of the backend, the frontend selects an existing simulation to display and then starts running that kind of simulation, updating its own grid visualization

The frontend is able to create a new simulation with their grid and their requested type. They could then run the simulation which would update their grid each cycle.




## Internal
Our internal API will be able to extend, add, or modify simulations so that any change can be made to the existing external API behaviour or simulations. This internal API will contain the following methods, for example:

.changeSimulationThreshold() for example, would be able to directly change the logic of how the rule set determines the change of state for cells.

.getNeighborType() or .setNeighborType() would be able to index neighbors in a number of ways, like 8 nearest neighbors, or just the cardinal four.

.setGridBorderType() would set the border color or boldness.

.setNeighborWrapping() would be able to set whether cells on the border of the grid would interact with their opposite border.

.setAllCellsToNewState() would be used in the writing of logic for the cell rules to restart a simulation.

Question: internal: a new developer joins the the backend team and adds a new possible kind of simulation that can be available for the frontend to choose

The new developer would have to extend the simulation class and then override the rules for the new simulation. They could use the internal API to get useful information and tools to update the grid with their defined ruleset.
