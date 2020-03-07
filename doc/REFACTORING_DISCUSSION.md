# REFACTORING_DISCUSSION
Rodrigo Araujo (rea20)
Kyle Brisky (kb325)
Muthu Arivoli (ma381)
Thomas Quintanilla (tq11)
Jackson McNabb (jdm109)

## Issues Found

We have a few issues, but we had prioritized fixing these later to allow for easy testing. Namely, we are printing stacktrace at multiple locations. Also, we are not using the abstract collection for objects, like Hashmap instead of maps and we do have some magic numbers for button locations and hardcoding the front end locations. Lastly, we have a few static variables that aren't final as well as some superfluous and redundant variables that were previously used and will not be used for the final implementation. Most of these issues are because we are currently working on features and will clean up uneeded code once it is realized that it is unused.

## Refactoring

All of these require minimal changes, like deleting variables, changing access, and reformatting hard coded strings to property files, for example. Macro-structure design will be discussed more in depth in the API_CHANGES doc, but for issues found through this tool, nothing is disheartening for the macro-design strucutre of the program. It is useful to look for code that is no used.

