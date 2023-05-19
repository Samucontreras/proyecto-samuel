package com.example.controller;

import Codigo.Tipocoche;
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
@RequestMapping("/tcoche")
public class controllerTipocoche {
    
    gestorTipocoche tc = new gestorTipocoche ();
    
       
    @GetMapping("/alta")
  public String greetingForm(Model model) { 
    model.addAttribute("tipocoche", new Tipocoche()); 
  return "./tipocoche/altaTipocoche";
  }
  
  @PostMapping("/alta")
  public String greetingSubmit(@ModelAttribute Tipocoche tipocoche, Model model) { 
        String valorfinal="./tipocoche/listarTipocoche";
        try {
            tc.altaTipocoche(tipocoche);
            try { 
                model.addAttribute("tipocoches", tc.listarTipocoches());
                model.addAttribute("filtro", "");
            } catch (SQLException ex) {
                Logger.getLogger(controllerTipocoche.class.getName()).log(Level.SEVERE, null, ex);
                valorfinal="error";
            }
        } catch (SQLException ex) {
            valorfinal="error";
        }
    return valorfinal; 
  }
  
   @GetMapping("/listar")
 public String listarTipocoches(Model model){
        String valorfinal="./tipocoche/listarTipocoche";
        try {
            model.addAttribute("tipocoches", tc.listarTipocochesFiltrados(""));
        } catch (SQLException ex) {
            Logger.getLogger(controllerTipocoche.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @PostMapping("/listar")
 public String listarTipocochesBBDD(@RequestParam ("filtro") String filtro, Model model){
        System.out.println("el filtro es : "+filtro);
        String valorfinal="./tipocoche/listarTipocoche";
        try {
            model.addAttribute("tipocoches", tc.listarTipocochesFiltrados(filtro));
            model.addAttribute("filtro", filtro);
        } catch (SQLException ex) {
            Logger.getLogger(controllerTipocoche.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
 
 @GetMapping("/eliminar")
  public String SubmitB (@RequestParam ("codtipocoche") int id, Model model){
      String valorfinal="./tipocoche/listarTipocoche";
        try {
            tc.eliminarTipocoche(id);
             model.addAttribute("tipocoches", tc.listarTipocoches());
        } catch (SQLException ex) {
            valorfinal="error";
        }
        return valorfinal;
  } 
  
  @GetMapping("/modificar")
  public String modificarTipocoche (@RequestParam ("codtipocoche") int id,Model model){
        String valorfinal="./tipocoche/modificartipocoche";
        try {
            model.addAttribute("tipocoche", tc.consultarTipocoche(id));
        } catch (SQLException ex) {
            Logger.getLogger(controllerTipocoche.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
         return valorfinal;
  }

   @PostMapping("/modificar")
  public String modificarTipococheBBDD (@ModelAttribute Tipocoche tipocoche, Model model){
        String valorfinal="./tipocoche/listarTipocoche";
        try {
            tc.modificarTipocoche(tipocoche);
            model.addAttribute("tipocoches", tc.listarTipocoches());
        } catch (SQLException ex) {
            Logger.getLogger(controllerTipocoche.class.getName()).log(Level.SEVERE, null, ex);
            valorfinal="error";
        }
        return valorfinal;
  }
    
}
