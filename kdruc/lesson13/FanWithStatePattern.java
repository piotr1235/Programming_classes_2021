package kdruc.lesson13;

public class FanWithStatePattern {

  interface FanState {
    void update(MotorController controller);
    void click();
  }

  class Stop implements FanState{
    @Override
    public void update(MotorController controller) {
      controller.stop();
    }

    @Override
    public void click() {
       state = new Slow();
    }
  }

  class Slow implements FanState{
    @Override
    public void update(MotorController controller) {
      controller.setSlow();
    }

    @Override
    public void click() {
      state = new Fast();
    }
  }

  class Fast implements FanState{
    @Override
    public void update(MotorController controller) {
      controller.setFast();
    }

    @Override
    public void click() {
      state = new Stop();
    }
  }

  private FanState state = new Stop();

  void update(MotorController motorController){
    state.update(motorController);
  }

  void click(){
    state.click();
  }
}
