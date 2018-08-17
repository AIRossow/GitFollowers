# GitFollowers
API for getting Github Followers

This is still in the early stages of development, but the code uses GitHub's API for retrieving a given User's followers. Looking at the given user as the first level, it will get up to 5 users following them and then get up to 5 followers for each of those users returning them as a Json object. 

Right now for testing, I am using Swagger-UI to test the controller.

To test, clone the GitFollowers Project to your machine and import it into Eclipse as an existing Maven Project. Once that is complete, go to the application.properties file located in src/main/resources of the project and change the port number to one not currently being used on your machine. Then in the com.centuryLink.GitFollowers package, right click on the GitFollowersApplication.java and run as a Java Application.

Once it has started up, go to 
  
  http://localhost:{your-port-number}/swagger-ui.html
  
and select follower-controller -> GET

From here put in the userId you wish to get users for and click Try it out!

The Response Body should return the Json object containing the followers.
