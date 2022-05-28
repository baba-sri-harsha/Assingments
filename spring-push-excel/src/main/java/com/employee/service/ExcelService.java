package com.employee.service;

import com.employee.helper.ExcelHelper;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Service class used for implementing the crud operations in the repository
 */
@Service
public class ExcelService {

    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * InputStream , represents an ordered stream of bytes.
     * In other words, you can read data from a Java InputStream as
     * an ordered sequence of bytes.This is useful when reading data from a file,
     * or received over the network.
     *
     * Multipart requests combine one or more sets of data into a
     * single body, separated by boundaries. You typically use these requests for
     * file uploads and for transferring data of several types in a single request
     * @param file
     */
    public void save(MultipartFile file) {
        try {
            List<Employee> employees = ExcelHelper.excelToEmployee(file.getInputStream());
            employeeRepository.saveAll(employees);
        } catch (IOException e) {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }

    /**
     * @return List of employees
     */
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
