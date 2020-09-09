package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.trottinette.models.Abonne;

@Repository
public interface AbonneRepository extends JpaRepository<Abonne, Long> {

}
