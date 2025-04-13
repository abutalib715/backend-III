package com.talib.grpc;

import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class HelloGrpcClient {

    @GrpcClient("helloService")
    private HelloServiceGrpc.HelloServiceBlockingStub helloServiceStub;

    public String sendMessage(String name) {
        HelloRequest request = HelloRequest.newBuilder().setName(name).build();
        HelloResponse response = helloServiceStub.sayHello(request);
        return response.getMessage();
    }
}