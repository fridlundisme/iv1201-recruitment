package iv1201.group1.applications.recruitment.controller.exceptionhandling;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ControllerAdvice
class PageExceptionController implements ErrorController{
    private static final String DEFAULT_ERROR_VIEW = "error";
    private static final String ERROR_PATH = "failure";
    private static final String ERROR_404 = "Page not found";
    private static final String ERROR_DEFAULT = "Something went wrong, we are sorry about that. Please try again";

    @GetMapping("/" + ERROR_PATH)
    public String defaultErrorHandler(HttpServletRequest request, Model model) throws Exception {
        String statusCode = extractHttpStatusCode(request);
        statusCode = "200";
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
        // TODO Auto-generated method stub
        return DEFAULT_ERROR_VIEW;
    }
}