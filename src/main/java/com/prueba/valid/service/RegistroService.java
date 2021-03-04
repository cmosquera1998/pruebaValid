package com.prueba.valid.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.valid.modelo.Registro;
import com.prueba.valid.repository.IRegistroRepository;
/**
 * 
 * @date   03-03-2021
 * @author cmosquera <cmosquerara@gmail.com>
 * 
 */

@Service
public class RegistroService implements IRegService {

	@Autowired
	private IRegistroRepository regDao;

	/**
	 * Method to get all the task
	 * 
	 * @return
	 */

	@Override
	public List<Registro> getRegistros() {
		return (List<Registro>) regDao.findAll();
	}

	@Override
	public void createRegistro(Registro reg) {
		regDao.save(reg);

	}

	@Override
	public void updateRegistro(Registro reg) {
		regDao.save(reg);

	}

	@Override
	public Optional<Registro> findByIdRegistro(Long idRegistro) {
		return regDao.findById(idRegistro);
	}

}