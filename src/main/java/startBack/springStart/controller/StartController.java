package startBack.springStart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {


    @GetMapping("start")
    public String start(Model model){
        model.addAttribute("data", "start!");
        return "start";
    }
}
