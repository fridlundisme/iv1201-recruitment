/*Comments later*/

package iv1201.group1.applications.recruitment.controller;

import iv1201.group1.applications.recruitment.model.Model;

public class LoginController {
    Model model = new Model();

    /**
     * Attempt to login has been made
     * */
    boolean tryLogin(String username, String password){
        return model.loginAttempt(username, password);
    }
}

