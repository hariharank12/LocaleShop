/**
 * 
 */
package com.org.doorstep.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.doorstep.dao.SellerDAO;
import com.org.doorstep.dto.SellerBranchesDTO;
import com.org.doorstep.dto.SellerDTO;
import com.org.doorstep.entity.Point;
import com.org.doorstep.entity.Seller;
import com.org.doorstep.entity.SellerBranch;
import com.org.doorstep.helper.JerseyDozerMapper;
import com.org.doorstep.service.SellerService;

/**
 * @author hariharank12
 *
 */
@Service
public class SellerServiceImpl implements SellerService {

	@Autowired
	private SellerDAO sellerDAO;

	@Autowired
	private JerseyDozerMapper<Seller, SellerDTO> mapper;

	@Autowired
	private JerseyDozerMapper<SellerDTO, Seller> fwdMapper;

	@PostConstruct
	public void init() {
		System.out.println("Seller Service init method called");
	}

	@Override
	public SellerDTO getSeller(int id) {
		return mapper.map(sellerDAO.getSeller(id), SellerDTO.class);
	}

	@Override
	@Transactional
	public void createSeller(SellerDTO sellerDTO) {
		Seller seller = new Seller();
		BeanUtils.copyProperties(sellerDTO, seller, new String[] { "id",
				"sellerBranches" });
		seller.setSellerBranches(new ArrayList<SellerBranch>());
		for (SellerBranchesDTO sellerBranchDTO : sellerDTO.getSellerBranches()) {

			SellerBranch sellerBranch = new SellerBranch();
			Point point = new Point();
			BeanUtils.copyProperties(sellerBranchDTO, sellerBranch,
					new String[] { "id", "seller" });
			BeanUtils.copyProperties(sellerBranchDTO, point);
			sellerBranch.setPoint(point);
			seller.addSellerBranch(sellerBranch);
			// sellerDAO.createSellerBranch(sellerBranch);
		}
		sellerDAO.createSeller(seller);

	}

	@Override
	public List<SellerDTO> getAllSellers() {
		System.out.println("sellers branch points "
				+ sellerDAO.getSellers().get(0).getSellerBranches().get(0)
						.getPoint());

		return mapper.mapList(sellerDAO.getSellers(), SellerDTO.class);
	}

	@Override
	@Transactional
	public SellerDTO updateSeller(int id, SellerDTO sellerDTO) {
		Seller seller = sellerDAO.getSeller(id);
		BeanUtils.copyProperties(sellerDTO, seller, new String[] { "id",
				"sellerBranches" });
		for (SellerBranchesDTO sellerBranchDTO : sellerDTO.getSellerBranches()) {
			SellerBranch sellerBranch;
			if (null == sellerBranchDTO.getId()) {
				sellerBranch = new SellerBranch();
				Point point = new Point();
				BeanUtils.copyProperties(sellerBranchDTO, sellerBranch,
						new String[] { "id", "seller" });
				BeanUtils.copyProperties(sellerBranchDTO, point);
				sellerBranch.setPoint(point);
				seller.addSellerBranch(sellerBranch);
				sellerDAO.createSellerBranch(sellerBranch);
			} else {
				sellerBranch = seller
						.getSellerBranchBySequenceId(sellerBranchDTO.getId());
				BeanUtils.copyProperties(sellerBranchDTO, sellerBranch,
						new String[] { "id", "seller" });

			}
		}
		return mapper.map(sellerDAO.updateSeller(seller), SellerDTO.class);
	}
}
