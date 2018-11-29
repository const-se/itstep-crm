package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.entity.Brand;
import shop.entity.Category;
import shop.entity.Thing;
import shop.repository.CategoryRepository;
import shop.repository.ThingRepository;

@Controller
public class ShopController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ThingRepository thingRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        return "shop/index";
    }

    @GetMapping("/category/{id}/")
    public String category(@PathVariable(name = "id") Category category, Model model) {
        Iterable<Thing> things = thingRepository.findAllByCategory(category);
        model.addAttribute("things", things);

        return "shop/category";
    }

    @GetMapping("/brand/{id}/")
    public String brand(@PathVariable(name = "id") Brand brand, Model model) {
        Iterable<Thing> things = thingRepository.findAllByBrand(brand);
        model.addAttribute("things", things);

        return "shop/brand";
    }

    @GetMapping("/thing/{id}/")
    public String thing() {
        return "";
    }
}
