package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import shop.entity.Category;
import shop.repository.CategoryRepository;

@Controller
public class ShopController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "shop/index";
    }

    @GetMapping("/category/{id}/")
    public String category() {
    }

    @GetMapping("/brand/{id}/")
    public String brand() {
    }

    @GetMapping("/thing/{id}/")
    public String thing() {
    }
}
