package com.work03.sec02;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {


    private final Map<Integer, String> store = new HashMap<>();

    @Override
    public void save(int id, String name) {
    store.put(id, name);
    }
    @Override
    public String findMemberById(int id) {
        return store.get(id);
    }


}
