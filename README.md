# robot
A robot team builds a different robot every season for a robotics competition. There are several types
of drive systems they use. In all cases if all inputs are neutral the robot doesn't move.
- Swerve Drive, unable to rotate
  - Uses a single joystick
    - Forward moves 1 unit forward
    - Backward moves 1 unit backward
    - Left moves 1 unit left
    - Right moves 1 unit right
- Arcade Drive, unable to rotate in place
  - Uses a single joystick
    - Forward moves 1 unit forward
    - Backward moves 1 unit backward
    - Left moves 1 unit left and 1 unit forward, rotates 90 degrees left
    - Right moves 1 unit right and 1 unit forward, rotates 90 degrees right
- Tank Drive, able to rotate in place
  - Uses 2 joysticks
    - Both sticks forward moves 1 unit forward
    - Both sticks backward moves 1 unit backward
    - Left forward, right backward turns 90 degrees to the right in place
    - Left backward, right forward turns 90 degrees to the left in place
    - All other combinations fail to generate enough power to move the robot and are ignored
- Omni Directional Drive, able to turn in place
  - Uses 2 joysticks
    - Both sticks forward moves 1 unit forward
    - Both sticks backward moves 1 unit backward
    - Left forward, right backward turns 90 degrees to the right in place
    - Left backward, right forward turns 90 degrees to the left in place
    - Left stick forward moves 1 unit forward and 1 unit right, rotates 90 degrees right
    - Right stick forward moves 1 unit forward and 1 unit left, rotates 90 degrees left
    - Both sticks left moves 1 unit left
    - Both sticks right moves 1 unit right
    - All other combinations fail to generate enough force to move the robot and can be ignored
    
The team has requested that a RobotDriveTrain module be created which will read a file containing a
set of instructions and exercise a robot. The file will consist of a list of joystick inputs.
- L - Left
- R - Right
- F - Forward
- B - Backward

In the case of a single joystick the file will contain one instruction per line, with each line terminated by
the system defined newline character. In the case of a two joystick configuration the file will contain
the instruction for the left stick followed by a comma and then the instruction for the right stick.Example of Single Stick Instructions:
```
F
R
F
F
```
Example of Double Stick Instructions:
```
F, F
F, B
L, L
R, R
```

The robot will be placed on a 5 x 5 square grid using north, south, east and west to indicate the robots
orientation. The north-west corner of the grid is `(0,0)` with the first value representing the north/south
position and the second value representing the east/west position. The north-east corner is `(0,4)` in this
system, the south-west corner is `(4,0)` and the south-east corner `(4,4)`.

The robot should move by indicating its position and orientation. 
The robot will always begin at `(0,0)` facing east and should always outputthis as a starting position.
