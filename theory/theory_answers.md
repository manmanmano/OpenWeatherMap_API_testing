### 1. Which of the following activities cannot be automated
- [ ] Test execution
- [ ] Exploratory testing
- [X] Discussing testability issues
- [ ] Test data generation

### 2. How do we describe a good unit test?
- [ ] Flawless, Ready, Self-healing, True, Irresistible
- [X] Red, Green, Refactor
- [X] Fast, Repeatable, Self-validating, Timely, Isolated
- [ ] Tests should be dependent on other tests

### 3. When is it a good idea to use XPath selectors
- [ ] When CSS or other selectors are not an option or would be brittle and hard to maintain
- [ ] When we need to find an element based on parent/child/sibling relationship
- [ ] When an element is located deep within the HTML (or DOM) structure
- [X] All the above

### 4. Describe the TDD process
Test-driven development is a software development practice, where developers write tests before
having implemented the code. Firstly, the developer writes test for the application, and usually they fail. 
After failing tests are written, the developer implements the code in order to make the tests pass and to make the 
application function as intended. Once the code is implemented the developer reruns the test, in order to check if the all pass. 
If yes the code is refactored and if not the code implementation is fixed until all the tests pass.

### 5. Write 2 test cases or scenarios for a String Calculator application, which has a method ```calculate()``` that takes a string of two numbers separated by a comma as input, and returns the sum.
Example:
- **Given** the input "1,5" **When** the method ```calculate()``` is called **Then** I should see "6" as a result.

1. **Given** the input "3,6" **When** the method ```calculate()``` is called **Then** I should see "9" as a result.
2. **Given** the input "" **When** the method ```calculate()``` is called **Then** I should see "Input left blank!" as a result.