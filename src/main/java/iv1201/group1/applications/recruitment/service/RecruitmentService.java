package iv1201.group1.applications.recruitment.service;

import iv1201.group1.applications.recruitment.domain.Person;

import java.util.List;

/**
 * interface for services that handles recruitment.
 */
public interface RecruitmentService {
   List<Person> getPersonList();
}
