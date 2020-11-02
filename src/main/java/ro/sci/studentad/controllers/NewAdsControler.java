package ro.sci.studentad.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.sci.studentad.domain.adtypes.Buy;
import ro.sci.studentad.domain.adtypes.Event;
import ro.sci.studentad.domain.adtypes.Sell;
import ro.sci.studentad.service.AdService;

@Controller
public class NewAdsControler {

	@Autowired
	private AdService adService;

	@Value("${photo.upload.directory}")
	String photoUploadDirectory;

	@RequestMapping(value = "/sell", method = RequestMethod.GET)
	public String addSell(Model model, @ModelAttribute("sell") Sell sell) {

		model.addAttribute("template", "sell");

		return "index";
	}

	@RequestMapping(value = "/sell", method = RequestMethod.POST)
	public String addSell(Model model, @Valid Sell sell, BindingResult result) {

		model.addAttribute("template", "sell");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		if (!result.hasErrors()) {

			adService.saveAd(sell, username);
			model.addAttribute("template", "home");

			return "redirect:" + "/searchresults";
		}

		return "index";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String addBuy(Model model, @ModelAttribute("buy") Buy buy) {

		model.addAttribute("template", "buy");

		return "index";
	}

	@RequestMapping(value = "/buy", method = RequestMethod.POST)
	public String addBuy(Model model, @Valid Buy buy, BindingResult result) {

		model.addAttribute("template", "buy");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		if (!result.hasErrors()) {

			adService.saveAd(buy, username);
			model.addAttribute("template", "home");

			return "redirect:" + "/searchresults";
		}

		return "index";
	}

	@RequestMapping(value = "/event", method = RequestMethod.GET)
	public String addEvent(Model model, @ModelAttribute("event") Event event) {

		model.addAttribute("template", "event");

		return "index";
	}

	@RequestMapping(value = "/event", method = RequestMethod.POST)
	public String addEvent(Model model, @Valid Event event, BindingResult result) {

		model.addAttribute("template", "event");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		if (!result.hasErrors()) {

			adService.saveAd(event, username);

			return "redirect:" + "/searchresults";
		}

		return "index";
	}

}
