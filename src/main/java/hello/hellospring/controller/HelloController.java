package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UrlPathHelper;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
    model.addAttribute("data","spring!!");
    return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = false)String name, Model model){
        model.addAttribute("name", name);
        return "hello-templete";
    }

    @GetMapping("hello-string")
    @ResponseBody //바디 부분에 직접 넣겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello " + name; //"hello spring"
    }
    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name); //parameter로 넘김
        return hello;

    }

    static class Hello{
        private String name;
        //getter, setter 만들기
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
