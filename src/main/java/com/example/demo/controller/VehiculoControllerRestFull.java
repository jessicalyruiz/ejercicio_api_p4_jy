package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.IVehiculoService;
import com.example.demo.service.TO.VehiculoTO;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import org.springframework.hateoas.Link;


@RestController
@RequestMapping(path = "/vehiculos")
@CrossOrigin
public class VehiculoControllerRestFull {
	@Autowired
	private IVehiculoService vehiculoService;
	

	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<VehiculoTO> consultarTodos(){
		List<VehiculoTO> lista=this.vehiculoService.consultatTodos();
		
		for (VehiculoTO v : lista) {
			
			Link myLink=linkTo( methodOn(VehiculoControllerRestFull.class).consultarPlaca(v.getPlaca())).withRel("vehi");
			v.add(myLink);
		}
		
		return lista;
	}
	
	@GetMapping(path = "/{placa}")
	public VehiculoTO consultarPlaca(@PathVariable String placa) {
		return this.vehiculoService.consultarPlaca(placa);
	}

	
	
}
