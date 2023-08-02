package com.midominio.proyecto0.app.Controller;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.midominio.proyecto0.app.Service.CocheNoExisteException;

@ControllerAdvice
public class ErrorController {
	
	@Value("Ha surgido un error")
	private String titulo;
	
	@ExceptionHandler(NullPointerException.class)
	public String templateInputError(NullPointerException ex, Model model) {
		model.addAttribute("error", "Error null pointer");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp", LocalDate.now());
		return "error/internal-error";
	}	
	
	@ExceptionHandler(CocheNoExisteException.class)
	public String cocheNotFoundException(CocheNoExisteException ex, Model model) {
		model.addAttribute("titulo", titulo);
		model.addAttribute("error", "El Coche no existe en la lista");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("timestamp", LocalDate.now());		
		return "coches/error/coche-error";
	}

}
