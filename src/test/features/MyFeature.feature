@Feature#1
Feature: MyFeature

  @success
  Scenario: Healthcheck
    Given I have http client
    When Call Sql/DemoAccountingMicroservice healthcheck
    Then http client return true