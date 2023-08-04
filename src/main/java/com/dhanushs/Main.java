package com.dhanushs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }

    @GetMapping("/welcome")
    public EmployeeData welcome(@RequestParam(value = "name", required = false) String name){
        String getMessage = name == null || name.isEmpty() ? "Hello" : "BelloOo " + name ;
        EmployeeData employeeData = new EmployeeData(
                getMessage ,
                new Employee("08-06-2001",
                        "Chennai" ,
                        "sdhanushit@gmail.com"
                ),
                List.of("Java","ReactJS","Spring Framework")
        );
        return employeeData ;
    }

    record EmployeeData (String name , Employee employee , List<String> skills){}

    record Employee (String dob , String Location , String email){}


//    class EmployeeData {
//
//        private final String fName ;
//
//
//        EmployeeData(String fName) {
//            this.fName = fName;
//        }
//
//        public String getfName() {
//            return fName;
//        }
//
//        @Override
//        public String toString() {
//            return "EmployeeData{" +
//                    "fName='" + fName + '\'' +
//                    '}';
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (!(o instanceof EmployeeData that)) return false;
//            return Objects.equals(getfName(), that.getfName());
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(getfName());
//        }
//    }

}
