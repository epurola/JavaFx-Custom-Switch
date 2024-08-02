private static class ToggleSwitch extends Parent {
    private BooleanProperty switchedOn = new SimpleBooleanProperty(false);
    private TranslateTransition transition = new TranslateTransition(Duration.seconds(0.25));
    private FillTransition fillBackground = new FillTransition(Duration.seconds(0.25));
    private TranslateTransition moveText = new TranslateTransition(Duration.seconds(0.25));
    Color moveHelpColor = Color.web("#7B61FF");

    private ParallelTransition animation = new ParallelTransition(transition, fillBackground, moveText);

    public BooleanProperty switchedOn() {
        return switchedOn;
    }

    public ToggleSwitch() {
        Rectangle background = new Rectangle(50, 25);
        background.setArcHeight(25);
        background.setArcWidth(25);
        background.setFill(Color.WHITE);
        background.setStroke(Color.LIGHTGRAY);

        Circle toggle = new Circle(12.5);
        toggle.setFill(Color.WHITE);
        toggle.setStroke(Color.LIGHTGRAY);

        Text text = new Text("Off");
        text.setFill(Color.BLACK);
        text.setStyle("-fx-font-size: 12;");
        text.setTranslateX(-12);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(background, toggle, text);
        StackPane.setAlignment(toggle, Pos.CENTER_LEFT);  
        StackPane.setAlignment(text, Pos.CENTER);         

        stackPane.setPrefSize(50, 25);
        transition.setNode(toggle);
        fillBackground.setShape(background);
        moveText.setNode(text);

        getChildren().add(stackPane);
        switchedOn.addListener((obs, oldState, newState) -> {
            boolean isOn = newState.booleanValue();
            double toggleTargetX = isOn ? 50 - toggle.getRadius() * 2 : 0;
            double target = isOn ? 12.5 : -12.5;
            transition.setToX(toggleTargetX);
            fillBackground.setFromValue(isOn ? Color.WHITE : moveHelpColor);
            fillBackground.setToValue(isOn ? moveHelpColor : Color.WHITE);
            moveText.setToX(target);
            text.setText(isOn ? "On" : "Off");
            text.setFill (isOn ?moveHelpColor :Color.BLACK );
            

            animation.play();
        });

        setOnMouseClicked(event -> {
            switchedOn.set(!switchedOn.get());
        });
    }
}
