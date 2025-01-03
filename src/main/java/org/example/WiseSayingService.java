package org.example;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {

    private WiseSayingRepository wiseSayingRepository;
    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }
    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(content, author);
        wiseSayingRepository.save(wiseSaying);
        return wiseSaying;
    }
    public List<WiseSaying> getAllItems() {
        return wiseSayingRepository.findAll();
    }
}
