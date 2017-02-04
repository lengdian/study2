package com.hxy.optional;

import com.hxy.optional.bean.Company;
import com.hxy.optional.bean.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//Optional对集合的操作
public class $2_OptionTest2
{
    public static void main(String[] args)
    {
        Employee e1 = new Employee();
        e1.setName("hxy");

        Employee e2 = new Employee();
        e2.setName("huang");

        List<Employee> employeeList = Arrays.asList(e1, e2);

        Company company = new Company();
        company.setCompanyName("company1");
        company.setEmployeeList(employeeList);

        //推荐写法，返回集合时，如果集合为空，则返回空的集合，而不是null
        Optional<Company> optional = Optional.ofNullable(company);
        System.out.println(optional.map(theCompany -> theCompany.getEmployeeList()).orElse(Collections.emptyList()));

    }
}
