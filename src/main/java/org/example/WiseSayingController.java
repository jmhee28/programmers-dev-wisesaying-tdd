package org.example;

import java.util.*;
public class WiseSayingController {

    private final Scanner sc;

    private WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void actionWrite() {
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();
        wiseSayingService.write(content, author);
        System.out.println("%d번 명언이 등록되었습니다.".formatted(wiseSayingService.getLastId()));
    }

    public void actionPrint() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayingList = wiseSayingService.getWiseSayingList();
        Collections.reverse(wiseSayingList);
        wiseSayingList.forEach(w -> {
            System.out.printf("%d / %s / %s\n", w.getId(), w.getAuthor(), w.getContent());
        });
    }
}
