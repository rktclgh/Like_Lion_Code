package com.work03.sec01;

public interface MemberRepository {
    String findMemberById(int id);

    void save(int id, String name);
}
