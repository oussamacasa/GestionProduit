package org.sid.dao;


import java.util.List;
import java.util.Optional;

import org.sid.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduuitRepository extends JpaRepository<Produit, Long>{

	public Page<Produit> findBydescriptionContains(String mc,Pageable Pageablee );
	public Optional<Produit> findById(Long id);

}
