package controllers;

import domain.Message;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import repos.MessageRepos;

import java.util.List;

@Controller
//@Service
//@ComponentScan("repos")
public class MessagesController {

    @Autowired
    private MessageRepos messageRepos;

    @GetMapping("/messages")
    public String messagesPage(Model model)
    {
        Iterable<Message> messages = messageRepos.findAll();

        model.addAttribute("messages", messages);

        return "messages";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter_tag, Model model)
    {
        Iterable<Message> messages;

         if(filter_tag != null && !filter_tag.isEmpty()) {
            messages = messageRepos.findByTag(filter_tag);
            model.addAttribute("messages", messages);
        } else {
            messages = messageRepos.findAll();
            model.addAttribute("messages", messages);
        }

        return "messages";
    }

    @PostMapping("/messages")
    public String addNewMessage(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag, Model model)
    {

        Message message = new Message(text, tag, user);
        messageRepos.save(message);
        Iterable<Message> messages = messageRepos.findAll();
        model.addAttribute("messages", messages);

        return "messages";
    }


}
