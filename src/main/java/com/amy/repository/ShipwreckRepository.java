package com.amy.repository;

import com.amy.model.Shipwreck;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pivotal on 4/14/17.
 */
public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
