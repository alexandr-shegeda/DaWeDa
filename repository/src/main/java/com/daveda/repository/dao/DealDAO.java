package com.daveda.repository.dao;


import com.daweda.model.entity.Deal;
import java.util.List;

public interface DealDAO extends AbstractDAO<Deal>{

	List<Deal> findCurrentByAsset(String assetName);
	//Place here necessary methods{
	//public long insert(Deal deal);
//	public Deal findById(int id);
//	public Deal findByCoverId(int coverId);
//	public Deal findByCoveredId(int coveredId);
//	public void delete(int id);
}
