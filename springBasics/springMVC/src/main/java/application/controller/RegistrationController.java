package application.controller;

import application.model.Entities.User;
import application.model.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @GetMapping("/registration")
    public String registrationPage()
    {
        return "login/registration";
    }

    @RequestMapping("/registration")
    public ModelAndView registration(@RequestParam("login") String login,
                                     @RequestParam("password") String password,
                                     @RequestParam("email") String email,
                                     @RequestParam("surname") String surname,
                                     @RequestParam("age") int age)
    {
        User user = new User(login, surname, age, email, password);
        new UserDao().persist(user);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        mv.addObject("result", "User " + login + " successfully registered! ");

        return mv;
    }

}
