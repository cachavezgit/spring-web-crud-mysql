package com.wilsondevelopment.springwebcrudmysql.repositories;

import org.springframework.data.repository.CrudRepository;

import com.wilsondevelopment.springwebcrudmysql.entities.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}
