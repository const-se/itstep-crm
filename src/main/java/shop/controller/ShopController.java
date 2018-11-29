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
import shop.repository.BrandRepository;
import shop.repository.CartRepository;
import shop.repository.CategoryRepository;
import shop.repository.ThingRepository;

import java.util.Optional;

@Controller
public class ShopController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ThingRepository thingRepository;

    @Autowired
    private CartRepository cartRepository;

    @GetMapping("/")
    public String index(Model model) {
        Iterable<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);

        Iterable<Brand> brands = brandRepository.findAll();
        model.addAttribute("brands", brands);
        return "shop/index";
    }

    @GetMapping("/category/{id}/")
    public String category(@PathVariable(name = "id") Category category, Model model) {
        Iterable<Thing> things = thingRepository.findAllByCategory(category);
        model.addAttribute("category", category.getName());
        model.addAttribute("things", things);

        return "shop/category";
    }

    @GetMapping("/brand/{id}/")
    public String brand(@PathVariable(name = "id") Brand brand, Model model) {
        Iterable<Thing> things = thingRepository.findAllByBrand(brand);
        model.addAttribute("brand", brand.getName());
        model.addAttribute("things", things);

        return "shop/brand";
    }

    @GetMapping("/thing/{id}/")
    public String thing(@PathVariable(name = "id") Thing thing, Model model) {
        model.addAttribute("thing", thing);
        return "shop/thing";
    }

    @GetMapping("add-to-catr/{id}/")
    public String addToCart(
            @PathVariable(name = "id") Thing thing;
            @CookieValue() String cart_id
    ){
        Optional<Cart> cartOptional= cartRepository.findById(Long.parseLong(cart_id));
        Cart cart = cartOptional.isPresent()? cartOptional.get() : new Cart();
        cart.getThi
        return "";
    }
}
