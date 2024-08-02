# Modern Toggle Switch for JavaFX

A sleek and customizable toggle switch for JavaFX applications.

## Features

- Modern design
- Customizable appearance
- Smooth transitions
- Easy integration

You can change the color in the code or modify it to accept color as a parameter.

## Use Example

```java
ToggleSwitch toggleSwitch = new ToggleSwitch();

hbox.getChildren().add(toggleSwitch);
toggleSwitch.switchedOn().addListener((obs, oldState, newState) -> {
    booleanValue = !booleanValue;
});
        
This code initializes a custom ToggleSwitch, adds it to a user interface container (HBox), and sets up a listener to respond to changes in the toggle switch's state. When the switch is toggled, the drawPossibleMoves variable is inverted, allowing you to control application behavior dynamically based on the switch's position.
```

 ![image](https://github.com/user-attachments/assets/ddf9965e-ca74-40d8-8fa0-1d0341260a06)
 ![image](https://github.com/user-attachments/assets/63419daa-5194-4077-a2d7-44c83adc684a)

 Feel free to tweak any part as needed!


