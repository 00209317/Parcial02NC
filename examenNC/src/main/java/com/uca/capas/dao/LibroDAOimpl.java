package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOimpl implements LibroDAO{
	
	@PersistenceContext(unitName="capas")
	private EntityManager libroManager;

	@Override
	public List<Libro> findAll() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		Query query = libroManager.createNativeQuery(sb.toString(), Libro.class);
		List<Libro>resulset=query.getResultList();
		return resulset;
	}

	@Override
	@Transactional
	public void save(Libro b) throws DataAccessException {
		libroManager.persist(b);		
	}


	
}
