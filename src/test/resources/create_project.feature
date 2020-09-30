Feature: Project creation
  Scenario Outline: User creates new project
    Given User opens page
    And User selects <dependency_manager> project
    And User selects <language> language
    And User selects <spring_boot_version> version of SpringBoot
    And User inputs <group_name> group name
    And User inputs <artifact> artifact
    And User inputs <name> name
    And User inputs <description> description
    And User inputs <package_name> package name
    And User selects <packaging> packaging
    And User select <java_version> version of Java
    And User inputs <dependencies> dependencies
    When User clicks Generate button
    Then Project is downloaded
    Examples:
      | dependency_manager   | language   | spring_boot_version  | group_name    | artifact           | name          | description                    | package_name               | packaging     | java_version   | dependencies        |
      | "Maven Project"      | "Java"     | "2.4.0 (SNAPSHOT)"   | "org.example" | "test-project"     | "TestProject" | "Demo project for Spring Boot" | "org.example.test_project" | "Jar"         | "8"            | "Lombok, WebSocket" |
      | "Gradle Project"     | "Kotlin"   | "2.4.0 (SNAPSHOT)"   | "org.example" | "test-project2"    | "TestProject2" | "Demo project for Spring Boot"| "org.example.test_project" | "Jar"         | "8"            | "Lombok, WebSocket, Spring Reactive Web, Spring HATEOAS, Jersey, Thymeleaf" |

