package ro.sci.studentad.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.sci.studentad.domain.Gender;
import ro.sci.studentad.domain.SiteUser;
import ro.sci.studentad.service.AdService;
import ro.sci.studentad.service.SiteUserService;

@Controller
public class NoAuthReqController {

	@Autowired
	private SiteUserService siteUserService;
	@Autowired
	private AdService adService;

	@RequestMapping("/")
	public String getLogin(Model model) {

		Long numberOfAds = adService.totalNumberOfAds();
		Long numberOfRegistredUsers = siteUserService.numberOfRegistredUsers();

		model.addAttribute("numberOfAds", numberOfAds);
		model.addAttribute("numberOfRegistredUsers", numberOfRegistredUsers);

		model.addAttribute("template", "home");
		return "index";
	}

	@RequestMapping("/about")
	public String getAbout(Model model) {

		model.addAttribute("template", "about");

		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String addSiteUser(Model model) {

		model.addAttribute("template", "signup");

		SiteUser siteUser = new SiteUser();

		model.addAttribute("siteUser", siteUser);
		Gender[] genders = Gender.values();
		model.addAttribute("genders", genders);

		return "index";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String addSiteUser(Model model, @Valid SiteUser siteUser, BindingResult result) {

		model.addAttribute("template", "signup");

		if (!result.hasErrors()) {
			if (siteUserService.saveUser(siteUser) == true) {
				Long numberOfAds = adService.totalNumberOfAds();
				Long numberOfRegistredUsers = siteUserService.numberOfRegistredUsers();

				model.addAttribute("numberOfAds", numberOfAds);
				model.addAttribute("numberOfRegistredUsers", numberOfRegistredUsers);
				model.addAttribute("template", "usercreatedsuccess");

			} else {
				model.addAttribute("template", "userexists");
			}
		}
		return "index";
	}

	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("template", "login");

		return "index";
	}
	
	@RequestMapping("/loginerror")
	public String loginError(Model model) {
		model.addAttribute("template", "loginerror");

		return "index";
	}
}
