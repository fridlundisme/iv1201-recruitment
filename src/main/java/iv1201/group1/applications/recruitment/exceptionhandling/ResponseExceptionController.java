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
import iv1201.group1.applications.recruitment.error.EmailAlreadyExistException;
import iv1201.group1.applications.recruitment.error.UserAlreadyExistException;

@Controller
@ControllerAdvice
class ResponseExceptionController implements ErrorController{
    private static final String DEFAULT_ERROR_VIEW = "error";
    private static final String ERROR_PATH = "failure";
    private static final String ERROR_404 = "Page not found";
    private static final String ERROR_500 = "Internal Server Error";
    private static final String ERROR_DEFAULT = "Something went wrong, we are sorry about that. Please try again";


    /**
     * Handles unspecified exceptions thrown by the system.
     * @param request HTTP request
     * @param model
     * @return the default error page
     * @throws Exception
     */
    @GetMapping("/" + ERROR_PATH)
    public String defaultErrorHandler(HttpServletRequest request, Model model)
    {
        String statusCode = extractHttpStatusCode(request);
        switch (statusCode) {
            case "404":
                model.addAttribute("errorType",statusCode);
                model.addAttribute("errorMsg", ERROR_404);
                break;
            case "500":
                model.addAttribute("errorType",statusCode);
                model.addAttribute("errorMsg", ERROR_500);
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

        /**
     * Handles the EmailAlreadyExistsException
     * @param ex RuntimeException
     * @param request Webrequest
     * @return New ModelAndView with a new registration form that displays the error message
     */
    @ExceptionHandler({ EmailAlreadyExistException.class })
    public ModelAndView handleEmailAlreadyExist(final RuntimeException ex, final WebRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("emailExist", "User with this email is already registered");
        mav.addObject("registrationForm", new Person());
        mav.setViewName("registration");
        
        return mav;
    }

    /**
     * Handles the UserAlreadyExistsException
     * @param ex RuntimeException
     * @param request Webrequest
     * @return New ModelAndView with a new registration form that displays the error message
     */
    @ExceptionHandler({ UserAlreadyExistException.class })
    public ModelAndView handleUserAlreadyExist(final RuntimeException ex, final WebRequest request) {
        ModelAndView mav = new ModelAndView();

        mav.addObject("userExist", "User already exists in database");
        mav.addObject("registrationForm", new Person());
        mav.setViewName("registration");
        
        return mav;
    }
}