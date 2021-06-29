package com.group.asd.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.group.asd.entity.FixedAsset;

@Repository
public interface FixedAssetRepository extends JpaRepository<FixedAsset,Integer> {
	
	@Query(value = "SELECT * FROM activos_fijos af WHERE (coalesce(:type, null) is null OR af.fk_tipo = :type) "
			+ "AND (coalesce(:purchaseDate, null) is null OR af.fecha_compra = :purchaseDate) "
			+ "AND (coalesce(:serial, null) is null OR af.serial LIKE %:serial%)", nativeQuery = true)
	List<FixedAsset> searchFixedAssetsByFilter(String type, Date purchaseDate, String serial);

}
