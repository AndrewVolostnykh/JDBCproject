package controllers;

import domain.Message;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import repos.MessageRepos;

@Controller
public class ProfileController {

    private MessageRepos messageRepos;

    @Autowired
    public ProfileController(MessageRepos repos)
    {
        messageRepos = repos;
    }

    @GetMapping("/profile")
    public String showProfile(@AuthenticationPrincipal User user, Model model)
    {
        Iterable<Message> messages;

        model.addAttribute("name", user.getFullName());
        model.addAttribute("email", user.getEmail());

        messages = messageRepos.findByAuthor(user);
        model.addAttribute("messages", messages);

        return "profile";
    }

}
