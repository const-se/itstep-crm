package shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import shop.entity.Brand;
import shop.entity.Cart;
import shop.entity.Category;
import shop.entity.Thing;
import shop.repositroy.BrandRepository;
import shop.repositroy.CategoryRepository;
import shop.repositroy.ThingRepository;

import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Controller
public class ShopController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ThingRepository thingRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories",categories);

        Iterable<Brand> brands = brandRepository.findAll();
        model.addAttribute("brands", brands);
        return "shop/index";

    }
    @GetMapping("/category/{id}/")
    public String category(@PathVariable(name = "id")Category category, Model model) {
        Iterable<Thing> things = thingRepository.findAllByCategory(category);
        model.addAttribute("category_name", category.getName());
        model.addAttribute("things", things);

        return "shop/category";
    }
    @GetMapping("/brand/{id}/")
    public String brand(@PathVariable(name = "id")Brand brand, Model model){
        Iterable<Thing> things = thingRepository.findAllByBrand(brand);
        model.addAttribute("brand_name", brand.getName());
        return "shop/brand";
    }
    @GetMapping("/thing/{id}/")
    public String thing(@PathVariable(name = "id") Thing thing, Model model) {
        model.addAttribute("thing", thing);

        return "shop/thing";
    }

    @GetMapping("/add-to-cart/{id}/")
    public String addToCart(@PathVariable(name = "id")Thing thing, @CookieValue(name = "cart_id")String cart_id
                            , HttpServletResponse response
                            ) {
        Optional<Cart> cartOptional = categoryRepository.findAllById(Long.parseLong(cart_id));
        Cart cart= cartOptional.isPresent() ? cartOptional.get() : new Cart();

    }
}
