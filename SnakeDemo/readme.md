## Snake
### (known)Bugs
- Can't immediately change direction (when the head and the tail change their positions(up-down) and *= - 1, or (left-right) and *= -1,...)
- Some half-food ( I mean the half of the rectangle) may spawn out of the windows despite of I tried to fix this with constants,but snake also can moving halfly (horizontally cut half) at the bounds
### Further Development Opurtinities
-   Could add more GUI:
    - Buttons:
      - Restart:
        - In the keyPressed() method you basically need to add another if statemant that, when curretn state is END, sets tha state back from END to either START or </br> calss the start game method after any key is pressed. Don't forget to you also need to need to replace the player w a new Snake object so that the game doesn't end instanly
        - ...
    - ...
- ...    
