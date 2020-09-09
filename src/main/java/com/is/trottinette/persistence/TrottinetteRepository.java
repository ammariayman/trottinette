package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.trottinette.models.Trottinette;

@Repository
public interface TrottinetteRepository extends JpaRepository<Trottinette, Long>{

}
