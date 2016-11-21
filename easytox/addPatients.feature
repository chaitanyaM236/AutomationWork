@uat @smoke @bvt
Feature: AddPatient

  @positive
  Scenario Outline: Adding Patients to the Physician

    Given Patient should be login to the Application
    Then Order list page should be displayed

    When Click on Create Order from the left menu
    Then Create Order page should be displayed

    When Click on '+'; icon next to patient
    Then Add patient page should be displayed

    When Enter Patient <name> , <middleName> and Enter the required information and click submit
    Then Added Patients should be displayed in the Patients List

    Examples:
      | name   | middleName |
      | Raja   | Raman      |
      | Red    | vandit     |
      | Riley  | william    |
      | Ronnie | Hebrew     |