package com.is.trottinette.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.is.trottinette.models.Activation;


@Repository
public interface ActivationRepository extends JpaRepository<Activation, Long> {

}
