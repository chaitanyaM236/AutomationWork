package com.easytox.automation.steps;

import com.easytox.automation.driver.DriverBase;
import com.easytox.automation.utils.WebElementHelper;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AddingPatientsSteps {

    private static final String Patient_LOGIN = "Angelia";
    private static final String CREATE_ORDER = "Create Order";
    private static final String Patient_PASSWORD = "Welcome@123";
    private static final String USERNAME = "j_username";
    private static final String PASSWORD = "j_password";


    private WebDriver chromedriver;
    private WebElementHelper webElementHelper;

    public AddingPatientsSteps() {
        DriverBase.instantiateDriverObject();
        this.webElementHelper = new WebElementHelper();
        chromedriver = DriverBase.getDriver();

    }

    @Given("^Patient should be login to the Application$")
    public void Patient_should_be_login_to_the_Application() throws Throwable {
        chromedriver.navigate().to("http://bmtechsol.com:8080/easytox/");

        WebElement id = chromedriver.findElement(By.name(USERNAME));
        id.clear();
        id.sendKeys(Patient_LOGIN);

        WebElement pwd = chromedriver.findElement(By.name(PASSWORD));
        pwd.clear();

        pwd.sendKeys(Patient_PASSWORD);

        chromedriver.findElement(By.xpath("//*[@id=\"loginform\"]/div[3]/div/button")).click();

    }

    @Then("^Order list page should be displayed$")
    public void order_List_Page_Should_be_displayed() throws Throwable {
        String progressurl = chromedriver.getCurrentUrl();
        Assert.assertEquals(progressurl, "http://bmtechsol.com:8080/easytox/orderFrom/list");
    }


    @When("^Click on Create Order from the left menu$")
    public void click_on_create_order_from_left_menu() throws Throwable {
        Thread.sleep(2000);
        chromedriver.findElement(By.linkText(CREATE_ORDER)).click();
    }

    @Then("^Create Order page should be displayed$")
    public void create_order_page_should_be_dispalyed() throws Throwable {
        String progressurl = chromedriver.getCurrentUrl();
        Assert.assertEquals(progressurl, "http://bmtechsol.com:8080/easytox/orderFrom/create");
    }

    @When("^Click on '\\+'; icon next to patient$")
    public void click_on_plus_icon_next_to_patient() throws Throwable {
        Thread.sleep(2000);

        chromedriver.findElement(By.xpath("//*[@id=\"add\"]")).click();
    }

    @Then("^Add patient page should be displayed$")
    public void Add_patient_page_should_be_displayed() throws Throwable {
        String progressurl = "http://bmtechsol.com:8080/easytox/orderFrom/create";
        String progressurlFromchromedriver = chromedriver.getCurrentUrl();

        Assert.assertEquals(progressurl, progressurlFromchromedriver);
    }


    @When("^Enter Patient (.*),(.*) and Enter the required information and click submit$")
    public void Enter_Patient_Name_and_Enter_the_requried_information_and_click_submit(String name, String midName) throws Throwable {
        Thread.sleep(3000);
        WebElement firstName = chromedriver.findElement(By.id("patientFirstName"));
        firstName.clear();
        firstName.sendKeys(name.trim());

        WebElement middleName = chromedriver.findElement(By.id("patientMiddleInitial"));
        middleName.clear();
        middleName.sendKeys(midName.trim());

        WebElement lastName = chromedriver.findElement(By.id("patientLastName"));
        lastName.clear();
        lastName.sendKeys(PatientInfo.LAST_NAME);


        new Select(chromedriver.findElement(By.id("gender"))).selectByVisibleText(PatientInfo.GENDER);


        WebElement DateBirth = chromedriver.findElement(By.id("dateOfBirth1"));
        DateBirth.clear();
        DateBirth.sendKeys(PatientInfo.DATE_OF_BIRTH);

        WebElement s_s_n = chromedriver.findElement(By.name("patientInstance.socialSecurityNumber"));
        s_s_n.clear();
        s_s_n.sendKeys(PatientInfo.SSN);

        WebElement p_Address1 = chromedriver.findElement(By.id("patientAddress1"));
        p_Address1.clear();
        p_Address1.sendKeys(PatientInfo.ADDRESS1);

        WebElement p_Address2 = chromedriver.findElement(By.id("patientAddress2"));
        p_Address2.clear();
        p_Address2.sendKeys(PatientInfo.ADDRESS2);

        WebElement p_zip = chromedriver.findElement(By.id("patientZip"));
        p_zip.clear();
        p_zip.sendKeys(PatientInfo.ZIP_CODE);

        WebElement p_email = chromedriver.findElement(By.id("patients_email"));
        p_email.clear();
        p_email.sendKeys(PatientInfo.EMAIL);

        WebElement p_Number = chromedriver.findElement(By.id("phoneNumber"));
        p_Number.clear();
        p_Number.sendKeys(PatientInfo.HOME_PHONE);


        WebElement m_Number = chromedriver.findElement(By.name("patientInstance.otherPhone"));
        m_Number.clear();
        m_Number.sendKeys(PatientInfo.MOBILE_PHONE);

        WebElement empl_status = chromedriver.findElement(By.name("patientInstance.patients_employment_status"));
        empl_status.clear();
        empl_status.sendKeys(PatientInfo.EMPLOYMENT);

        WebElement p_medReocrd = chromedriver.findElement(By.name("patientInstance.medRecNo"));
        p_medReocrd.clear();
        p_medReocrd.sendKeys(PatientInfo.MEDICAL_RECORD);


        WebElement altid2 = chromedriver.findElement(By.name("patientInstance.patients_alternative_id2"));
        altid2.clear();
        altid2.sendKeys(PatientInfo.ALTERNATIVE_ID);

        WebElement em_name = chromedriver.findElement(By.name("patientInstance.patients_emergency_contact_name"));
        em_name.clear();
        em_name.sendKeys(PatientInfo.EmergencyContact.CONTACT_NAME);


        WebElement em_number = chromedriver.findElement(By.name("patientInstance.patients_emergency_contact_number"));
        em_number.clear();
        em_number.sendKeys(PatientInfo.EmergencyContact.PHONE_NUMBER);


        WebElement emp_relation = chromedriver.findElement(By.name("patientInstance.patients_emergency_contact_relation"));
        emp_relation.clear();
        emp_relation.sendKeys(PatientInfo.EmergencyContact.RELATION);

        new Select(chromedriver.findElement(By.id("patientInstance.labclient"))).selectByVisibleText(PatientInfo.LAB_CLIENT);

        /* guaurantor info */

        chromedriver.findElement(By.xpath("//*[@id=\"tabs\"]/li[2]/a")).click();

        WebElement firstName1 = chromedriver.findElement(By.id("guarantorFirstName"));
        firstName1.clear();
        firstName1.sendKeys(name.trim());



        WebElement middleinitial = chromedriver.findElement(By.id("guarantorMiddleInitial"));
        middleinitial.clear();
        middleinitial.sendKeys(midName.trim());


        WebElement glastname = chromedriver.findElement(By.id("guarantorLastName"));
        glastname.clear();
        glastname.sendKeys(GuarantorInfo.LAST_NAME);

        new Select(chromedriver.findElement(By.id("guarantorInstance.relationshipToPatient"))).selectByVisibleText(GuarantorInfo.RELATION);

        new Select(chromedriver.findElement(By.id("gurantorgender"))).selectByVisibleText(GuarantorInfo.GENDER);

        WebElement d_O_b2 = chromedriver.findElement(By.id("dateOfBirth2"));
        d_O_b2.clear();
        d_O_b2.sendKeys(GuarantorInfo.DATE_OF_BIRTH);

        WebElement s_s_n2 = chromedriver.findElement(By.id("socialSecurityNumber"));
        s_s_n2.clear();
        s_s_n2.sendKeys(GuarantorInfo.SSN);

        new Select(chromedriver.findElement(By.id("maritalStatus"))).selectByVisibleText(GuarantorInfo.MARITAL_STATUS);

        WebElement g_Address1 = chromedriver.findElement(By.id("guarantorAddress1"));
        g_Address1.clear();
        g_Address1.sendKeys(GuarantorInfo.ADDRESS1);

        WebElement g_Address2 = chromedriver.findElement(By.id("guarantorAddress2"));
        g_Address2.clear();
        g_Address2.sendKeys(GuarantorInfo.ADDRESS2);

        WebElement g_city = chromedriver.findElement(By.id("guarantorCity"));
        g_city.clear();
        g_city.sendKeys(GuarantorInfo.CITY);


        WebElement g_state = chromedriver.findElement(By.id("guarantorState"));
        g_state.clear();
        g_state.sendKeys(GuarantorInfo.STATE);

        WebElement g_zip = chromedriver.findElement(By.id("guarantorZip"));
        g_zip.clear();
        g_zip.sendKeys(GuarantorInfo.ZIP_CODE);

        WebElement g_cont_num = chromedriver.findElement(By.id("contactNum"));
        g_cont_num.clear();
        g_cont_num.sendKeys(GuarantorInfo.CONTACT_NUMBER);


        WebElement g_email = chromedriver.findElement(By.id("contactEmail"));
        g_email.clear();
        g_email.sendKeys(GuarantorInfo.EMAIL);


        /* insurance info */

        chromedriver.findElement(By.xpath("//*[@id=\"tabs\"]/li[3]/a")).click();

        	/* add workmen*/

        chromedriver.findElement(By.xpath("//*[@id=\"insurancetab\"]/div[1]/button[1]")).click();

        new Select(chromedriver.findElement(By.id("e1"))).selectByVisibleText(InsuranceInfo.INSURANCE);
        
        

        new Select(chromedriver.findElement(By.id("guarantorRelation"))).selectByVisibleText(InsuranceInfo.REL_OF_INSURED);

        WebElement w_policyId = chromedriver.findElement(By.name("worksmen.policyID"));
        w_policyId.clear();
        w_policyId.sendKeys(InsuranceInfo.POLICY_ID);

        WebElement inusrance_gname = chromedriver.findElement(By.name("worksmen.insuranceGroupName"));
        inusrance_gname.clear();
        inusrance_gname.sendKeys(InsuranceInfo.GROUP_NAME);

        WebElement g_insurnce_number = chromedriver.findElement(By.name("worksmen.insuranceGroupNumber"));
        g_insurnce_number.clear();
        g_insurnce_number.sendKeys(InsuranceInfo.GROUP_NUMBER);


        WebElement w_validtypolicy = chromedriver.findElement(By.name("worksmen.validityOfPolicy"));
        w_validtypolicy.clear();
        w_validtypolicy.sendKeys(InsuranceInfo.VALIDITY_OF_POLICY);


        WebElement work_insured = chromedriver.findElement(By.name("worksmen.nameOfInsured"));
        work_insured.clear();
        work_insured.sendKeys(InsuranceInfo.NAME_OF_INSURED);

        /* Add primary details */


        Thread.sleep(2000);

        chromedriver.findElement(By.cssSelector("button.btn.btn-primary.btn-md.addButton")).sendKeys(Keys.ENTER);


       new Select(chromedriver.findElement(By.id("e1"))).selectByVisibleText(InsuranceInfo.INSURANCE);

        new Select(chromedriver.findElement(By.name("insuranceInstance[1].guarantorRelation"))).selectByVisibleText(InsuranceInfo.REL_OF_INSURED);

        WebElement w_policyId1 = chromedriver.findElement(By.name("insuranceInstance[1].policyID"));
        w_policyId1.clear();
        w_policyId1.sendKeys(InsuranceInfo.POLICY_ID);

        WebElement inusrance_gname1 = chromedriver.findElement(By.name("insuranceInstance[1].insuranceGroupName"));
        inusrance_gname1.clear();
        inusrance_gname1.sendKeys(InsuranceInfo.GROUP_NAME);

        WebElement g_insurnce_number1 = chromedriver.findElement(By.name("insuranceInstance[1].insuranceGroupNumber"));
        g_insurnce_number1.clear();
        g_insurnce_number1.sendKeys(InsuranceInfo.GROUP_NUMBER);


        WebElement w_validtypolicy1 = chromedriver.findElement(By.name("insuranceInstance[1].validityOfPolicy"));
        w_validtypolicy1.clear();
        w_validtypolicy1.sendKeys(InsuranceInfo.VALIDITY_OF_POLICY);


        WebElement work_insured1 = chromedriver.findElement(By.name("insuranceInstance[1].nameOfInsured"));
        work_insured1.clear();
        work_insured1.sendKeys(InsuranceInfo.NAME_OF_INSURED);

        /* Add SEcondary details */



        chromedriver.findElement(By.xpath("//*[@id=\"insurancetab\"]/div[1]/button[2]")).click();

       
        new Select(chromedriver.findElement(By.id("e1"))).selectByVisibleText(InsuranceInfo.INSURANCE);

        new Select(chromedriver.findElement(By.name("insuranceInstance[2].guarantorRelation"))).selectByVisibleText(InsuranceInfo.REL_OF_INSURED);

        WebElement w_policyId2 = chromedriver.findElement(By.name("insuranceInstance[2].policyID"));
        w_policyId2.clear();
        w_policyId2.sendKeys(InsuranceInfo.POLICY_ID);

        WebElement inusrance_gname2 = chromedriver.findElement(By.name("insuranceInstance[2].insuranceGroupName"));
        inusrance_gname2.clear();
        inusrance_gname2.sendKeys(InsuranceInfo.GROUP_NAME);

        WebElement g_insurnce_number2 = chromedriver.findElement(By.name("insuranceInstance[2].insuranceGroupNumber"));
        g_insurnce_number2.clear();
        g_insurnce_number2.sendKeys(InsuranceInfo.GROUP_NUMBER);


        WebElement w_validtypolicy2 = chromedriver.findElement(By.name("insuranceInstance[2].validityOfPolicy"));
        w_validtypolicy2.clear();
        w_validtypolicy2.sendKeys(InsuranceInfo.VALIDITY_OF_POLICY);


        WebElement work_insured2 = chromedriver.findElement(By.name("insuranceInstance[2].nameOfInsured"));
        work_insured2.clear();
        work_insured2.sendKeys(InsuranceInfo.NAME_OF_INSURED);

        /*Add Tertiary details */

        chromedriver.findElement(By.xpath("//*[@id=\"insurancetab\"]/div[1]/button[2]")).click();

        

        new Select(chromedriver.findElement(By.id("e1"))).selectByVisibleText(InsuranceInfo.INSURANCE);

        new Select(chromedriver.findElement(By.name("insuranceInstance[3].guarantorRelation"))).selectByVisibleText(InsuranceInfo.REL_OF_INSURED);

        WebElement w_policyId3 = chromedriver.findElement(By.name("insuranceInstance[3].policyID"));
        w_policyId3.clear();
        w_policyId3.sendKeys(InsuranceInfo.POLICY_ID);

        WebElement inusrance_gname3 = chromedriver.findElement(By.name("insuranceInstance[3].insuranceGroupName"));
        inusrance_gname3.clear();
        inusrance_gname3.sendKeys(InsuranceInfo.GROUP_NAME);

        WebElement g_insurnce_number3 = chromedriver.findElement(By.name("insuranceInstance[3].insuranceGroupNumber"));
        g_insurnce_number3.clear();
        g_insurnce_number3.sendKeys(InsuranceInfo.GROUP_NUMBER);


        WebElement w_validtypolicy3 = chromedriver.findElement(By.name("insuranceInstance[3].validityOfPolicy"));
        w_validtypolicy3.clear();
        w_validtypolicy3.sendKeys(InsuranceInfo.VALIDITY_OF_POLICY);


        WebElement work_insured3 = chromedriver.findElement(By.name("insuranceInstance[3].nameOfInsured"));
        work_insured3.clear();
        work_insured3.sendKeys(InsuranceInfo.NAME_OF_INSURED);

        /*submit button*/


        chromedriver.findElement(By.xpath("//*[@id=\"form\"]/div/div[4]/div/button")).click();

    }

    @Then("^Added Patients should be displayed in the Patients List$")
    public void Added_Patient_should_be_displayed_in_the_Patients_LIst() throws Throwable {


        String progressurl = "http://bmtechsol.com:8080/easytox/orderFrom/create";
        String progressurlFromchromedriver = chromedriver.getCurrentUrl();

        Assert.assertEquals(progressurl, progressurlFromchromedriver);


    }


    private static final class PatientInfo {
        private static final String FIRST_NAME = "firstName";
        private static final String LAST_NAME = "lastName";
        private static final String MIDDLE_NAME = "middleName";
        private static final String DATE_OF_BIRTH = "11/06/1993";
        private static final String SSN = "385346689";
        private static final String ADDRESS1 = "address1";
        private static final String CITY = "city";
        private static final String ADDRESS2 = "address2";
        private static final String STATE = "ohio";
        private static final String ZIP_CODE = "43016";
        private static final String EMAIL = "some@gmail.com";
        private static final String HOME_PHONE = "9223334445";
        private static final String MOBILE_PHONE = "9223334450";
        private static final String EMPLOYMENT = "not busy";
        private static final String MEDICAL_RECORD = "someRecord";
        private static final String ALTERNATIVE_ID = "12345";
        private static final String GENDER = "Male";
        private static final String LAB_CLIENT = "Quest";

        private static final class EmergencyContact {
            private static final String CONTACT_NAME = "Tom";
            private static final String PHONE_NUMBER = "9223334425";
            private static final String RELATION = "friend";
        }

    }

    private static final class GuarantorInfo{
        private static final String FIRST_NAME = "firstName";
        private static final String LAST_NAME = "lastName";
        private static final String MIDDLE_NAME = "middleName";
        private static final String RELATION = "Self";
        private static final String GENDER = "Male";
        private static final String DATE_OF_BIRTH = "11/06/1993";
        private static final String SSN = "385346689";
        private static final String MARITAL_STATUS = "Single";
        private static final String ADDRESS1 = "address1";
        private static final String ADDRESS2 = "address2";
        private static final String CITY = "city";
        private static final String STATE = "ohio";
        private static final String ZIP_CODE = "43016";
        private static final String CONTACT_NUMBER = "9223334445";
        private static final String EMAIL = "some@gmail.com";
    }

    private static final class InsuranceInfo{
        private static final String REL_OF_INSURED = "Self";
        private static final String INSURANCE = "YYDDHH";
        private static final String POLICY_ID = "J548HJ";
        private static final String GROUP_NAME = "groupName";
        private static final String VALIDITY_OF_POLICY = "12/10/2016";
        private static final String GROUP_NUMBER = "KHDJKDJ";
        private static final String NAME_OF_INSURED = "nameOfInsured";
    }


}


       