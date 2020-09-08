package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.is.trottinette.models.Trottinette;

public interface TrottinetteRepository extends JpaRepository<Trottinette, Long>{

}
