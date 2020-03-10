import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Singleton {
    private static Singleton singleton;

    private Map<Class, Object> elements = new HashMap<>();


    public static Object get(Class type, Object ... constructorParams) {
        if(singleton == null) {
            singleton = new Singleton();
        }

        if(singleton.elements.get(type) == null) {
            Object o = null;
            conLoop:
            for(Constructor con : type.getConstructors()) {
                if(constructorParams.length == con.getParameterCount()) {
                    for (int i = 0; i < constructorParams.length ; ++i) {
                        if (constructorParams[i].getClass() != con.getParameterTypes()[i]) {
                            continue conLoop;
                        }
                    }
                    try {
                        o = con.newInstance(constructorParams);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }

            if(o == null) {
                throw new IllegalArgumentException("no matching constructor to call on class "
                        + type.toString()
                        + " with arguments "
                        + constructorParams.toString());
            }

            singleton.elements.put(type, o);
        }

        return singleton.elements.get(type);
    }
}
