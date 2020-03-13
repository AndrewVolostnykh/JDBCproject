package controllers;

import domain.Role;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import repos.UserRepo;

import java.util.Collections;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("registration")
    public String registration()
    {
        return "registration";
    }


    @PostMapping("registration") // wanna add Validation of fields
    public String registrationUser(@RequestParam String full_name,
                                   @RequestParam String email,
                                   @RequestParam String password, Model model)

    {
        //refactoring
        System.out.println(email);

        if(userRepo.findByEmail(email) != null)
        {
            model.addAttribute("message", "User exists!");
            return "registration";
        }

        User user = new User(full_name,email,password);
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        userRepo.save(user);

        return "redirect:/login";
    }
}
