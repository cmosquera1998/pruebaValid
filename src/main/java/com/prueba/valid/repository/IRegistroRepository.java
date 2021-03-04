package com.prueba.valid.repository;

import org.springframework.data.repository.CrudRepository;

import com.prueba.valid.modelo.Registro;
/**
 * 
 * @date   03-03-2021
 * @author cmosquera <cmosquerara@gmail.com>
 * 
 */

public interface IRegistroRepository extends CrudRepository<Registro, Long>  {

}
