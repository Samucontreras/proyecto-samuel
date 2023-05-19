package com.example.controller;

import Codigo.Energia;
import Codigo.gestorEnergia;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/energia")
public class controllerEnergia {
    
    gestorEnergia ge = new gestorEnergia ();
    
       
    @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("energia", new Energia()); 
  return "./fuenteenergia/altaEnergia";
  }
  
  @PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Energia energia, Model model) { 
        String valorfinal="./fuenteenergia/listarEnergia";
        try {
            ge.altaEnergia(energia);
            try { 
                model.addAttribute("energias", ge.listarEnergias());
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerEnergia.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
  
   @GetMapping("/listar")
 public String listarEnergias(Model model){
        String valorfinal="./fuenteenergia/listarEnergia";
        try {
            model.addAttribute("energias", ge.listarEnergiasFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerEnergia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @PostMapping("/listar")
 public String listarEnergiasBBDD(@RequestParam ("filtro") String filtro, Model model){
        System.out.println("el filtro es : "+filtro);
        String valorfinal="./fuenteenergia/listarEnergia";
        try {
            model.addAttribute("energias", ge.listarEnergiasFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerEnergia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codenergia") int id, Model model){
      String valorfinal="./fuenteenergia/listarEnergia";
        try {
            ge.eliminarEnergia(id);
             model.addAttribute("energias", ge.listarEnergias());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
  
  @GetMapping("/modificar")
  public String modificarEnergia (@RequestParam ("codenergia") int id,Model model){
        String valorfinal="./fuenteenergia/modificarenergia";
        try {
            model.addAttribute("energia", ge.consultarEnergia(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerEnergia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  }

   @PostMapping("/modificar")
  public String modificarEnergiaBBDD (@ModelAttribute Energia energia, Model model){
        String valorfinal="./fuenteenergia/listarEnergia";
        try {
            ge.modificarEnergia(energia);
            model.addAttribute("energias", ge.listarEnergias());
        } catch (SQLException ex) {
            Logger.getLogger(controllerEnergia.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
}
