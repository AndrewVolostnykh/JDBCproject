package controllers;

import domain.Goals;
import domain.Message;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repos.GoalsRepos;
import repos.MessageRepos;

@Controller
public class ProfileController {

    private MessageRepos messageRepos;
    private GoalsRepos goalsRepos;

    @Autowired
    public ProfileController(MessageRepos repos, GoalsRepos goalsRepos)
    {
        messageRepos = repos;
        this.goalsRepos = goalsRepos;
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

    @PostMapping("/addGoal")
    public String addGoal(@AuthenticationPrincipal User user,
                          @RequestParam String target,
                          @RequestParam String description,
                          @RequestParam int time, Model model)
    {

        Goals goal = new Goals(target, description, time, user);
        goalsRepos.save(goal);

        Iterable<Goals> goals = goalsRepos.findByUser(user); // to show all goals for this user
        model.addAttribute("goals", goals);

        return "profile";
    }
}
