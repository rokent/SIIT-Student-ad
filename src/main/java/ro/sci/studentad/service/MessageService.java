package ro.sci.studentad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ro.sci.studentad.dao.AdDAO;
import ro.sci.studentad.dao.MessageDAO;
import ro.sci.studentad.dao.SiteUserDAO;
import ro.sci.studentad.domain.Ad;
import ro.sci.studentad.domain.Message;
import ro.sci.studentad.domain.SiteUser;

@Service
public class MessageService {

	private final static int PAGESIZE = 10;

	@Autowired
	private MessageDAO messageDAO;
	@Autowired
	SiteUserDAO siteUserDAO;

	@Autowired
	AdDAO adDAO;

	public Page<Message> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.DESC, "addDate");

		return messageDAO.findAll(request);
	}

	public Message newMessage(String senderUserName, Long id) {

		Message newMessage = new Message();
		newMessage.setReciver(adDAO.findById(id).getOwner());
		newMessage.setSender(siteUserDAO.findByEmail(senderUserName));
		return newMessage;
	}

	public void sendMessage(Message message) {
		message.setReciverisibility(true);
		message.setSenderVisibility(true);
		messageDAO.save(message);

	}

	public Page<Message> getUserInbox(int pageNumber, String siteUserName) {

		SiteUser owner = siteUserDAO.findByEmail(siteUserName);

		PageRequest request = new PageRequest(pageNumber, PAGESIZE, Sort.Direction.DESC, "messageDate");

		return messageDAO.findByReciverAndReciverisibilityTrue(owner, request);

	}

	public Page<Message> getUserOutbox(int pageNumber, String siteUserName) {

		SiteUser owner = siteUserDAO.findByEmail(siteUserName);

		PageRequest request = new PageRequest(pageNumber, PAGESIZE, Sort.Direction.DESC, "messageDate");

		return messageDAO.findBySenderAndSenderVisibilityTrue(owner, request);

	}

	public boolean deleteMessageInbox(Long id) {

		Message message = messageDAO.findById(id);
		if (message != null) {
			message.setReciverisibility(false);
			messageDAO.save(message);
			return true;

		}

		return false;

	}

	public boolean deleteMessageOutbox(Long id) {

		Message message = messageDAO.findById(id);
		if (message != null) {
			message.setSenderVisibility(false);
			messageDAO.save(message);
			return true;

		}

		return false;

	}

	public Message getMessageById(Long id) {
		return messageDAO.findOne(id);
	}
	
}
