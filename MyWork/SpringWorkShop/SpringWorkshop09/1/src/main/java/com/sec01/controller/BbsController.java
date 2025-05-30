package com.sec01.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bbs")
public class BbsController {

    @GetMapping
    public List<String> getAll()
    {
        System.out.println("전체 글 보기");
        //리포지토리에게 저장된 sql 작업 실행
        return List.of("1", "2", "3");//글 목록 불러오기
    }


    @GetMapping("/{articleId}")
    public List<String> detailView(@PathVariable Long articleId)
    {
        System.out.println("상세 글 보기");
        //리포지토리에게 저장된 sql 작업 실행
        return List.of("1", "2", "3");//글 페이지를 불러온다.
    }


    @PostMapping
    public String write()
    {
        System.out.println("글쓰기!");
        //리포지토리+엔티티를 땡겨와서 글을 작성한다.
        return "redirect:/bbs";//작성 후 리다이렉션
    }

    @PutMapping("/{articleId}")
    public String edit(@PathVariable Long articleId)
    {
        System.out.println("글 수정");
        //리포지토리+엔티티를 땡겨와서 글을 수정한다.
        return "redirect:/bbs";// 수정 후 리다이렉션
    }


    @DeleteMapping("/{articleId]")
    public String delete(@PathVariable Long articleId)
    {
        System.out.println("글 삭제");
        //articleId를 리포지토리에 넘겨서 글 삭제 후 리다이렉션

        return "redirect:/bbs";
    }

}
