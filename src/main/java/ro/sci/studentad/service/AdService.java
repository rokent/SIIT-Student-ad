package ro.sci.studentad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ro.sci.studentad.dao.AdDAO;
import ro.sci.studentad.dao.SiteUserDAO;
import ro.sci.studentad.domain.Ad;
import ro.sci.studentad.domain.SiteUser;

@Service
public class AdService {

	private final static int PAGESIZE = 10;

	@Autowired
	private AdDAO adDAO;

	@Autowired
	private SiteUserDAO siteUserDAO;

	public void saveAd(Ad ad, String userName) {
		ad.setOwner(siteUserDAO.findByEmail(userName));
		adDAO.save(ad);
	}

	public void editAd(Ad ad) {
		adDAO.save(ad);
	}

	public Ad getAdById(Long id) {
		return adDAO.findOne(id);
	}

	public boolean deleteAd(Long id) {

		Ad ad = adDAO.findById(id);
		if (ad != null) {
			adDAO.delete(ad);
			return true;

		}

		return false;

	}

	public Ad getLatest() {
		return adDAO.findFirstByOrderByAddDateDesc();
	}

	public Page<Ad> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber, PAGESIZE, Sort.Direction.DESC, "addDate");

		return adDAO.findAll(request);
	}

	public Page<Ad> getUserAds(int pageNumber, String siteUserName) {

		SiteUser owner = siteUserDAO.findByEmail(siteUserName);

		PageRequest request = new PageRequest(pageNumber, PAGESIZE, Sort.Direction.DESC, "addDate");
		return adDAO.findByOwnerAndExpirationDateBefore(owner, request);

	}

	public Long totalNumberOfAds() {
		return adDAO.count();
	}
}
