package com.ecommerce.ECommerce.model.dao;

import com.ecommerce.ECommerce.model.LocalUser;
import org.springframework.data.repository.CrudRepository;

public interface LocalUserDAO extends CrudRepository<LocalUser, Long> {
}
