package startBack.springStart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("start-string")
    @ResponseBody
    public String startStrnig(@RequestParam("name") String name){
        return "start" + name;
    }

    @GetMapping("start-api")
    @ResponseBody
    public Start startApi(@RequestParam("name") String name){
        Start start = new Start();
        start.setName(name);
        return start;
    }
    static class Start{
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

    }
}
