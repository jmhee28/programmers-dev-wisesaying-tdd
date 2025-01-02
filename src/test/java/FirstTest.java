import org.example.TestApp;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FirstTest {

    @Test
    void t1(){
    }

    @Test
    void t2(){
        PrintStream origin = System.out; // 원래 System.out을 origin에 저장

        //System.out ==> 표준 출력 => 모니터
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out)); // System.out을 out으로 변경
        System.out.println("aaa"); // 출력 안됨

        System.setOut(origin); // System.out을 원래대로 복구
        String str = out.toString();
        System.out.println(str); // 출력 안됨

    }
}
