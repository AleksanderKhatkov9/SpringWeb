package spring.com.web.controllers;

import java.util.List;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import spring.com.web.entities.Catalog;
import spring.com.web.repositories.CatalogRepository;
import spring.com.web.service.CatalogService;

/**@author Sasha Hatkov
 * @// TODO: 10.03.2022  Добавить возможность пагинации
 *
 *
 */



@Controller
public class CatalogController {

    @Autowired
    private CatalogService service;
    private CatalogRepository repository;

    @RequestMapping("/")
    public String viewHomePage(Model model, @Param("keyword") String keyword) {
        List<Catalog> listCatalog = service.listAll(keyword);
        model.addAttribute("listCatalog", listCatalog);
        model.addAttribute("keyword", keyword);
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

    @GetMapping("/page")
    public String listCatalog(
            Model model,
//            @RequestParam(value = "size", required = false, defaultValue = "0") Integer size,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        Page<Catalog> pageCatalog = repository.findAll(PageRequest.of(page, 3));
        model.addAttribute("pageCatalog", pageCatalog);
        model.addAttribute("numbers", IntStream.range(0, pageCatalog.getTotalPages()).toArray());
        return "index";

    }

}
