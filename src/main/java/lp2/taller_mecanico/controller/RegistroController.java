package lp2.taller_mecanico.controller;

import lp2.taller_mecanico.dao.ClienteRepository;
import lp2.taller_mecanico.dao.RegistroRepository;
import lp2.taller_mecanico.dao.VehiculoRepository;
import lp2.taller_mecanico.model.Cliente;
import lp2.taller_mecanico.model.Registro;
import lp2.taller_mecanico.model.Usuario;
import lp2.taller_mecanico.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistroController {
    @Autowired
    private VehiculoRepository vr;
    @Autowired
    private RegistroRepository rr;
    @Autowired
    private ClienteRepository cr;


    @GetMapping("/reserva_hora")
    public String muestraReserva(Model model){
        model.addAttribute("nuevoCliente",new Cliente());
        return "reserva_hora";
    }
    @PostMapping("/reserva_hora")
    public String Reserva(@ModelAttribute Cliente c){
        cr.save(c);
        return "redirect:/reserva_hora2";
    }

    @GetMapping ("/reserva_hora2")
    public String muestraReserva2(Model model){
        model.addAttribute("nuevoVehiculo",new Vehiculo());
        List<Cliente> lista =cr.findAll();
        model.addAttribute("listaClientes",lista);
        return "reserva_hora2";
    }

    @PostMapping("/reserva_hora2")
    public String Reserva2(@ModelAttribute Vehiculo v){
        vr.save(v);
        return "redirect:/reserva_hora3";
    }

    @GetMapping("/reserva_hora3")
    public String muestraReserva3(Model model){
        model.addAttribute("nuevoRegistro",new Registro());
        List<Vehiculo> lista =vr.findAll();
        model.addAttribute("listaVehiculos",lista);

        return "reserva_hora3";
    }

    @PostMapping("/reserva_hora3")
    public String Reserva3(@ModelAttribute Registro r){
        rr.save(r);
        return "redirect:/post_reserva";
    }

    @GetMapping("/post_reserva")
    public String postReserva(Model model){
        List<Registro> lista =rr.findAll();
        model.addAttribute("listaRegistros",lista);

        return "post_reserva";
    }
    @GetMapping("/seguimiento")
    public String seguimiento(Model model){
        model.addAttribute("registro", new Registro());

        List<Registro> lista= rr.findAll();
        model.addAttribute("listaRegistros", lista);

        return "seguimiento";
    }

    @PostMapping("/seguimiento")
    public String login(Model model, @ModelAttribute Registro r){

        Registro registroBd=rr.findByCodigo(r.getCodigo());

        if (registroBd!=null){

            return "redirect:/estado_vehiculo";
        }else{
            model.addAttribute("registro", new Registro());
            model.addAttribute("error",true);
            return "seguimiento";
        }

    }
    @GetMapping("/estado_vehiculo")
    public String muestraEstado(Model model){
        List<Registro> lista = rr.findAll();
        model.addAttribute("listaRegistros", lista);
        return "estado_vehiculo";
    }






}
