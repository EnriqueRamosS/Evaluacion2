package com.example.EA2_Ramos.service;

import com.example.EA2_Ramos.model.Trabajador;
import com.example.EA2_Ramos.repository.TrabajadorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrabajadorService {
     @Autowired
     private TrabajadorRepository repository;
         /**
     * Funcion para listar la tabla trabajador
     * @return 
     */
    public List<Trabajador> listarTodas() {
        return repository.findAll();
    }
        /**
     * Funcion para guardar datos de una trabajador
     * @param trabajador 
     */
    public void guardar(Trabajador trabajador) {
        repository.save(trabajador);
    }
     /**
     * Funcion para buscar una trabajador por id
     * @param id
     * @return 
     */
    public Optional<Trabajador> buscarPorId(Long id) {
        return repository.findById(id);
    }
        /**
     * Funcion para eliminar el registro de una trabajador
     * @param id 
     */
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
