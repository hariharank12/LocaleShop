/**
 * 
 */
package com.org.doorstep.serviceimpl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.doorstep.dao.DealsSellerDAO;
import com.org.doorstep.daoimpl.BuyerDAOImpl;
import com.org.doorstep.dto.SellerDealDTO;
import com.org.doorstep.dto.SellerDealsDTO;
import com.org.doorstep.entity.Buyer;
import com.org.doorstep.entity.DealsSeller;
import com.org.doorstep.helper.JerseyDozerMapper;
import com.org.doorstep.service.SellerDealService;

/**
 * @author hariharank12
 *
 */
@Service
public class SellerDealServiceImpl implements SellerDealService {

	@Autowired
	private DealsSellerDAO dealsSellerDAO;

	@Autowired
	private BuyerDAOImpl buyerDAO;

	@Autowired
	private JerseyDozerMapper<DealsSeller, SellerDealDTO> mapper;

	@Autowired
	private JerseyDozerMapper<SellerDealDTO, DealsSeller> fwdMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.SellerDealService#getHotDeals()
	 */
	@Override
	public List<SellerDealDTO> getHotDeals() {
		System.out.println("hot deals ");

		return mapper
				.mapList(dealsSellerDAO.getHotDeals(), SellerDealDTO.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.org.doorstep.service.SellerDealService#getHotDeals()
	 */
	@Override
	public List<SellerDealDTO> getBuyerHotDeals(Integer buyerId) {
		System.out.println("hot buyer deals ");
		Buyer buyer = buyerDAO.getBuyer(buyerId);
		BigDecimal latitude = new BigDecimal(buyer.getLatitude());
		BigDecimal longitude = new BigDecimal(buyer.getLongitude());

		return mapper.mapList(
				dealsSellerDAO.getBuyerDeals(latitude, longitude),
				SellerDealDTO.class);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.service.SellerDealService#createSellerDeal(com.org.doorstep
	 * .dto.SellerDealDTO)
	 */
	@Override
	@Transactional
	public void createSellerDeals(SellerDealsDTO sellerDealDTOs) {
		for (SellerDealDTO sellerDealDTO : sellerDealDTOs.getSellerDeals()) {
			DealsSeller dealsSeller = new DealsSeller();
			BeanUtils.copyProperties(sellerDealDTO, dealsSeller, new String[] {
					"id", "sellerBranch", "product" });
			dealsSeller.getSellerBranch().setId(
					sellerDealDTO.getSellerBranch().getId());
			dealsSeller.getProduct().setId(sellerDealDTO.getProduct().getId());
			dealsSellerDAO.createDeal(dealsSeller);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.service.SellerDealService#createSellerDeal(com.org.doorstep
	 * .dto.SellerDealDTO)
	 */
	@Override
	public void createSellerDeal(SellerDealDTO sellerDealDTO) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.org.doorstep.service.SellerDealService#createSellerDeal(com.org.doorstep
	 * .dto.SellerDealDTO)
	 */
	@Override
	@Transactional
	public SellerDealDTO updateSellerDeal(SellerDealDTO sellerDealDTO) {
		DealsSeller dealsSeller = new DealsSeller();
		BeanUtils.copyProperties(sellerDealDTO, dealsSeller, new String[] {
				"sellerBranch", "product" });
		dealsSeller.getSellerBranch().setId(
				sellerDealDTO.getSellerBranch().getId());
		dealsSeller.getProduct().setId(sellerDealDTO.getProduct().getId());
		return mapper.map(dealsSellerDAO.updateDeal(dealsSeller),
				SellerDealDTO.class);

	}

}
