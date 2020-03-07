package application.controller;

import application.model.Entities.SignUpForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**Training class with simple signup form*/
@Controller
public class SignUpController {

    @ModelAttribute("signUpForm")
    public SignUpForm setSignUpForm()
    {
        return new SignUpForm();
    }

    @GetMapping("/sign-up")
    public String showForm()
    {
        return "signup-form";
    }

    @PostMapping("/saveSignUpForm")
    public String saveSignUpForm(@ModelAttribute("signUpForm") SignUpForm signUpForm, Model model)
    {
        model.addAttribute("message", "User successfully signed up");
        model.addAttribute("user", signUpForm);
        return "signup-success";
    }

}
