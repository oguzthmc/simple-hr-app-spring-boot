# Simple HR Application (Spring Boot) 


In this assignment, you are expected to develop a simple job application platform by using Spring Boot. Application has 2 user roles as HR Manager and Applicant. HR Managers can manage all job listings and see applicant data. You are required to implement these steps:<br>
<br>

## Step 1: Job Listing Management Module

Our HR Manager wants to create a listing platform. The platform requirements are,

- Job listings should have attributes "Job Title", "Job Description", "Number of people to hire", "Last application date".
- As an HR Manager, I should create new job listings.
- As an HR Manager, I should list the job listings on a listing page.
- There should be show details link for each job listing on listing page. As an HR Manager, I should see the details of a job listing by clicking the link.
- There should be delete job listing link for each job listing on listing page. As an HR Manager, I should delete a job listing by clicking the link. Deleted job listings won't be seen by anyone.<br>
	
`Everything should be persisted on database on this step.`<br>
* https://spring.io/guides/gs/accessing-data-jpa/


## Step 2: Add Authenticaton

We created a job listing creation app but everybody can create a job listing. Add an authentication mechanism and then only hr manager should manage job listings.

- HR Manager should login with email and password. You can create an account manually, you don't have to implement a sign-up functionality.

`You can use Spring Security.`<br>
* https://spring.io/guides/gs/securing-web/


## Step 3: Job Application Page

There should be a page for other people to apply to the jobs which will be created by our HR manager. Requirements are,

- Create a listing page for the job listings that HR Manager created.
- Applicants can see the listings and click for the detail of a listing.
- In job listing detail page, there should be a job application form.
- Job application form should get the information "Name", "Email", "Phone", "Address", "Thoughts on Job", "Resume" (as a file) from the applicant and save these information to database.


## Step 4: Application Listing Module

We've got some applicants and hr manager want to see the list of all job applications.

- Create a job applications listing page. As an HR Manager, I should see all applications.
- All job applications should have a detail page. As an HR Manager, I should see the detail page by clicking show detail link.
- Only HR Manager should see the listing page. He/she should login to the system in order to see this page.


### Bonus: User Friendly UI

You can use one of following UI libraries to make the application good looking and user friendly:

- http://semantic-ui.com/
- http://getbootstrap.com


### Bonus 2: Test at least One Functionality

Write at least one unit test to cover one main functionalities. For example test if a job listing is being created by an unauthenticated user or test if an empty application form is saved.


### Resources

http://projects.spring.io/spring-boot/<br>

http://spring.io/guides<br>

https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples<br>

https://spring.io/guides/gs/handling-form-submission/<br>

