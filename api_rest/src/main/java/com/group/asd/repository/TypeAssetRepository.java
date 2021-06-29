package com.group.asd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.group.asd.entity.TypeAsset;

@Repository
public interface TypeAssetRepository extends JpaRepository<TypeAsset, Integer> {
}
