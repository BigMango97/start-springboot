package project.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
@Controller
public class FirstController {
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){ //모델 객체 받아오기
        //model객체가 "홍팍" 값을 "username"에 연결해 웹 브라우저로 보냄
        model.addAttribute("username","hongpark");
        return "greetings"; //greetings.mustache 파일 변환
    }
    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","minkyeong");
        return "goodbye";
    }
}
