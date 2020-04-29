package Matrimony.matrimonyart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class searchPOM extends BaseTest{
	
	public searchPOM(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='idEmail']")
    private WebElement MatriID;
	public WebElement getMatriID() {
		return MatriID;
	}
	
	
	
	@FindBy(id="passwordClear1")
	private WebElement PasswordClear;
	public WebElement getPasswordClear() {
		return PasswordClear;
	}
	
	
	@FindBy(id="password1")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}

	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement Login_btn;
	public WebElement getLogin_btn() {
		return Login_btn;
	}
	
	@FindBy(xpath="(//select[@class='search-input'])[5]")
	private WebElement reli;
	public WebElement getreli() {
		return reli;
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Skip to My Matrimony >>')]")
	private WebElement InterMediate_page;
	public WebElement getInterMediate_page() {
		return InterMediate_page;
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Skip to Daily Matches >>')]")
	private WebElement InterMediate_page1;	
	public WebElement getInterMediate_page1() {
		return InterMediate_page1;
	}

	@FindBy(xpath="//*[@id=\"topnav-login-menu\"]/div[3]/div[2]/div[1]/a")
	private WebElement Menu_btn;
	public WebElement getMenu_btn() {
		return Menu_btn;
	}
	
	
	@FindBy(xpath="//*[@id=\"topnav-login-menu\"]/div[3]/div[2]/div[1]/a/img")
	private WebElement Menu_btn1;
	public WebElement getMenu_btn1() {
		return Menu_btn1;
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit Profile')]")
	private WebElement Edit_Profile;
	public WebElement getEdit_Profile() {
		return Edit_Profile;
	}
	
	
	@FindBy(xpath="//a[contains(text(),'Edit Partner Preference')]")
	private WebElement Edit_Partner_Preference;
	public WebElement getEdit_Partner_Preference() {
		return Edit_Partner_Preference;
	}
	
	@FindBy(xpath="//a[@class='editIcon font12 clr6']")
	private WebElement PP_Edit_btn;	
	public WebElement getPP_Edit_btn() {
		return PP_Edit_btn;
	}
	
	@FindBy(id="ageFrom")
	private WebElement ageFrom;
	public WebElement getageFrom() {
		return ageFrom;
	}
	
	@FindBy(id="ageTo")
	private WebElement ageTo;
	public WebElement getageTo() {
		return ageTo;
	}
	
	
	@FindBy(id="maritalStatus1")
	private WebElement unmarried;
	public WebElement getunmarried() {
		return unmarried;
	}
	

	@FindBy(id="maritalStatus2")
	private WebElement widow;
	public WebElement getwidow() {
		return widow;
	}
	
	@FindBy(id="maritalStatus3")
	private WebElement divorced;
	public WebElement getdivorced() {
		return divorced;
	}
	
	@FindBy(id="maritalStatus0")
	private WebElement any;
	public WebElement getany() {
		return any;
	}
	
	@FindBy(id="maritalStatus4")
	private WebElement seprated;
	public WebElement getseprated() {
		return seprated;
	}
	
	@FindBy(id="FamilyType2")
	private WebElement nucfam;
	public WebElement getnucfam() {
		return nucfam;
	}
	
	@FindBy(id="photoOpt")
	private WebElement photoOpt;
	public WebElement getphotoOpt() {
		return photoOpt;
	}
	
	
	@FindBy(id="horoscopeOpt")
	private WebElement horoscopeOpt;
	public WebElement gethoroscopeOpt() {
		return horoscopeOpt;
	}
	
	@FindBy(id="alreadyContOpt")
	private WebElement alreadyContOpt;
	public WebElement getalreadyContOpt() {
		return alreadyContOpt;
	}
	
	@FindBy(id="alreadyViewedOpt")
	private WebElement alreadyViewedOpt;
	public WebElement getalreadyViewedOpt() {
		return alreadyViewedOpt;
	}
	
	@FindBy(id="shortlistOpt")
	private WebElement shortlistOpt;
	public WebElement getshortlistOpt() {
		return shortlistOpt;
	}
	
	@FindBy(id="ignoredOpt")
	private WebElement ignoredOpt;
	public WebElement getignoredOpt() {
		return ignoredOpt;
	}
	
	@FindBy(id="igOpt")
	private WebElement igOpt;
	public WebElement getigOpt() {
		return igOpt;
	}
	
	
	@FindBy(id="physicalStatus2")
	private WebElement  physicaldsntm;
	public WebElement getphysicaldsntm() {
		return physicaldsntm;
	}
	
	@FindBy(id="physicalStatus0")
	private WebElement  physcialnorma;
	public WebElement getphyscialnorma() {
		return physcialnorma;
	}
	
	@FindBy(id="physicalStatus1")
	private WebElement  physicalphychangleed;
	public WebElement getphysicalphychangleed() {
		return physicalphychangleed;
	}
	
	@FindBy(id="manglik0")
	private WebElement  doshamfield;
	public WebElement getdoshamfield() {
		return doshamfield;
	}
	
	@FindBy(id="manglik1")
	private WebElement  doshamyes;
	public WebElement getdoshamyes() {
		return doshamyes;
	}
	
	@FindBy(id="manglik2")
	private WebElement  doshamno;
	public WebElement getdoshamno() {
		return doshamno;
	}
	
	@FindBy(id="residentStatus")
	private WebElement  rsany;
	public WebElement getrsany() {
		return rsany;
	}
	
	@FindBy(id="residentStatus1")
	private WebElement  rscitizen;
	public WebElement getrscitizen() {
		return rscitizen;
	}
	
	@FindBy(id="residentStatus2")
	private WebElement  rspr;
	public WebElement getrspr() {
		return rspr;
	}
	
	@FindBy(id="residentStatus3")
	private WebElement  rswp;
	public WebElement getrswp() {
		return rswp;
	}
	
	@FindBy(id="residentStatus4")
	private WebElement  rssv;
	public WebElement getrssv() {
		return rssv;
	}
	
	@FindBy(id="residentStatus5")
	private WebElement  rstv;
	public WebElement getrstv() {
		return rstv;
	}
	
	@FindBy(id="annualIncome")
	private WebElement  anualincome;
	public WebElement getanualincome() {
		return anualincome;
	}
	
	
	@FindBy(id="eating1")
	private WebElement eatingHabits1;
	public WebElement geteatingHabits1() {
		return eatingHabits1;
	}
	
	@FindBy(id="eating2")
	private WebElement eatingHabits2;
	public WebElement geteatingHabits2() {
		return eatingHabits2;
	}
	
	
	@FindBy(id="eating3")
	private WebElement eatingHabits3;
	public WebElement geteatingHabits3() {
		return eatingHabits3;
	}
	
	@FindBy(id="eating4")
	private WebElement eatingHabits4;
	public WebElement geteatingHabits4() {
		return eatingHabits4;
	}
	
	@FindBy(id="eating")
	private WebElement eatingHabits0;
	public WebElement geteatingHabits0() {
		return eatingHabits0;
	}
	
	
	@FindBy(id="drinkingHabits1")
	private WebElement drinking1;
	public WebElement getdrinking1() {
		return drinking1;
	}
	
	@FindBy(id="drinking2")
	private WebElement drinking2;
	public WebElement getdrinking2() {
		return drinking2;
	}
	
	@FindBy(id="drinking3")
	private WebElement drinking3;
	public WebElement getdrinking3() {
		return drinking3;
	}
	@FindBy(id="drinking")
	private WebElement drinking0;
	public WebElement getdrinking0() {
		return drinking0;
	}
	
	@FindBy(id="smoking1")
	private WebElement smoking1;
	public WebElement getsmoking1() {
		return smoking1;
	}
	
	@FindBy(id="smoking2")
	private WebElement smoking2;
	public WebElement getsmoking2() {
		return smoking2;
	}
	@FindBy(id="smoking3")
	private WebElement smoking3;
	public WebElement getsmoking3() {
		return smoking3;
	}
	@FindBy(id="smoking0")
	private WebElement smoking0;
	public WebElement getsmoking0() {
		return smoking0;
	}
	
	@FindBy(id="haveChildren1")
	private WebElement haveChildren1;
	public WebElement gethaveChildren1() {
		return haveChildren1;
	}
	
	@FindBy(id="haveChildren2")
	private WebElement haveChildren2;
	public WebElement gethaveChildren2() {
		return haveChildren2;
	}
	
	@FindBy(id="haveChildren3")
	private WebElement haveChildren3;
	public WebElement gethaveChildren3() {
		return haveChildren3;
	}
	
	@FindBy(id="haveChildren4")
	private WebElement haveChildren4;
	public WebElement gethaveChildren4() {
		return haveChildren4;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
