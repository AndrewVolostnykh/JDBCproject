package controllers;

import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import repos.UserRepo;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping("registration")
    public String registration(WebRequest request, Model model)
    {
        User user = new User();
        model.addAttribute("user", user);
        return "registration";
    }

    @PostMapping("registration") // wanna add Validation of fields
    public String registrationUser(@RequestParam User user, Model model)
    {
        User userFromDB = userRepo.findByEmail(user.getEmail());

        if(userFromDB != null)
        {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
