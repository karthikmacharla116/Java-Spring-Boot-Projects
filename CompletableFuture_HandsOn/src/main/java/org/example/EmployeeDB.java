package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    public static List<Employee> fetchEmployees() {
        ObjectMapper mapper  = new ObjectMapper();

        try {
            return mapper.readValue(new File("employees.json"),
                    new TypeReference<List<Employee>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
