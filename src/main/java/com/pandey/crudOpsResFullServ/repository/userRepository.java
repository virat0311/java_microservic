package com.pandey.crudOpsResFullServ.repository;

import com.pandey.crudOpsResFullServ.entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface userRepository extends JpaRepository<user,Long> {
}
