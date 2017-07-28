package com.hxy.thrift;

import com.hxy.thrift.generated.DataException;
import com.hxy.thrift.generated.Person;
import com.hxy.thrift.generated.PersonService;
import org.apache.thrift.TException;

public class PersonServiceImpl implements PersonService.Iface
{
    @Override
    public Person getPersonByUsername(String username) throws DataException, TException
    {
        System.out.println("Got Client Param: " + username);

        Person person = new Person();
        person.setUsername(username);
        person.setAge(20);
        person.setMarried(false);

        return person;
    }

    @Override
    public void savePerson(Person person) throws DataException, TException
    {
        System.out.println("Got Client Param: ");

        System.out.println(person.getUsername());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
    }
}
