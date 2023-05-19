package com.example.controller;

import Codigo.Modelo;
import Codigo.gestorEnergia;
import Codigo.gestorMarca;
import Codigo.gestorModelo;
import Codigo.gestorTipocoche;
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
@RequestMapping("/modelo")
public class controllerModelo {
    
     gestorModelo gem = new gestorModelo();
     gestorMarca gm = new gestorMarca();
     gestorTipocoche gtp = new gestorTipocoche();
     gestorEnergia gen = new gestorEnergia();
    
       
    @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("modelo", new Modelo()); 
         try { 
             model.addAttribute("marcas", gm.listarMarcas());
             model.addAttribute("tiposCoche", gtp.listarTipocoches()); 
             model.addAttribute("tiposEnergia", gen.listarEnergias()); 

         } catch (SQLException ex) {
             Logger.getLogger(controllerModelo.class.getName()).log(Level.SEVERE, null, ex);
         }

  return "./modelo/altaModelo";
  }
  
  @PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Modelo modelo, Model model) { 
        String valorfinal="./modelo/listarModelo";
        try {
            gem.altaModelo(modelo);
            try { 
                model.addAttribute("modelos", gem.listarModelosFiltrados(""));
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerModelo.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
  
   @GetMapping("/listar")
 public String listarModelos(Model model){
        String valorfinal="./modelo/listarModelo";
        try {
            model.addAttribute("modelos", gem.listarModelos());
        } catch (SQLException ex) {
            Logger.getLogger(controllerModelo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @PostMapping("/listar")
 public String listarModelosBBDD(@RequestParam ("filtro") String filtro, Model model){
        System.out.println("el filtro es : "+filtro);
        String valorfinal="./modelo/listarModelo";
        try {
            model.addAttribute("modelos", gem.listarModelosFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerModelo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codmodelo") int id, Model model){
      String valorfinal="./modelo/listarModelo";
        try {
            gem.eliminarModelo(id);
             model.addAttribute("modelos", gem.listarModelos());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
  
  @GetMapping("/modificar")
  public String modificarModelo (@RequestParam ("codmodelo") int id,Model model){
        String valorfinal="./modelo/modificarmodelo";
        try {
            model.addAttribute("modelo", gem.consultarModelo(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerModelo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  }

   @PostMapping("/modificar")
  public String modificarModeloBBDD (@ModelAttribute Modelo modelo, Model model){
        String valorfinal="./modelo/listarModelo";
        try {
            gem.modificarModelo(modelo);
            model.addAttribute("modelos", gem.listarModelos());
        } catch (SQLException ex) {
            Logger.getLogger(controllerModelo.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
}
