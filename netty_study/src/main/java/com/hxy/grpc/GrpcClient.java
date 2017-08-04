package com.hxy.grpc;

import com.hxy.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;

public class GrpcClient
{
    public static void main(String[] args)
    {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 8899).usePlaintext(true).build();

        //        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub
        // (managedChannel);
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
        //
        //        MyResponse response = blockingStub.getRealnameByUsername(MyRequest.newBuilder().setUsername("hy6")
        // .build());
        //        System.out.println(response.getRealname());
        //
        //        System.out.println("------------------------");
        //
        //        Iterator<StudentResponse> ite = blockingStub.getStudentsByAge(StudentRequest.newBuilder().setAge
        // (27).build());
        //
        //        while (ite.hasNext())
        //        {
        //            StudentResponse response1 = ite.next();
        //
        //            System.out.println(response1.getName() + ":" + response1.getAge() + ":" + response1.getCity());
        //
        //            System.out.println("------------------------");
        //
        //        }
        //
        //        System.out.println("------------------------");
        //
        //        StreamObserver<StudentResponseList> studentResponseListStreamObserver = new
        //                StreamObserver<StudentResponseList>()
        //        {
        //            @Override
        //            public void onNext(StudentResponseList value)
        //            {
        //                value.getStudentResponseList().forEach(studentResponse -> {
        //                    System.out.println(studentResponse.getName());
        //                    System.out.println(studentResponse.getAge());
        //                    System.out.println(studentResponse.getCity());
        //                    System.out.println("*********");
        //
        //                });
        //            }
        //
        //            @Override
        //            public void onError(Throwable t)
        //            {
        //                System.out.println(t.getMessage());
        //            }
        //
        //            @Override
        //            public void onCompleted()
        //            {
        //                System.out.println("completed!");
        //            }
        //        };
        //
        //        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentsWrapperByAge
        //                (studentResponseListStreamObserver);
        //
        //        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(25).build());
        //        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(30).build());
        //        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(35).build());
        //        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(40).build());
        //
        //        studentRequestStreamObserver.onCompleted();
        //
        //        try
        //        {
        //            Thread.sleep(5000);
        //        }
        //        catch (InterruptedException e)
        //        {
        //            e.printStackTrace();
        //        }

        System.out.println("---------------------");

        StreamObserver<StreamRequest> requestStreamObserver = stub.biTalk(new StreamObserver<StreamResponse>()
        {
            @Override
            public void onNext(StreamResponse value)
            {
                System.out.println(value.getResponseInfo());
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {
                System.out.println("onCompleted!");
            }
        });

        for (int i = 0; i < 10; i++)
        {
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString())
                    .build());

            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        requestStreamObserver.onCompleted();

        try
        {
            Thread.sleep(50000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
