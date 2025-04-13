package com.talib.grpc.service;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(9090)
                .addService(new GreetingServiceImpl()) // Your gRPC service
                .addService(ProtoReflectionService.newInstance()) // Enable Reflection
                .build()
                .start();

        System.out.println("gRPC Server started on port 9090 with Reflection enabled");
        server.awaitTermination();
    }
}