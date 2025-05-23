package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoController {

    //[1] GET 요청: 폼화면 출력
    @GetMapping
    public ModelAndView showForm(ModelAndView mav) {
        mav.addObject("msg", "숫자를 입력하시오");
        mav.addObject("value", "");
        mav.setViewName("index");
        return mav;
    }

    //[2] POST 요청: 폼에서 받은 값 처리
    @PostMapping("/")
    ModelAndView handleForm(@RequestParam String text1, ModelAndView mav) {
        int sum = 0;
        int num = Integer.parseInt(text1);

        for (int i = 1; i <=num; i++) {
            sum += i;
        }
        mav.addObject("msg", "sum = "+ sum); // 데이터 담고
        mav.addObject("value", text1);
        mav.setViewName("index");// 뷰 이름 지정
        return mav;
    }


}
