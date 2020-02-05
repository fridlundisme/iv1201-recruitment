/**
 * Comments later
 * */

package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.model.Model;

public class LoginController {
    Model model = new Model();

    /**
     * Attempt to login has been made
     * */
    boolean tryLogin(LoginDetails loginDetails){
        return model.loginAttempt(loginDetails);
    }
}

