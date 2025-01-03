import org.example.TestApp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

    @Test
    void t3(){
        // 테스트 봇 선입력
//        Scanner sc = new Scanner("종료\n");
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//
//        TestApp app = new TestApp();
//        app.run();

        String out = TestBot.run("종료");
        assertThat(out.toString()).isEqualTo("명언앱을 종료합니다\n");
    }

    @Test
    @DisplayName("앱 시작 시 === 명언 앱 === 출력")
    void t4(){
        // 테스트 봇 선입력
//        Scanner sc = new Scanner("종료\n");
//
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(out));
//
//        TestApp app = new TestApp();
//        app.run();

//        assertThat(out.toString())
//                .contains("=== 명언 앱 ===")
//                .contains("명언앱을 종료합니다.");

        String out = TestBot.run("종료");
        // 순서 보장
        assertThat(out.toString())
                .containsSubsequence("== 명언 앱 ==", "명언앱을 종료합니다");

    }
}
