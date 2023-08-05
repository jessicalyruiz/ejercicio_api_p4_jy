package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.repository.IVehiculoRepo;
import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.TO.VehiculoTO;

@Service
public class VehiculoServiceImpl implements IVehiculoService {

	@Autowired
	private IVehiculoRepo vehiculoRepo;
	
	@Override
	public void create(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.vehiculoRepo.create(vehiculo);
	}

	@Override
	public List<VehiculoTO> consultatTodos() {
		// TODO Auto-generated method stub
		return this.vehiculoRepo.consultatTodos().stream().map(v->this.convertirVehiculo(v)).collect(Collectors.toList());
	}
	
	private VehiculoTO convertirVehiculo(Vehiculo vehiculo) {
		VehiculoTO vehi=new VehiculoTO();
		vehi.setAnio(vehiculo.getAnio());
		vehi.setId(vehiculo.getId());
		vehi.setModelo(vehiculo.getModelo());
		return vehi;
	}

	@Override
	public VehiculoTO consultarPlaca(String placa) {
		// TODO Auto-generated method stub
		return this.convertirVehiculo(this.vehiculoRepo.consultarPlaca(placa));
	}
	
}
