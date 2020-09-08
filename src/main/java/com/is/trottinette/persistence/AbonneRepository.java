package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.is.trottinette.models.Abonne;

public interface AbonneRepository extends JpaRepository<Abonne, Long> {

}
