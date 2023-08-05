package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.repository.modelo.Vehiculo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VehiculoRepoImpl implements IVehiculoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void create(Vehiculo vehiculo) {
		// TODO Auto-generated method stub
		this.entityManager.persist(vehiculo);
	}

	@Override
	public List<Vehiculo> consultatTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Vehiculo> myQuery=this.entityManager.createQuery("Select v from Vehiculo v ", Vehiculo.class);
		return myQuery.getResultList();
	}

	@Override
	public Vehiculo consultarPlaca(String placa) {
		TypedQuery<Vehiculo> myqQuery=this.entityManager.createQuery("Select v from Vehiculo v where v.placa=:valor ", Vehiculo.class);
		myqQuery.setParameter("valor", placa);
				
		return myqQuery.getSingleResult();
	}

}
