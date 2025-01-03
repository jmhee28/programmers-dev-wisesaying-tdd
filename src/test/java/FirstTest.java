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

        String out = TestBot.run("""
                등록
                종료
                """ );

        // 출력 횟수 확인
        int count = out.split("명령 \\)").length - 1;
        assertThat(count).isEqualTo(2);

    }

    @Test
    @DisplayName("등록 명언 1개 등록")
    void t5(){
        String out = TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                """);
        // 출력 순서 보장
        assertThat(out).containsSubsequence("명언 : ", "작가 : ");
    }

    @Test
    @DisplayName("등록 명언 1개 입력, 명언 번호 출력")
    void t6(){
        String out = TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                """);
        // 출력 순서 보장
        assertThat(out).containsSubsequence("명언 : ", "작가 : ");
    }

    @Test
    @DisplayName("등록 명언 2개 입력, 명언 번호 증가")
    void t8(){
        String out = TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자미상
                """);
        // 출력 순서 보장
        assertThat(out).containsSubsequence("1번 명언이 등록되었습니다.", "2번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("목록 검증")
    void t9(){
        String out = TestBot.run("""
                등록
                현재를 사랑하라
                작자미상
                등록
                현재를 사랑하라
                작자미상
                """);
        // 출력 순서 보장
        assertThat(out).contains("번호 / 작가 / 명언")
                .contains("----------------------")
                .containsSubsequence("2 / 작자미상 / 현재를 사랑하라", "1 / 작자미상 / 현재를 사랑하라");
    }

    @Test
    public void testMethod3() {
        assertThat("가나").containsSequence("가", "나");
    }
}
