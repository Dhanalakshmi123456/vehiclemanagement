package com.cg.vmtoolapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.vmtoolapi.domain.Booking;
import com.cg.vmtoolapi.domain.Payment;
import com.cg.vmtoolapi.repository.PaymentRepository;

@Service 
public class PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}
	public void cancelPayment(Payment p) {
		 paymentRepository.delete(p);
	}
	public Iterable<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
}