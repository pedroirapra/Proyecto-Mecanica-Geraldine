package lp2.taller_mecanico.controller;


import lp2.taller_mecanico.dao.UsuarioRepository;
import lp2.taller_mecanico.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

    @Controller
    public class UsuarioController {
        @Autowired
        private UsuarioRepository ur;


        @GetMapping ("/login")
        public String mostrarLogin(Model model){

            model.addAttribute("usuario", new Usuario());

            return "login";
        }

        @PostMapping("/login")
        public String login(Model model, @ModelAttribute Usuario u , HttpServletRequest request){

            Usuario usuarioBd=ur.findByNombreAndContrasena(u.getNombre(),u.getContrasena().intValue());

            if (usuarioBd!=null){
                request.getSession().setAttribute("usuarioLogueado",usuarioBd);
                return "index2";
            }else{
                model.addAttribute("usuario", new Usuario());
                model.addAttribute("error",true);
                return "login";
            }

        }

        @PostMapping("/logout")
        public String logout(HttpServletRequest request){

            request.getSession().invalidate();

        return "redirect:/login";
        }




    }
