package ro.sci.studentad.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import ro.sci.studentad.App;
import ro.sci.studentad.domain.Gender;
import ro.sci.studentad.domain.SiteUser;
import ro.sci.studentad.service.SiteUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
public class SiteUserTest {

	@Autowired
	private SiteUserService siteUserService;

	@Test
	public void saveUserTest() {

		Calendar date = new GregorianCalendar();
		SiteUser user = new SiteUser("Calin", "mihai", "calin@yahoo.com", "sadasdas", date, Gender.MALE);
		siteUserService.saveUser(user);
		SiteUser result = siteUserService.getUserById(1L);
		Assert.assertEquals(result, user);

	}
}
