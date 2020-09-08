package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.is.trottinette.models.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}
