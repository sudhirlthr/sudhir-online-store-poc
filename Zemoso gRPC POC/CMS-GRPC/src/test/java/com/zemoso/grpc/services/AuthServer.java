package com.zemoso.grpc.services;

import java.io.IOException;

import com.zemoso.grpc.proto.CmsBlogServiceImpl;
import com.zemoso.grpc.util.JwtServerInterceptor;

import io.grpc.Server;
import io.grpc.ServerBuilder;

public class AuthServer {

	  private Server server;
	  private int port;

	  public AuthServer(int port) {
	    this.port = port;
	  }

	  private void start() throws IOException {
	    server = ServerBuilder.forPort(port)
	        .addService(new CmsBlogServiceImpl())
	        .intercept(new JwtServerInterceptor())  // add the JwtServerInterceptor
	        .build()
	        .start();
	    
	    Runtime.getRuntime().addShutdownHook(new Thread() {
	      @Override
	      public void run() {
	        // Use stderr here since the logger may have been reset by its JVM shutdown hook.
	        System.err.println("*** shutting down gRPC server since JVM is shutting down");
	        AuthServer.this.stop();
	        System.err.println("*** server shut down");
	      }
	    });
	  }

	  private void stop() {
	    if (server != null) {
	      server.shutdown();
	    }
	  }

	  /**
	   * Await termination on the main thread since the grpc library uses daemon threads.
	   */
	  private void blockUntilShutdown() throws InterruptedException {
	    if (server != null) {
	      server.awaitTermination();
	    }
	  }

	  /**
	   * Main launches the server from the command line.
	   */
//	  public static void main(String[] args) throws IOException, InterruptedException {
//
//	    // The port on which the server should run
//	    int port = 50051; // default
//	    if (args.length > 0) {
//	      port = Integer.parseInt(args[0]);
//	    }
//
//	    final AuthServer server = new AuthServer(port);
//	    server.start();
//	    server.blockUntilShutdown();
//	  }

	}