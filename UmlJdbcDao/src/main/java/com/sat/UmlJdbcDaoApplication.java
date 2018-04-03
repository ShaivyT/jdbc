package com.sat;
	
import java.util.Collection;

// importing java.sql to keep Connection based on default Interface and not on the vendor com.mysql.jdbc kind.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sat.dao.DeveloperDao;
import com.sat.dao.PageDao;
import com.sat.dao.RoleDao;
import com.sat.dao.WebsiteDao;
import com.sat.dao.WidgetDao;
import com.sat.model.Developer;
import com.sat.model.HeadingWidget;
import com.sat.model.HtmlWidget;
import com.sat.model.ImageWidget;
import com.sat.model.Page;
import com.sat.model.Website;
import com.sat.model.Widget;
import com.sat.model.YoutubeWidget;

@SpringBootApplication
public class UmlJdbcDaoApplication {
	
	private static final int OWNERROLEID = 1; 
	private static final int EDITORROLEID = 2; 
	private static final int ADMINROLEID = 3; 
	private static final int REVIEWERROLEID = 4; 
	private static final int WRITERROLEID = 5; 
	
	private static DeveloperDao developerDao = DeveloperDao.getInstance();
	private static WebsiteDao websiteDao = WebsiteDao.getInstance();
	private static RoleDao roleDao = RoleDao.getInstance();
	private static PageDao pdao = PageDao.getInstance();
	private static WidgetDao widgetDao = WidgetDao.getInstance();
	
	
	public static void main(String[] args) {
		SpringApplication.run(UmlJdbcDaoApplication.class, args);
		
	    developerDao.createDeveloper(new Developer("Alice","Wonder","alice","alice","alice@wonder.com","4321rewq"));
		developerDao.createDeveloper(new Developer("Bob","Marley","bob","bob","bob@marley.com","5432trew"));
		developerDao.createDeveloper(new Developer("Charles","Garcia","charlie","charlie","charliechuch@garcia.com","6543ytre"));
		developerDao.createDeveloper(new Developer("Dan", "Martin", "dan", "dan", "dan@martin.com","7654fda"));
		developerDao.createDeveloper(new Developer("Ed","Karaz", "ed", "ed", "ed@kar.com","5678dfgh"));

		System.out.println("List of inserted developers:");
		developerDao.findAllDevelopers();
		
		int aliceId = developerDao.findDeveloperByUsername("alice").getId();
		int bobId = developerDao.findDeveloperByUsername("bob").getId();
		int charlieId = developerDao.findDeveloperByUsername("charlie").getId();
		
		websiteDao.createWebsiteForDeveloper(aliceId, new Website("Facebook","an online social media and social networking service","1234234"));	
		websiteDao.createWebsiteForDeveloper(bobId, new Website("Twitter","an online news and social networking service","4321543"));	
		websiteDao.createWebsiteForDeveloper(charlieId, new Website("Wikipedia","a free online encyclopedia","3456654"));	
		websiteDao.createWebsiteForDeveloper(aliceId, new Website("CNN","an American basic cable and satellite television news channel","6543345"));	
		websiteDao.createWebsiteForDeveloper(bobId, new Website("CNET","an American media website that publishes reviews, news, articles, blogs, "
				+ "podcasts and videos on technology and consumer electronics","5433455"));	
		websiteDao.createWebsiteForDeveloper(charlieId, new Website("Gizmodo","a design, technology, science and science fiction website that "
				+ "also writes articles on politics","4322345"));
		
		System.out.println("*************\nList of inserted websites:");
		websiteDao.findAllWebsites();
		
		int facebookId = websiteDao.findWebsiteByName("Facebook").getId();
		int twitterId = websiteDao.findWebsiteByName("Twitter").getId();
		int wikipediaId = websiteDao.findWebsiteByName("Wikipedia").getId();
		int cnnId = websiteDao.findWebsiteByName("CNN").getId();
		int cnetId = websiteDao.findWebsiteByName("CNET").getId();
		int gizmodoId = websiteDao.findWebsiteByName("Gizmodo").getId();
		
		roleDao.assignWebsiteRole(aliceId, facebookId, OWNERROLEID);
		roleDao.assignWebsiteRole(bobId, twitterId, OWNERROLEID);
		roleDao.assignWebsiteRole(charlieId, wikipediaId, OWNERROLEID);
		roleDao.assignWebsiteRole(aliceId, cnnId, OWNERROLEID);
		roleDao.assignWebsiteRole(bobId, cnetId, OWNERROLEID);
		roleDao.assignWebsiteRole(charlieId, gizmodoId, OWNERROLEID);	
		
		roleDao.assignWebsiteRole(bobId, facebookId, EDITORROLEID);
		roleDao.assignWebsiteRole(charlieId, twitterId, EDITORROLEID);
		roleDao.assignWebsiteRole(aliceId, wikipediaId, EDITORROLEID);
		roleDao.assignWebsiteRole(bobId, cnnId, EDITORROLEID);
		roleDao.assignWebsiteRole(charlieId, cnetId, EDITORROLEID);
		roleDao.assignWebsiteRole(aliceId, gizmodoId, EDITORROLEID);	
		
		roleDao.assignWebsiteRole(charlieId, facebookId, ADMINROLEID);
		roleDao.assignWebsiteRole(aliceId, twitterId, ADMINROLEID);
		roleDao.assignWebsiteRole(bobId, ADMINROLEID, ADMINROLEID);
		roleDao.assignWebsiteRole(charlieId, cnnId, ADMINROLEID);
		roleDao.assignWebsiteRole(aliceId, cnetId, ADMINROLEID);
		roleDao.assignWebsiteRole(bobId, gizmodoId, ADMINROLEID);	
		
		pdao.createPageForWebsite(cnetId,new Page("Home","Landing page","123434"));	
		pdao.createPageForWebsite(gizmodoId,new Page("About","Website description","234545"));		
		pdao.createPageForWebsite(wikipediaId,new Page("Contact","Addresses, phones, and contact info","345656"));		
		pdao.createPageForWebsite(cnnId,new Page("Preferences","Where users can configure their preferences","456776"));		
		pdao.createPageForWebsite(cnetId,new Page("Profile","Users can configure their personal information","567878"));		
		
		System.out.println("All pages" + pdao.findAllPages());
		
		int cnetHomeId = pdao.findPageByTitle("Home", cnetId).getId();
		int gizmodoAboutId = pdao.findPageByTitle("About", gizmodoId).getId();
		int wikiContactId = pdao.findPageByTitle("Contact", wikipediaId).getId();
		int cnnPrefId = pdao.findPageByTitle("Preferences", cnnId).getId();
		int cnetProfileId = pdao.findPageByTitle("Profile", cnetId).getId();
		
		roleDao.assignPageRole(aliceId, cnetHomeId, EDITORROLEID);
		roleDao.assignPageRole(bobId, cnetHomeId, REVIEWERROLEID);
		roleDao.assignPageRole(charlieId, cnetHomeId, WRITERROLEID);
		
		roleDao.assignPageRole(bobId, gizmodoAboutId, EDITORROLEID);
		roleDao.assignPageRole(charlieId, gizmodoAboutId, REVIEWERROLEID);
		roleDao.assignPageRole(aliceId, gizmodoAboutId, WRITERROLEID);
		
		roleDao.assignPageRole(charlieId, wikiContactId, EDITORROLEID);
		roleDao.assignPageRole(aliceId, wikiContactId, REVIEWERROLEID);
		roleDao.assignPageRole(bobId, wikiContactId, WRITERROLEID);
		
		roleDao.assignPageRole(aliceId, cnnPrefId, EDITORROLEID);
		roleDao.assignPageRole(bobId, cnnPrefId, REVIEWERROLEID);
		roleDao.assignPageRole(charlieId, cnnPrefId, WRITERROLEID);
		
		roleDao.assignPageRole(bobId, cnetProfileId, EDITORROLEID);
		roleDao.assignPageRole(charlieId, cnetProfileId, REVIEWERROLEID);
		roleDao.assignPageRole(aliceId, cnetProfileId,WRITERROLEID);	
		
		widgetDao.createWidgetForPage(cnetHomeId, new HeadingWidget("head123","heading","Welcome",0,2));		
		widgetDao.createWidgetForPage(gizmodoAboutId, new HtmlWidget("post234","html","<p>Lorem</p>",0));		
		widgetDao.createWidgetForPage(wikiContactId, new HeadingWidget("head345","heading","Hi",1,2));		
		widgetDao.createWidgetForPage(wikiContactId, new HtmlWidget("intro456","html","<h1>Hi</h1>",2));		
		widgetDao.createWidgetForPage(wikiContactId, new ImageWidget("image345","image",50,100,3,"/img/567.png"));		
		widgetDao.createWidgetForPage(cnnPrefId, new YoutubeWidget("video456","youtube",400,300,0,"https://youtu.be/h67VX51QXiQ"));
		
		System.out.println("All widgets " + widgetDao.findAllWidgets());
		widgetDao.updateWidget(widgetDao.findWidgetByName("head345").getId(),new Widget("head345",2));
		
		Collection<Page> pages = pdao.findPagesForWebsite(cnetId);
		for(Page p: pages) {
			pdao.updatePage(p.getId(), new Page("CNET - "+ p.getTitle()));
		}
		
		websiteDao.deleteWebsite(cnetId);	
	}
}
