import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        String out = TestBot.run("종료");
        assertThat(out.toString()).isEqualTo("명언앱을 종료합니다\n");
    }

    @Test
    @DisplayName("앱 시작 시 === 명언 앱 === 출력")
    void t4(){

        String out = TestBot.run("종료");
        // 순서 보장
        assertThat(out.toString())
                .containsSubsequence("== 명언 앱 ==", "명언앱을 종료합니다");

    }

    @Test
    @DisplayName("등록 명언 1개 등록")
    void t5(){
        String out = TestBot.run("등록\n현재를 사랑하라\n작자미상\n종료");

        assertThat(out).containsSubsequence("명언 : ", "작가 : ");

    }
}
