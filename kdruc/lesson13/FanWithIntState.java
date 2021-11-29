package kdruc.lesson13;

public class FanWithIntState {

  private static final int STOP = 0;
  private static final int SLOW = -3;
  private static final int FAST = 10;

  private int state = STOP;

  // updates motor speed with current state
  void update(MotorController controller) {
    switch (state) {
      case STOP:
        controller.stop();
        break;
      case SLOW:
        controller.setSlow();
        break;
      case FAST:
        controller.setFast();
        break;
    }
  }

  // changes the state to the next one
  void click() {
    switch (state) {
      case STOP:
        state = SLOW;
        break;
      case SLOW:
        state = FAST;
        break;
      case FAST:
        state = STOP;
        break;
    }
  }
}
