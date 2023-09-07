package com.mcy.watertracker.respository;

import com.mcy.watertracker.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
