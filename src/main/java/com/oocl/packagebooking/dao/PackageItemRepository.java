package com.oocl.packagebooking.dao;

import com.oocl.packagebooking.entity.PackageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PackageItemRepository extends JpaRepository<PackageItem, Integer> {
}
