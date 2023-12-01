package com.github.chandanv89.api.periodictable.repository;

import com.github.chandanv89.api.periodictable.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeriodicTableRepository extends JpaRepository<Element,Integer> {
}
