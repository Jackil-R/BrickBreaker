public enum Commons {

    WIDTH ( 300),
    HEIGHT ( 400),
    BOTTOM_EDGE ( 390),
    N_OF_BRICKS ( 30),
    INIT_PADDLE_X ( 200),
    INIT_PADDLE_Y ( 360),
    INIT_BALL_X ( 230),
    INIT_BALL_Y ( 355),
    PERIOD ( 10);

    private final int value;

    Commons(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}