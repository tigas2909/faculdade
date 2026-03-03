package atv1.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"/Lista1"})

public class Atv2 {

@GetMapping({"/Exercicio2A"})
@ResponseBody
public String atv2A(HttpServletRequest request){

    String metodo = request.getMethod();
    String URI = request.getRequestURI();
    String URL = request.getRequestURL().toString();
    String protocolo = request.getProtocol();

    String resultado = "| metodo: " + metodo + "| URI: " + URI + "| URL: " + URL + "| protocolo: " + protocolo +"|";

    return resultado;
}

@GetMapping({"/Exercicio2B"})
@ResponseBody
public String atv2B(HttpServletRequest request){

    String[] res = {request.getHeader("host"),
    request.getHeader("user-agent"),
    request.getHeader("accept-encoding"),
    request.getHeader("accept-language")};

    String resultado = res[0] + "<br>" + res[1] + "<br>" + res[2] + "<br>" + res[3];

    return resultado;
}



}
