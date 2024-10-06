package com.tns.as.mp;

import org.springframework.data.jpa.repository.JpaRepository; //The JpaRepository interface provides a set of generic methods for performing CRUD  operations on a specific entity type.

public interface AnkithaMallRepository extends JpaRepository<AnkithaMall,Integer> {

}
