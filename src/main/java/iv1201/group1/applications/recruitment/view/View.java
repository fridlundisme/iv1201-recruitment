package iv1201.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class View {

    @GetMapping("/")
    public String greeting (String string) {
        return "Hej";
	}
}