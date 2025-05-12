package com.drive.testsite.repositary;

import com.drive.testsite.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> { }
