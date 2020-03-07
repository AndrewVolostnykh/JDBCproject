package application.controller;

import application.services.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Parameter;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginPage()
    {
        return "login/login-page";
    }

    @RequestMapping("/login-page")
    public ModelAndView loginCheck(@RequestParam("login") String login, @RequestParam("password") String password)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        if(LoginService.isValid(login, password))
        {
            mv.addObject("reuslt", "success");
            mv.addObject("login", login);

            return mv;
        } else {
            mv.addObject("reuslt", "Fail");
            mv.addObject("login", "Incorrect name or password. ");

            return mv;
        }
    }




}
