package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Vehiculo;

public interface IVehiculoRepo {

	
	public void create(Vehiculo vehiculo);
	public List<Vehiculo> consultatTodos();
	public Vehiculo consultarPlaca(String placa);
}
