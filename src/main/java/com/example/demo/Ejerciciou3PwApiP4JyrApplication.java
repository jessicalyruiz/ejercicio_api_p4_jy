package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.TO.VehiculoTO;

@SpringBootApplication
public class Ejerciciou3PwApiP4JyrApplication implements CommandLineRunner{

	@Autowired
	private IVehiculoService vehiculoService;
		
	public static void main(String[] args) {
		SpringApplication.run(Ejerciciou3PwApiP4JyrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Vehiculo vehiculo=new Vehiculo();
		vehiculo.setAnio(2019);
		vehiculo.setModelo("granCoupe");
		vehiculo.setPlaca("qw123");
		vehiculo.setValor(new BigDecimal(250000));
		//this.vehiculoService.create(vehiculo);
	}

}
