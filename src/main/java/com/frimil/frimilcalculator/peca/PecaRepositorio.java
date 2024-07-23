package com.frimil.frimilcalculator.peca;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecaRepositorio extends JpaRepository<Peca, Long> {


}
