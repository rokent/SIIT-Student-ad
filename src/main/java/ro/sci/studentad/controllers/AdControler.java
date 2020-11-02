package ro.sci.studentad.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ro.sci.studentad.domain.Ad;
import ro.sci.studentad.domain.adtypes.Sell;
import ro.sci.studentad.service.AdService;

@Controller
public class AdControler {

	@Autowired
	private AdService adService;

	@RequestMapping(value = "/searchresults", method = RequestMethod.GET)
	public String viewAds(Model model, @RequestParam(name = "page", defaultValue = "0") int pageNumber) {

		Page<Ad> page = adService.getPage(pageNumber);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		model.addAttribute("loggedUser", username);

		model.addAttribute("page", page);

		model.addAttribute("template", "searchresults");

		return "index";
	}

	@RequestMapping(value = "/editad", method = RequestMethod.GET)
	public String editAd(Model model, @RequestParam(name = "id") Long id, @ModelAttribute("sell") Sell sell) {

		// Ad ad = adService.getAdById(id);
		//
		// model.addAttribute("ad", ad);
		//
		// String adType = ad.getAdType();

		model.addAttribute("template", "sell");

		return "index";
	}

	@RequestMapping(value = "/readad", method = RequestMethod.GET)
	public String readAd(Model model, @RequestParam(name = "id") Long id) {

		 Ad ad = adService.getAdById(id);
		
		 model.addAttribute("ad", ad);
		
		model.addAttribute("template", "readad");

		return "index";
	}
	
	@RequestMapping(value = "/editad", method = RequestMethod.POST)
	ModelAndView editAd(ModelAndView modelAndView, @Valid Ad ad, BindingResult result) {

		modelAndView.setViewName("app.editAd");

		if (!result.hasErrors()) {
			adService.editAd(ad);
			modelAndView.setViewName("redirect:/viewads");
		}

		return modelAndView;
	}

	@RequestMapping(value = "/deletead", method = RequestMethod.GET)
	public String deleteAd(Model model, @RequestParam(name = "id") Long id) {

		adService.deleteAd(id);

		model.addAttribute("template", "home");

		return "index";

	}

	@RequestMapping(value = "/myads")
	public String showMyAds(Model model, @RequestParam(name = "page", defaultValue = "0") int pageNumber) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		Page<Ad> page = adService.getUserAds(pageNumber, username);

		model.addAttribute("loggedUser", username);

		model.addAttribute("page", page);

		model.addAttribute("template", "searchresults");

		return "index";

	}

}