package example.api;

import net.rossillo.spring.web.mvc.CacheControl;
import net.rossillo.spring.web.mvc.CachePolicy;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.representations.IDToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@CacheControl(policy = CachePolicy.NO_CACHE)
public class ExampleController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String handleHomePageRequest(@SuppressWarnings("unused") Model model) {
        return "home";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String handleUserRequest(KeycloakAuthenticationToken principal, Model model) {
        model.addAttribute("principal",  principal);

        if(principal.getPrincipal() instanceof KeycloakPrincipal) {
            @SuppressWarnings("unchecked")
            KeycloakPrincipal<KeycloakSecurityContext> kp = (KeycloakPrincipal<KeycloakSecurityContext>) principal.getPrincipal();
            IDToken token = kp.getKeycloakSecurityContext().getIdToken();
            model.addAttribute("token", token);
        }
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String handleAdminRequest(Principal principal, Model model) {
        model.addAttribute("principal",  principal);
        return "admin";
    }

    @ModelAttribute("serviceName")
    public String populateServiceName() {
        return "Example";
    }
}
