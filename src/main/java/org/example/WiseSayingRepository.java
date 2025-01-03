package org.example;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private final List<WiseSaying> wiseSayingList;
    private int lastId;

    public WiseSayingRepository() {
        this.wiseSayingList = new ArrayList<>();
        lastId = 0;
    }

    public WiseSaying save(WiseSaying wiseSaying) {
        int id = ++this.lastId;
        wiseSaying.setId(id);
        wiseSayingList.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayingList;
    }
}
