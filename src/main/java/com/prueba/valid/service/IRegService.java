package com.prueba.valid.service;

import java.util.List;
import java.util.Optional;

import com.prueba.valid.modelo.Registro;

/**
 * 
 * @date   03-03-2021
 * @author cmosquera <cmosquerara@gmail.com>
 * 
 */

public interface IRegService {

	List<Registro> getRegistros();

	void createRegistro(Registro reg);

	void updateRegistro(Registro reg);

	Optional<Registro> findByIdRegistro(Long idRegistro);

}