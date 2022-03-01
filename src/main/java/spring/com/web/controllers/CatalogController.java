package spring.com.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.com.web.entities.Catalog;
import spring.com.web.service.CatalogService;

@Controller
public class CatalogController {

	@Autowired
	private CatalogService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Catalog> listCatalog = service.listAll();
		model.addAttribute("listCatalog", listCatalog);
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewProductPage(Model model) {
		Catalog catalog = new Catalog();
		model.addAttribute("catalog", catalog);
		return "add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("catalog") Catalog catalog) {
		service.save(catalog);
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit");
		Catalog catalog = service.get(id);
		mav.addObject("catalog", catalog);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";		
	}
}
