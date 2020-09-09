package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.trottinette.models.Emprunt;

@Repository
public interface EmpruntRepository extends JpaRepository<Emprunt, Long> {

}
