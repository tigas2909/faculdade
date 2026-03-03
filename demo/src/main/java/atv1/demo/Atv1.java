package atv1.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/Lista1"})

public class Atv1 {

    @GetMapping({"/Exercicio1"})
    @ResponseBody
    public String hello(){
        return "olá mundo";
    }
}
