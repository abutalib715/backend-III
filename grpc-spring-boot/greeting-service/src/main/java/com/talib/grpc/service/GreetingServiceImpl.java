package com.talib.grpc.service;

import com.talib.grpc.GreetingRequest;
import com.talib.grpc.GreetingResponse;
import com.talib.grpc.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greet(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);

        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Received your: " + message + ". Hello from server")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}
