package singleObjects;

public class SingleObject {
    private String data;

    public SingleObject() {
        data = "no params";
    }


    public SingleObject(String s) {
        data = s;
    }


    public void say() {
        System.out.println("Single Object " + this + "with data " + data);
    }
}
