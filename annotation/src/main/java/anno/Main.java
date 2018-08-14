package anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(EventLogs.class)
@interface EventLog {
  String date();/* bo ok2s.  c om*/

  String comments();
}

@Target({ ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PACKAGE })
@Retention(RetentionPolicy.RUNTIME)
@interface EventLogs {
  EventLog[] value();
}

@EventLog(date = "02/01/2018", comments = "A")
@EventLog(date = "02/22/2018", comments = "B")
public class Main {
  public static void main(String[] args) {
    Class<Main> mainClass = Main.class;
    Class<EventLog> annClass = EventLog.class;

    // Access annotations using the EventLog type
    System.out.println("Using the EventLog type...");
    EventLog[] annList = mainClass.getAnnotationsByType(EventLog.class);
    for (EventLog log : annList) {
      System.out.println("Date=" + log.date() + ", Comments=" + log.comments());
    }

    // Access annotations using the EventLogs containing annotation type
    System.out.println("\nUsing the EventLogs type...");
    Class<EventLogs> containingAnnClass = EventLogs.class;
    EventLogs logs = mainClass.getAnnotation(containingAnnClass);
    for (EventLog log : logs.value()) {
      System.out.println("Date=" + log.date() + ", Comments=" + log.comments());
    }
  }
}