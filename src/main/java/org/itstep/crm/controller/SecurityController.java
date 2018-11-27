package org.itstep.crm.controller;

import org.itstep.crm.entity.Role;
import org.itstep.crm.entity.User;
import org.itstep.crm.repository.RoleRepository;
import org.itstep.crm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
public class SecurityController implements WebMvcConfigurer {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("security/login");
    }

    @GetMapping("/registration")
    public ModelAndView registration() {
        ModelAndView modelAndView = new ModelAndView("security/registration");
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/register")
    public RedirectView register(@Valid @ModelAttribute User user) {
        User existingUser = userRepository.findOneByUsername(user.getUsername());

        if (existingUser != null) {
            return new RedirectView("/registration?error=existing-user");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        Role role = roleRepository.findOneByName("ROLE_USER");
        user.getRoles().add(role);
        userRepository.save(user);

        return new RedirectView("/login");
    }
}
