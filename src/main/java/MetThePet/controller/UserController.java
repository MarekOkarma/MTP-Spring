package MetThePet.controller;

import MetThePet.dto.PasswordDto;
import MetThePet.exception.InvalidPasswordException;
import MetThePet.exception.WrongPasswordException;
import MetThePet.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/password/change")
    public String showChangePasswordForm(ModelMap modelMap) {
        modelMap.addAttribute("passwordDto", new PasswordDto());
        return "user-change-password";
    }

    @PostMapping("/users/password/save")
    public String handleChangedPassword(@ModelAttribute("passwordDto") PasswordDto passwordDto, ModelMap modelMap) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        try {
            userService.changePassword(username, passwordDto);
            log.info("Changed password for user with username " + username);
        } catch (WrongPasswordException | InvalidPasswordException e) {
            log.error(e.getMessage());
            modelMap.addAttribute("exceptionMessage", e.getMessage());
            return "user-change-password";
        }

        for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_ADMIN":  return "redirect:/admin/panel";
                case "ROLE_USER": return "redirect:/user/panel";
            }
        }

        throw new IllegalStateException("Unrecognized role");
    }

}