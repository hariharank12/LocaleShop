/**
 * 
 */
package com.org.doorstep.serviceimpl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.doorstep.daoimpl.BuyerDAOImpl;
import com.org.doorstep.dto.BuyerDTO;
import com.org.doorstep.entity.Buyer;
import com.org.doorstep.helper.JerseyDozerMapper;
import com.org.doorstep.service.BuyerService;

/**
 * @author hariharank12
 *
 */
@Service
public class BuyerServiceImpl implements BuyerService {

	@Autowired
	private BuyerDAOImpl buyerDAO;

	@Autowired
	private JerseyDozerMapper<Buyer, BuyerDTO> mapper;

	@Autowired
	private JerseyDozerMapper<BuyerDTO, Buyer> fwdMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.BuyerService#getBuyer(int)
	 */
	@Override
	public BuyerDTO getBuyer(int buyerId) {
		return mapper.map(buyerDAO.getBuyer(buyerId), BuyerDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.BuyerService#getAllBuyers()
	 */
	@Override
	public List<BuyerDTO> getAllBuyers() {
		return mapper.mapList(buyerDAO.getBuyers(), BuyerDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.BuyerService#updateBuyer(int,
	 * com.org.doorstep.dto.BuyerDTO)
	 */
	@Override
	@Transactional
	public BuyerDTO updateBuyer(int buyerId, BuyerDTO buyerDTO) {
		Buyer buyer = buyerDAO.getBuyer(buyerId);
		BeanUtils.copyProperties(buyerDTO, buyer, new String[] {});
		return mapper.map(buyerDAO.updateBuyer(buyer), BuyerDTO.class);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.service.BuyerService#createBuyer(com.org.doorstep.dto
	 * .BuyerDTO)
	 */
	@Override
	@Transactional
	public void createBuyer(BuyerDTO buyerDTO) {
		Buyer buyer = new Buyer();
		BeanUtils.copyProperties(buyerDTO, buyer, new String[] { "id" });
		buyerDAO.createBuyer(buyer);

	}

}
