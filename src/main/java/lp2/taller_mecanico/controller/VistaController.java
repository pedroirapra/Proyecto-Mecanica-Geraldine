package lp2.taller_mecanico.controller;


import lp2.taller_mecanico.dao.ClienteRepository;
import lp2.taller_mecanico.dao.RegistroRepository;
import lp2.taller_mecanico.dao.VehiculoRepository;
import lp2.taller_mecanico.model.Cliente;
import lp2.taller_mecanico.model.Registro;
import lp2.taller_mecanico.model.Vehiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class VistaController {
    @Autowired
    private VehiculoRepository vr;
    @Autowired
    private RegistroRepository rr;
    @Autowired
    private ClienteRepository cr;

    @GetMapping("/index2")
    public String index2(){
        return "index2";
    }

        @GetMapping("/index2/servicios2")
        public String servicios2(){
            return "servicios2";
        }
        @GetMapping("/index2/galeria2")
        public String galeria2(){
            return "galeria2";
        }


        @GetMapping("/servicios")
        public String servicios(){
            return "servicios";
        }

        @GetMapping("/galeria")
        public String galeria(){
            return "galeria";
        }


    @GetMapping("index2/vehiculos")
    public String muestraVehiculos(Model model){
        List<Vehiculo> lista = vr.findAll();
        model.addAttribute("listaVehiculos", lista);
        return "vehiculos";
    }

    @GetMapping("index2/vehiculos/crearVh")
    public String muestraFormulario(Model model){
        model.addAttribute("nuevoVehiculo",new Vehiculo());

        List<Cliente> lista = cr.findAll();
        model.addAttribute("listaClientes", lista);
        return "crearVh";
    }

    @PostMapping ("index2/vehiculos/crearVh")
    public String vehiculoNuevo(@ModelAttribute Vehiculo v){
        vr.save(v);
        return "redirect:/index2/vehiculos";
    }
    @GetMapping("index2/agenda/crearRegistro")
    public String muestraForm(Model model){
        model.addAttribute("nuevoRegistro",new Registro());

        List<Vehiculo> lista= vr.findAll();
        model.addAttribute("listaVehiculos", lista);
        return "crearRegistro";
    }

    @PostMapping ("index2/agenda/crearRegistro")
    public String registroNuevo(@ModelAttribute Registro r){
        rr.save(r);
        return "redirect:/index2/agenda";
    }

    @GetMapping("index2/clientes")
    public String muestraClientes(Model model){
        List<Cliente> lista=cr.findAll();
        model.addAttribute("listaClientes",lista);
        return "clientes";
    }

        @GetMapping("index2/clientes/crearCl")
        public String clienteNuevo(Model model){
            model.addAttribute("nuevoCliente",new Cliente());
            return "crearCl";
        }
        @PostMapping ("index2/clientes/crearCl")
        public String guardaCliente(@ModelAttribute Cliente c){
            cr.save(c);
            return "redirect:/index2/clientes";
        }


    @GetMapping("index2/agenda")
    public String muestraAgenda(Model model){
        List<Registro> lista=rr.findAll();
        model.addAttribute("listaRegistros",lista);
        return "agenda";
    }

    @GetMapping("index2/clientes/{idCliente}/verVehiculos")
    public String verVehiculos(@PathVariable(name="idCliente") Integer id, Model model){

        Cliente c=cr.findByIdCliente(id.intValue());
        model.addAttribute("cliente",c);
        return "verVehiculos";
    }
    @GetMapping("index2/clientes/{idCliente}/volver")
    public String volver(){

        return "redirect:/index2/clientes";
    }




}
