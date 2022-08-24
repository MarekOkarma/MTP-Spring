package MetThePet.controller;

import MetThePet.model.User;
import MetThePet.service.AutologinService;
import MetThePet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class RegistrationController {

    private final UserService userService;

    private final AutologinService autologinService;

    public RegistrationController(UserService userService, AutologinService autologinService) {
        this.userService = userService;
        this.autologinService = autologinService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(ModelMap modelMap) {
        modelMap.addAttribute("emptyUser", new User());
        return "registration";
    }
}