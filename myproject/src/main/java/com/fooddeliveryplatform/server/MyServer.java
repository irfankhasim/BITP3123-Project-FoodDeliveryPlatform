package com.fooddeliveryplatform.server;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.fooddeliveryplatform.httphandler.AuthHandler;
import com.fooddeliveryplatform.httphandler.AuthMiddleware;
import com.fooddeliveryplatform.httphandler.RestaurantApiHandler;
import com.fooddeliveryplatform.httphandler.UserApiHandler;
import com.fooddeliveryplatform.httphandler.FoodItemApiHandler;
import com.fooddeliveryplatform.httphandler.DeliveryTrackingApiHandler;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MyServer {

    private HttpServer server;

    public MyServer(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(null); // creates a default executor
        addHandler("/api/auth", new AuthHandler());
        addHandler("/api/customers", new AuthMiddleware(new UserApiHandler(), "CUSTOMER"));
        addHandler("/api/restaurants", new AuthMiddleware(new RestaurantApiHandler(), "RESTAURANT"));
        addHandler("/api/fooditems", new FoodItemApiHandler());
        addHandler("/api/delivery", new AuthMiddleware(new DeliveryTrackingApiHandler(), "RESTAURANT"));
    }

    public void start() {
        server.start();
        System.out.println("Server started on port: " + server.getAddress().getPort());
    }

    public void stop() {
        server.stop(0);
        System.out.println("Server stopped.");
    }

    public void addHandler(String context, HttpHandler handler) {
        server.createContext(context, handler);
    }
    
}
