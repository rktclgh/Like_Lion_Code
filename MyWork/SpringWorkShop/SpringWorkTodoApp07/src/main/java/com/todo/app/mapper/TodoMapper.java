package com.todo.app.mapper;


import com.todo.app.entity.Todo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    public List<Todo> selectAll();
    public void add(Todo todo); // 추가
    public void update(Todo todo);//추가
    public List<Todo> selectIncomplete(); //추가
    public List<Todo> selectComplete();
    public void delete();
}
