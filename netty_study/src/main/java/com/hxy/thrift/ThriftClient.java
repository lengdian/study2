package com.hxy.thrift;

import com.hxy.thrift.generated.Person;
import com.hxy.thrift.generated.PersonService;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class ThriftClient
{
    public static void main(String[] args)
    {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try
        {
            transport.open();

            Person person=client.getPersonByUsername("hxy");

            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("---------");

            Person person2=new Person();
            person2.setUsername("hy");
            person2.setAge(21);
            person2.setMarried(true);

            client.savePerson(person2);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e.getMessage(), e);
        }
        finally
        {
            transport.close();
        }

    }
}
