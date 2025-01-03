import org.example.TestApp;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TestBot {
    // 객체는 static 지양
    // static은 공유
    // 객체가 data가 없다면(상태가 없다면) static으로 만들어도 된다.

    public static String run(String input) {
        Scanner sc = new Scanner(input + "\n");

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        TestApp app = new TestApp();
        app.run();

        return out.toString();
    }
}

