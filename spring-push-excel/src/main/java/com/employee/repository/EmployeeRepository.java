package com.employee.repository;

import com.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Employee repository used for crud operations in the databse
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
