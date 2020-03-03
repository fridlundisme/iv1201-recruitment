package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Role;

/**
 * Functions/services for handling the table role that exists in the database.
 */
public interface RoleService {
   Role findByName(String name);
}
