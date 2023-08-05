package com.example.demo.service;

import java.util.List;


import com.example.demo.repository.modelo.Vehiculo;
import com.example.demo.service.TO.VehiculoTO;

public interface IVehiculoService {

	
	public void create(Vehiculo vehiculo);
	public List<VehiculoTO> consultatTodos();
	public VehiculoTO consultarPlaca(String placa);
}
