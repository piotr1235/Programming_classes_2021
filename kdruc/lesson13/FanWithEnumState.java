package kdruc.lesson13;

public class FanWithEnumState {

  enum Speed{
    STOP,
    SLOW,
    FAST
  }

  private Speed state = Speed.STOP;

  MotorController controller;

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
        state = Speed.SLOW;
        break;
      case SLOW:
        state = Speed.FAST;
        break;
      case FAST:
        state = Speed.STOP;
        break;
    }
    update(controller);
  }
}
