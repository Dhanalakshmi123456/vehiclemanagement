package com.cg.vmtoolapi.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.vmtoolapi.domain.Payment;
import com.cg.vmtoolapi.service.PaymentService;

import antlr.collections.List;

@RestController
@RequestMapping("/api/vehiclemanagement/payment")

public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/add")
	public void addPayment(@RequestBody Payment payment)
	{
		paymentService.addPayment(payment);
	}
	@GetMapping("/getAllPayments")
	public Iterable<Payment> getAllPayments(){
	    return paymentService.getAllPayments();
	}
	@DeleteMapping("/delete")
	public ResponseEntity<String> cancelPayment(@RequestBody Payment p)
	{
	  paymentService.cancelPayment(p);
	  return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
}