package application.controller;

import application.services.AdderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddController {

    @RequestMapping("/add")
    public ModelAndView add(@RequestParam("text1") int text1, @RequestParam("text2") int text2) //HttpServletRequest request, HttpServletResponse response
    {
//        int text1 = Integer.parseInt(request.getParameter("text1"));
//        int text2 = Integer.parseInt(request.getParameter("text2"));

        ModelAndView mv = new ModelAndView();
        mv.setViewName("add");
        mv.addObject("result", AdderService.add(text1, text2));
        return mv;
    }

}
