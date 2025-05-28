package com.todo.app.controller;
import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.todo.app.entity.Todo;
import com.todo.app.mapper.TodoMapper;

@Controller
public class TodoController {
    @Autowired
    TodoMapper todoMapper;
    @RequestMapping(value="/")
    public String index(Model model) {
//        List<Todo> list = todoMapper.selectAll();
        List<Todo> list = todoMapper.selectIncomplete();
        List<Todo> doneList = todoMapper.selectComplete();
        model.addAttribute("todos",list);
        model.addAttribute("doneTodos",doneList);
        return "index";
    }

    //Controller 추가
    @RequestMapping(value="/add")
    public String add(Todo todo) {
        todoMapper.add(todo);
        return "redirect:/";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(HttpServletRequest request) {
        Todo todo = new Todo();
        todo.setId(Integer.parseInt(request.getParameter("id")));
        todo.setTitle(request.getParameter("title"));
        todo.setTimeLimit(request.getParameter("timeLimit"));

        // 직접 처리
        String[] doneFlgParams = request.getParameterValues("doneFlg");
        if (doneFlgParams != null && doneFlgParams.length > 0) {
            todo.setDoneFlg(Integer.parseInt(doneFlgParams[doneFlgParams.length - 1]));
        } else {
            todo.setDoneFlg(0);
        }

        System.out.println(">>> doneFlg = " + todo.getDoneFlg());

        todoMapper.update(todo);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(HttpServletRequest request) {
        todoMapper.delete();
        return "redirect:/";
    }




    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setDisallowedFields("doneFlg"); // 자동 바인딩 막고 수동 처리
    }

}

