package com.hxy.grpc;

import com.hxy.proto.*;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceGrpc.StudentServiceImplBase
{
    @Override
    public void getRealnameByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver)
    {
        System.out.println("接收到客户端信息：" + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("hxy").build());
        responseObserver.onCompleted();
    }

    @Override
    public void getStudentsByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver)
    {
        System.out.println("接收到客户端信息：" + request.getAge());

        responseObserver.onNext(StudentResponse.newBuilder().setName("hxy1").setAge(24).setCity("guangzhou").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("hxy2").setAge(25).setCity("guangzhou").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("hxy3").setAge(26).setCity("guangzhou").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("hxy4").setAge(27).setCity("guangzhou").build());

        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<StudentRequest> getStudentsWrapperByAge(StreamObserver<StudentResponseList> responseObserver)
    {
        return new StreamObserver<StudentRequest>()
        {
            @Override
            public void onNext(StudentRequest value)
            {
                System.out.println("onNext:" + value.getAge());
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {
                StudentResponse sr1 = StudentResponse.newBuilder().setName("hxy").setAge(27).setCity("gz").build();
                StudentResponse sr2 = StudentResponse.newBuilder().setName("hxy2").setAge(28).setCity("fs").build();

                StudentResponseList srList = StudentResponseList.newBuilder().addStudentResponse(sr1)
                        .addStudentResponse(sr2).build();

                responseObserver.onNext(srList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTalk(StreamObserver<StreamResponse> responseObserver)
    {
        return new StreamObserver<StreamRequest>()
        {
            @Override
            public void onNext(StreamRequest value)
            {
                System.out.println(value.getRequestInfo());

                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString())
                        .build());
            }

            @Override
            public void onError(Throwable t)
            {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted()
            {
                responseObserver.onCompleted();
            }
        };
    }
}
