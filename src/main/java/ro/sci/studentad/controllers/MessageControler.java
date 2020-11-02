package ro.sci.studentad.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ro.sci.studentad.domain.Ad;
import ro.sci.studentad.domain.Message;
import ro.sci.studentad.service.MessageService;

@Controller
public class MessageControler {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/newmessage", method = RequestMethod.GET)
	public String newMessage(Model model, @RequestParam(name = "id") Long id) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String senderUserName = auth.getName();

		Message message = messageService.newMessage(senderUserName, id);

		model.addAttribute("template", "newmessage");

		model.addAttribute("message", message);

		return "index";
	}

	@RequestMapping(value = "/newmessage", method = RequestMethod.POST)
	public String addAd(Model model, @Valid Message message, BindingResult result) {

		model.addAttribute("template", "newmessage");

		if (!result.hasErrors()) {
			messageService.sendMessage(message);
			model.addAttribute("template", "home");
		}

		return "index";
	}

	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public String viewInbox(Model model, @RequestParam(name = "page", defaultValue = "0") int pageNumber) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		Page<Message> page = messageService.getUserInbox(pageNumber, username);

		model.addAttribute("page", page);

		model.addAttribute("template", "messagebox");

		return "index";
	}

	@RequestMapping(value = "/outbox", method = RequestMethod.GET)
	public String viewOutBox(Model model, @RequestParam(name = "page", defaultValue = "0") int pageNumber) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		Page<Message> page = messageService.getUserOutbox(pageNumber, username);

		model.addAttribute("page", page);

		model.addAttribute("template", "Outbox");

		return "index";
	}

	@RequestMapping(value = "/deletemessage", method = RequestMethod.GET)
	public String deleteMessage(Model model, @RequestParam(name = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int pageNumber) {

		messageService.deleteMessageInbox(id);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		Page<Message> page = messageService.getUserInbox(pageNumber, username);

		model.addAttribute("page", page);

		return "redirect:" + "/inbox";
	}

	@RequestMapping(value = "/deleteoutboxmessage", method = RequestMethod.GET)
	public String deleteOutboxMessage(Model model, @RequestParam(name = "id") Long id,
			@RequestParam(name = "page", defaultValue = "0") int pageNumber) {

		messageService.deleteMessageOutbox(id);

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();

		Page<Message> page = messageService.getUserInbox(pageNumber, username);

		model.addAttribute("page", page);

		return "redirect:" + "/outbox";
	}

	@RequestMapping(value = "/read-mail", method = RequestMethod.GET)
	public String readMail(Model model, @RequestParam(name = "id") Long id) {

		 Message message = messageService.getMessageById(id);
		
		 model.addAttribute("message", message);
		
		model.addAttribute("template", "read-mail");

		return "index";
	}
	
}
