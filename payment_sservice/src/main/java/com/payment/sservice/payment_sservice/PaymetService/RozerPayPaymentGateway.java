package com.payment.sservice.payment_sservice.PaymetService;

import com.payment.sservice.payment_sservice.dtoes.BookingDtos;
import com.payment.sservice.payment_sservice.dtoes.Bookingstatus;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import jakarta.annotation.PostConstruct;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RozerPayPaymentGateway {

    @Value("${razorpay.key_id}")
    private String keyId;

    @Value("${razorpay.key_secret}")
    private String secretKey;

    private RazorpayClient client;

    @PostConstruct
    public void init() throws Exception {
        client = new RazorpayClient(keyId, secretKey);
    }

    public BookingDtos processPayment(BookingDtos bookingDtos) {

        try {

            // 1️⃣ Create Razorpay Order (THIS IS OK)
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", bookingDtos.getBookingAmount() * 100); // in paise
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "txn_" + System.currentTimeMillis());

            Order order = client.orders.create(orderRequest);
            System.out.println("Order Created: " + order.get("id"));

            // 2️⃣ DO NOT CALL CAPTURE() — Razorpay will throw 404 for fake IDs
            System.out.println("Simulating Razorpay Payment Success (Backend Only)...");

            // 3️⃣ Update booking status manually (simulate success)
            bookingDtos.setBookingstatus(Bookingstatus.CONFIRMED);

        } catch (Exception e) {
            System.out.println("❌ Error during payment simulation: " + e.getMessage());
            bookingDtos.setBookingstatus(Bookingstatus.CANCELLED);
        }

        // 4️⃣ Return updated DTO
        return bookingDtos;
    }
}
