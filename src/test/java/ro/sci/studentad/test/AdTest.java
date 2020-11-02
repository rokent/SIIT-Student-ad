//package ro.sci.studentad.test;
//
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//import javax.transaction.Transactional;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;
//
//import ro.sci.studentad.App;
//import ro.sci.studentad.domain.Ad;
//import ro.sci.studentad.domain.adtypes.Event;
//import ro.sci.studentad.service.AdService;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(App.class)
//@WebAppConfiguration
//@Transactional
//public class AdTest {
//
//	@Autowired
//	private AdService adService;
//
//	@Test
//	public void saveAdTest() {
//
//		Event ad = new Event();
//		Calendar test = new GregorianCalendar();
//		ad.setEventDate(test);
//		adService.saveAd(ad);
//		Ad result = adService.getAdById(1L);
//				
//		Assert.assertEquals(result, ad);
//		Assert.assertTrue(adService.deleteAd(1L));
//
//	}
//	
//
//	
//}
