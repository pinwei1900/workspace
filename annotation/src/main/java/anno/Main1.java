package anno;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
@Documented/*from  b  o ok 2s.  c o m*/
@interface Version {
    int major();

    int minor();
}

@Version(major = 1, minor = 0)
class AccessAnnotation {
    @Version(major = 1, minor = 1)
    public void testMethod1() {
        // Code goes here
    }

    @Version(major = 1, minor = 2)
    @Deprecated
    public void testMethod2() {
        // Code goes here
    }
}

public class Main1 {
    public static void main(String[] args) {
        // Read annotation of class declaration
        Class<AccessAnnotation> c = AccessAnnotation.class;
        System.out.println("Annotations for class:" + c.getName());
        printAnnotations(c);

        // Read annotation of package declaration
        Package p = c.getPackage();
        System.out.println("Annotations for package:" + p.getName());
        printAnnotations(p);

        // Read annotation of method declaration
        System.out.println("Method annotations:");
        Method[] m = c.getDeclaredMethods();
        for (int i = 0; i < m.length; i++) {
            System.out.println("Annotations for method:" + m[i].getName());
            printAnnotations(m[i]);
        }
    }

    public static void printAnnotations(AnnotatedElement programElement) {
        Annotation[] annList = programElement.getAnnotations();
        for (int i = 0; i < annList.length; i++) {
            System.out.println(annList[i]);
            if (annList[i] instanceof Version) {
                Version v = (Version) annList[i];
                int major = v.major();
                int minor = v.minor();
                System.out.println("Found Version annotation: " + "major =" + major + ", minor=" + minor);
            }
        }
        System.out.println();
    }
}