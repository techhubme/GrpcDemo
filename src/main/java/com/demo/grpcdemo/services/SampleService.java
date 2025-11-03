package com.demo.grpcdemo.services;

import com.demo.grpc.services.order.RequestMessage;
import com.demo.grpc.services.order.ResponseMessage;
import com.demo.grpc.services.order.SampleServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

/**
 * OrderService GRPC Service
 *
 * @author Ram Niwash
 */
@Slf4j
public class SampleService extends SampleServiceGrpc.SampleServiceImplBase{

    @Override
    public StreamObserver<RequestMessage> operate(StreamObserver<ResponseMessage> response) {

        return new StreamObserver<>() {

            @Override
            public void onNext(RequestMessage request) {
                String message = request.getMessage();
                log.info("MESSAGE = {}",request.getMessage());
                response.onNext(ResponseMessage.newBuilder().setMessage(message).build());
            }

            @Override
            public void onError(Throwable ex) {
                log.error("Exception :) ", ex);
            }

            @Override
            public void onCompleted() {
                response.onCompleted();
            }
        };
    }
}
