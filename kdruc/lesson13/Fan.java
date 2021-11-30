package kdruc.lesson13;

public class Fan {
  // just one button -> stop, slow, fast, stop
  int num = 1;

  void click(MotorController controller) {
    num++;
    if (num == 4) num = 1;
    if (num == 1) controller.stop();
    if (num == 2) controller.setSlow();
    if (num == 3) controller.setFast();

  }
}
