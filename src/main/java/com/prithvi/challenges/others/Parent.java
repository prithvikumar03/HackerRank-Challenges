package others;

public class Parent {
public int i = 100;

    public String get(){
        return "PARENT";
    }

    public static void main(String[] args){
        Parent p = new Child();
        System.out.println(p.get());
        System.out.println(p.i);

    }
}

class Child extends Parent{

    public int i = 999;

    public String get(){
        return "CHILD";
    }
}
