
package com.example.EA2_Ramos.repository;

import com.example.EA2_Ramos.model.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
}