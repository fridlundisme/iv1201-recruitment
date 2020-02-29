package iv1201.group1.applications.recruitment.exceptionhandling;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import iv1201.group1.applications.recruitment.domain.Person;
import iv1201.group1.applications.recruitment.error.UserAlreadyExistException;

@Controller
@ControllerAdvice
class ResponseExceptionController implements ErrorController{
    private static final String DEFAULT_ERROR_VIEW = "error";
    private static final String ERROR_PATH = "failure";
    private static final String ERROR_404 = "Page not found";
    private static final String ERROR_DEFAULT = "Something went wrong, we are sorry about that. Please try again";


    @GetMapping("/" + ERROR_PATH)
    public String defaultErrorHandler(HttpServletRequest request, Model model) throws Exception {
        String statusCode = extractHttpStatusCode(request);
        switch (statusCode) {
            case "404":
                model.addAttribute("errorType",statusCode);
                model.addAttribute("errorMsg", ERROR_404);
                break;
            default:
                model.addAttribute("errorType",statusCode);
                model.addAttribute("errorMsg", ERROR_DEFAULT);
                break;
        }
        // Otherwise setup and send the user to a default error-view.
        return getErrorPath();
    }

    private String extractHttpStatusCode(HttpServletRequest request) {
        return request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE).toString();
    }

    @Override
    public String getErrorPath() {
        return DEFAULT_ERROR_VIEW;
    }

    @ExceptionHandler({ UserAlreadyExistException.class })
    public ModelAndView handleUserAlreadyExist(final RuntimeException ex, final WebRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("userExist", "User already exists");
        mav.addObject("registrationForm", new Person());
        mav.setViewName("registration");
        
        return mav;
    }
}