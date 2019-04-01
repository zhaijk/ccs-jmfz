package com.derun.jczb.controller;

//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;

@RestController
@RequestMapping("users")
public class WebFluxControllers {
	/*@GetMapping("/{userid}")
	public Mono<String> getUser(@PathVariable long userid){
		return Mono.just("Mono say Hello "+userid);
	}
	@GetMapping("{userid}/customers")
	public Flux<String> getUserCustmers(@PathVariable long userid){
		return Flux.just("Flux say Hi"+userid);		
	}*/
}
