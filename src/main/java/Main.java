import singleObjects.Logger;
import singleObjects.SingleObject;

public class Main {
    public static void main(String[] args) {

        Logger l = (Logger)Singleton.get(Logger.class, "sLogger1.log");

        l.log("hi hell!");
        Logger l2 = (Logger)Singleton.get(Logger.class);

        assert l == l2;


        /*
        ((SingleObject)Singleton.get(SingleObject.class)).say();
        SingleObject so = (SingleObject)Singleton.get(SingleObject.class, "aaa");
        ((SingleObject)Singleton.get(SingleObject.class)).say();
        ((SingleObject)Singleton.get(SingleObject.class)).say();
        */

    }
}
