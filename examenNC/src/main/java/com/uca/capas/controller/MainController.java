package com.uca.capas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.CategoriaDAO;
import com.uca.capas.dao.LibroDAO;
import com.uca.capas.domain.Categoria;
import com.uca.capas.domain.Libro;


@Controller
public class MainController {
	
	@Autowired 
	LibroDAO libroDAO;
	
	@Autowired
	CategoriaDAO cateDAO;

	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;		
	}
	
	
	
	@RequestMapping("/verLibros")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		List<Libro> libros = libroDAO.findAll(); 
		//Importancia importancias = importanciaDao.findOne(2);
		try {
			mav.addObject("libro", libros);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		mav.setViewName("showlibros");
		return mav;
	}
	
	/*@RequestMapping("/guardarCategoria")
	public ModelAndView guardarCategoriaIndex() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresarCategoria");
		return mav;		
	}*/
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView guardar(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Categoria categoria1 = new Categoria();
		mav.addObject("categoria", categoria1);
		mav.setViewName("ingresarCategoria");
		if(result.hasErrors()) {
			mav.setViewName("ingresarCategoria");
			System.out.println("Entre aqui pq tengo errores");
		}
		else {
			System.out.println("Estoy aqui");
			cateDAO.save(categoria);
			mav.setViewName("index");
		}	
		return mav;
	}
	
	/*@RequestMapping("/guardarLibro")
	public ModelAndView guardarLibroIndex() {
		ModelAndView mav = new ModelAndView();
		Libro libro = new Libro();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.addObject("libro", libro);
		mav.setViewName("ingresarLibro");
		return mav;		
	}*/
	
	@RequestMapping("/ingresarLibro")
	public ModelAndView guardarLibro(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		Libro libro1 = new Libro();
		Categoria categoria = new Categoria();
		mav.addObject("libro", libro1);
		List<Categoria> categorias = null;
		categorias = cateDAO.findAll();
		mav.addObject("categoria", libro1.getCategoria());
		mav.addObject("categorias", categorias);
		mav.setViewName("ingresarLibro");
		if(result.hasErrors()) {
			mav.setViewName("ingresarLibro");
			System.out.println("Entre aqui pq tengo errores");
		}
		else {
			System.out.println("Estoy aqui");
			libroDAO.save(libro);
			mav.setViewName("index");
		}	
		return mav;
	}
	
	/*@RequestMapping("/ingresarCategoria")
	public ModelAndView guardar(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("index");
			System.out.println("Entre aqui pq tengo errores");
		}
		else {
			System.out.println("Estoy aqui");
			libroDAO.save(libro);
			mav.setViewName("exito");
		}	
		return mav;
	}*/
	
	
}
