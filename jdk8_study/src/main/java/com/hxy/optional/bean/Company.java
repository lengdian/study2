package com.hxy.optional.bean;

import java.util.List;

public class Company
{
    private String companyName;

    private List<Employee> employeeList;

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public List<Employee> getEmployeeList()
    {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList)
    {
        this.employeeList = employeeList;
    }
}
