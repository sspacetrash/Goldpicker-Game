PROJECT TITLE: Goldpicker game
HOW TO START THIS PROJECT:
AUTHORS: Ng Hoi Ching Samantha
USER INSTRUCTIONS: Run the goldpicker test class to begin the game. There should be instructions that tells you how to play the game.

FEATURES OF THE GAME(SKILLS IMPLEMENTED):
1. Mode selection
The user can select either going to Score Mode or Survival mode.
Surivial Mode: Player has three lives, with they selected the rectangle wrongly 3 times, it ends the game.
Score Mode: When the score reaches up to 10, it ends the game. It is more a relaxed gameplay.

2. Color randomization
Every time the mouse is clicked, the color of the rectangle changes.

3. Position randomization
The rectangle randomizes it position every time when the user clicked the panel.

Tests ran:
1. Boundary Checker and Overlap checker
I have set up booleans to update the status of my paintComponent.
Boundary Checker:
xbounds = tests if the x coordinate exceeds the boundary, returns true ybounds = tests if the y coordinate exceeds the boundary, returns true

Overlap Checker:
overlap = if the rectangles’ overlap with each other, returns true
(use the width and height of a rectangle as a counter for a for-loop, in the loop, it tests if the coordinate matches with the other rectangles in the array.
And then set up a while loop, if any of of the boolean returns true, regenerate the location of rectangles again until it is within boundary. Did not work.
Solution: Abandon booleans, set a maximum value for the generation of rectangles’ coordinates, so it doesn’t go out of bounds.

2. Color theme selection
Buttons are originally set up to provide different sets of color themes for rectangles’ color. A string variable is set in StatusPanel class originally to store the selection of the color mode by the user.
Then it is passed to Goldpicker class, with the use of switch statement, it will recognize which sets of color should be applied.
