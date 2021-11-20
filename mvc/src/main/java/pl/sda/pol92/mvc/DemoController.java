package pl.sda.pol92.mvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class DemoController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public void message(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        if (name != null){
            response.getWriter().println("<Html> <body><h3>Hello " + name +"</h3></body></html>");
        } else {
            response.getWriter().println("<Html> <body><h3>Brak imienia</h3></body></html>");
        }
    }

    @GetMapping(value = "/newmessage", produces = MediaType.TEXT_PLAIN_VALUE)
    @ResponseBody
    public String messageImp(@RequestParam(defaultValue = "brak imienia") String name, @RequestParam(defaultValue = "20") int age){
       return "Your name " + name +" and age " + age;
    }

    @GetMapping("/power")
    @ResponseBody
    public String power(Double number){
        if(number == null){
            return "Musisz podać parametr number!";
        }
        double result = Math.pow(number, 2);
        return "Wynik: " + result;
    }

    @GetMapping("/mvcpower")
    public String newPower(@RequestParam(required = true) Double number, Model model){
        double result = Math.pow(number, 2);
        model.addAttribute("power", result);//przekazanie modelu do widoku
        model.addAttribute("number", number);
        return "power-result";
    }

    @GetMapping("/power-form")
    public String powerForm(){
        return "power-form";
    }

}
