package startBack.springStart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StartController {


    @GetMapping("start")
    public String start(Model model){
        model.addAttribute("data", "start!");
        model.addAttribute("data2","welcom!");
        return "start";
    }

    @GetMapping("start-mvc")
    public String startMvc(@RequestParam(value = "name",required = true) String name, Model model){
        model.addAttribute("name",name);
        return "start-template";

    }
}
