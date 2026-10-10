package week3.assignments;


import java.util.*;

interface NotificationChannel {
    void send(String studentName, String title);
}

class EmailChannel implements NotificationChannel {
    public void send(String studentName, String title) {
        System.out.println("[Email -> " + studentName + "] " + title);
    }
}

class SmsChannel implements NotificationChannel {
    public void send(String studentName, String title) {
        System.out.println("[SMS -> " + studentName + "] " + title);
    }
}

class AppChannel implements NotificationChannel {
    public void send(String studentName, String title) {
        System.out.println("[App -> " + studentName + "] " + title);
    }
}

class NoticeStudent {
    String name;
    String department;
    List<NotificationChannel> channels = new ArrayList<>();

    NoticeStudent(String name, String department) {
        this.name = name;
        this.department = department;
    }

    void addChannel(NotificationChannel channel) {
        channels.add(channel);
    }
}

class Notice {
    String title;
    Set<String> departments;

    Notice(String title, Set<String> departments) {
        this.title = title;
        this.departments = departments;
    }
}

class NoticeBoard {
    List<NoticeStudent> students = new ArrayList<>();

    void addStudent(NoticeStudent student) {
        students.add(student);
    }

    void postNotice(Notice notice) {
        // Validate the notice before sending it
        if (notice.title == null || notice.title.trim().isEmpty()) {
            System.out.println("Cannot post notice: Title is required.");
            return;
        }

        if (notice.departments == null || notice.departments.isEmpty()) {
            System.out.println(
                    "Cannot post notice: At least one target department is required.");
            return;
        }

        System.out.println("Notice '" + notice.title
                + "' posted to " + String.join(", ", notice.departments)
                + ".");

        // Find students in the target departments
        for (NoticeStudent student : students) {
            if (notice.departments.contains(student.department)) {

                // Send through each student's preferred channel
                for (NotificationChannel channel : student.channels) {
                    channel.send(student.name, notice.title);
                }
            }
        }
    }
}

public class Main4 {
    public static void main(String[] args) {
        NoticeBoard board = new NoticeBoard();

        NoticeStudent asha = new NoticeStudent("Asha", "CSE");
        asha.addChannel(new EmailChannel());
        asha.addChannel(new AppChannel());

        NoticeStudent ravi = new NoticeStudent("Ravi", "ECE");
        ravi.addChannel(new SmsChannel());

        board.addStudent(asha);
        board.addStudent(ravi);

        // Notice for CSE students
        Notice n1 = new Notice(
                "Lab Closed Tomorrow",
                new HashSet<>(Arrays.asList("CSE"))
        );
        board.postNotice(n1);

        // Notice for both departments
        Notice n2 = new Notice(
                "Fee Deadline Extended",
                new HashSet<>(Arrays.asList("CSE", "ECE"))
        );
        board.postNotice(n2);

        // Invalid notice: no target departments
        Notice n3 = new Notice(
                "Sports Day",
                new HashSet<>()
        );
        board.postNotice(n3);
    }
}

