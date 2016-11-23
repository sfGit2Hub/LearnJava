package RTTI;

/**
 * Created by SF on 2016/7/4.
 */
public class ToyTest{
    static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName()
                + " is interface? [" + cc.isInterface() +"]" );
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name: " + cc.getCanonicalName());
    }

    public static void main(String[] args) {
        Class cc = null;
        try {
            cc = Class.forName("RTTI.FancyToy");
        } catch (ClassNotFoundException e) {
            System.out.println("Can't find FancyToy");
            System.exit(1);
        }
        printInfo(cc);
        for (Class face : cc.getInterfaces()) {
            printInfo(face);
        }
        Class up = cc.getSuperclass();
        Object obj = null;
        try {
            obj = up.newInstance();
        } catch (InstantiationException e) {
            System.out.println("Can't instance");
        } catch (IllegalAccessException e) {
            System.out.println("Can't access");
            System.exit(1);
        }
        printInfo(obj != null ? obj.getClass() : null);
    }
}
