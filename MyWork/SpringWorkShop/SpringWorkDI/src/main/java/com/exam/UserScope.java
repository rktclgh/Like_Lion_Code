package com.exam;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;



// 사용자 정의 스코프를 만들어서 생성해보자 .
public class UserScope implements Scope {



    private final ThreadLocal<Map<String, Object>> userScope = ThreadLocal.withInitial(HashMap::new);
    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        Map<String, Object > scope = userScope.get();
        return scope.computeIfAbsent(name, k -> objectFactory.getObject());
    }

    @Override
    public Object remove(String name) {
        Map<String, Object> scope = userScope.get();
        return scope.remove(name);
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return Thread.currentThread().getName();
    }
}
