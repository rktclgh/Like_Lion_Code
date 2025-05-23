package myweb01.demo;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    UserRepository repos;

    //[1] 사용자 목록+ 폼 페이지 (get)

    @RequestMapping(value = "/", method =  RequestMethod.GET)
    public ModelAndView index(@ModelAttribute("formModel") User user, ModelAndView mav) {
        mav.setViewName("index");
        mav.addObject("data", repos.findAll());
        return mav;
    }
    //[2] 사용자 저장(post)
@RequestMapping(value = "/", method =  RequestMethod.POST)
@Transactional(readOnly = false) // 현재 트랜잭션 내에서, 쓰기작업(저장 수정 삭제) 허용
public ModelAndView index(@ModelAttribute("formModel") User user) {
        repos.saveAndFlush(user);// 사용자 데이터를 입력받아 즉시 디비에 저장 및 반영 하겠다.
        return new ModelAndView("redirect:/"); // 목록 화면으로 이동
    //데이터 저장 후 목록 화면으로 다시 이동 -> 새로고침 했을때 폼데이터 재전송 경고 뜨는 것을 방지, 최신 사용자 목록을 다시 불러와서 표기

}


    //[3] 초기 사용자 등록

    @PostConstruct
    public void Init()
    {
        User user1 = new User();
        user1.setName("홍길동");
        repos.saveAndFlush(user1);

        User user2 = new User();
        user2.setName("정춘자");
        repos.saveAndFlush(user2);
    }
}
