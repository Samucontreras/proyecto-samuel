package com.example.controller;

import Codigo.Marca;
import Codigo.gestorMarca;
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
@RequestMapping("/marca")
public class controllerMarca {
    
    gestorMarca gm = new gestorMarca ();
    
       
    @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("marca", new Marca()); 
  return "./marca/altaMarca";
  }
  
  @PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Marca marca, Model model) { 
        String valorfinal="./marca/listarMarca";
        try {
            gm.altaMarca(marca);
            try { 
                model.addAttribute("marcas", gm.listarMarcas());
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerMarca.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
  
   @GetMapping("/listar")
 public String listarMarcas(Model model){
        String valorfinal="./marca/listarMarca";
        try {
            model.addAttribute("marcas", gm.listarMarcasFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerMarca.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @PostMapping("/listar")
 public String listarMarcasBBDD(@RequestParam ("filtro") String filtro, Model model){
        System.out.println("el filtro es : "+filtro);
        String valorfinal="./marca/listarMarca";
        try {
            model.addAttribute("marcas", gm.listarMarcasFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerMarca.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codmarca") int id, Model model){
      String valorfinal="./marca/listarMarca";
        try {
            gm.eliminarMarca(id);
             model.addAttribute("marcas", gm.listarMarcas());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
  
  @GetMapping("/modificar")
  public String modificarMarca (@RequestParam ("codmarca") int id,Model model){
        String valorfinal="./marca/modificarmarca";
        try {
            model.addAttribute("marca", gm.consultarMarca(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerMarca.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  }

   @PostMapping("/modificar")
  public String modificarMarcaBBDD (@ModelAttribute Marca marca, Model model){
        String valorfinal="./marca/listarMarca";
        try {
            gm.modificarMarca(marca);
            model.addAttribute("marcas", gm.listarMarcas());
        } catch (SQLException ex) {
            Logger.getLogger(controllerMarca.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
}
