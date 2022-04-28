package kdruc.testing;

public class Add implements IAdd {
    public int add(int a, int b){
        return a+b;
    }

    public boolean isEven(int a){
        if(a%2 == 1) {
            return false;
        }else{
            return true;
        }
    }
}
