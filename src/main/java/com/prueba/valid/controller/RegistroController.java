package com.prueba.valid.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.query.criteria.internal.predicate.IsEmptyPredicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.valid.modelo.Registro;
import com.prueba.valid.service.IRegService;
import com.prueba.valid.util.ErrorMessage;
import com.prueba.valid.util.ErrorMessage2;

/**
 * 
 * @date 03-03-2021
 * @author cmosquera <cmosquerara@gmail.com>
 * 
 */

@RestController
@RequestMapping(value = "valid/v1")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST,
		RequestMethod.OPTIONS }, allowedHeaders = "*")
public class RegistroController {

	@Autowired
	private IRegService regService;

	@RequestMapping(value = "")
	public ResponseEntity saludo() {
		List<Registro> list = new ArrayList<>();
		return new ResponseEntity(new ErrorMessage2(0, "Bienvenido a valid!"), HttpStatus.OK);
	}

	// servcio que trea el listado de registros

	@RequestMapping(value = "/getRegistros", method = RequestMethod.GET, headers = "Accept=application/json")
	public ResponseEntity<List<Registro>> getText() {
		List<Registro> listado = new ArrayList<>();
		listado = regService.getRegistros();
		if (listado.isEmpty()) {
			return new ResponseEntity(new ErrorMessage2(1, "No se ha encontrado informacion"), HttpStatus.OK);
		} else {
			return new ResponseEntity(new ErrorMessage(0, "Lista de registros", listado), HttpStatus.OK);
		}

	}

	// servicio para crear un registro

	@RequestMapping(value = "/createRegistro", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> createRegistro(@RequestBody Registro registro) {
		if (registro.getNombre().isEmpty() || registro.getApellido().isEmpty()) {
			return new ResponseEntity(new ErrorMessage2(1, "informacion incompleta"), HttpStatus.OK);
		}
		registro.setProcesado(false);
		regService.createRegistro(registro);
		return new ResponseEntity(new ErrorMessage2(0, "Registro creado con exito!"), HttpStatus.OK);
	}

	// servicio para actualizar uno o varios registros

	@RequestMapping(value = "/updatedRegistro", method = RequestMethod.POST, headers = "Accept=application/json")
	public ResponseEntity<?> updateRegistro(@RequestBody List<Registro> registros) {
		Registro registro;
		for (int i = 0; i < registros.size(); i++) {
			registro = registros.get(i);
			if (registro.getIdRegistro() != null) {
				Optional<Registro> reg = regService.findByIdRegistro(registro.getIdRegistro());
				if (!reg.isPresent()) {
					return new ResponseEntity(new ErrorMessage2(1, "No sea encontrado el registro"), HttpStatus.OK);
				}
				registro.setProcesado(true);
				regService.updateRegistro(registro);
			}
		}
		return new ResponseEntity(new ErrorMessage2(0, "registro actualizado con exito!"), HttpStatus.OK);
	}
}
