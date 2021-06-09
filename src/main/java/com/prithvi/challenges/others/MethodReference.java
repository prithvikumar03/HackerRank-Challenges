package others;

interface Sayable{
    void say();
}
public class MethodReference {
    public static void saySomething(){
        System.out.println("Hello, this is static method.");
    }

    public void saySomeOtherThing(){
        System.out.println("Hello, I am an instance method");
    }

    public static void main(String[] args) {
        // Referring static method
        Sayable sayable = MethodReference::saySomething;
        // Calling interface method
        sayable.say();
        
        MethodReference methodReference = new MethodReference();
        Sayable sayable1 = methodReference::saySomeOtherThing;
    }
}
