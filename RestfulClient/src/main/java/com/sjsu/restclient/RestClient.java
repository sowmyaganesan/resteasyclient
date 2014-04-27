package com.sjsu.restclient;



import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.sjsu.pojo.Bookmark;
import com.sjsu.pojo.Bookmarkcollection;
import com.sjsu.pojo.Inviteemails;
import com.sjsu.pojo.Item;
import com.sjsu.pojo.TrustScoreCollection;
import com.sjsu.pojo.User;
import com.sjsu.pojo.UserBookmark;
import com.sjsu.pojo.Useremail;

public class RestClient {

	
	public static void main(String args[])
	{
		//addUser();
		//updatebookmark();
		//deletebookmark();
		//editUser();
		//deleteUser();
		//signin();
		//invitefriends();
		//addTrustscoretofriend();
		//removefriendfromtrustnw();
		updateTrustscoretofriend();
		//getauserbookmark();
	}
	
	/*private static void getauserbookmark()

    {
    	Useremail useremail = new Useremail();
    	useremail.setEmail("sowmister@gmail.com");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/bookmark/getauserbookmark");
        Response response;
		try {
			response = target.request().post(Entity.entity(useremail,"application/json"));
			//Read output in string format
	        System.out.println(response.readEntity(String.class));
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }*/
	
	private static void getauserbookmark()

    {
    	Useremail useremail = new Useremail();
    	useremail.setEmail("sowmister@gmail.com");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/bookmark/getauserbookmark?email=sowmister@gmail.com");
        Response response;
		try {
			response = target.request().get(Response.class);
			//Read output in string format
			System.out.println(response.readEntity(String.class));
	        //System.out.println(response);
	        // response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
 			e.printStackTrace();
		}
        
    }
	
	private static void invitefriends()

    {
    	Inviteemails inviteemails = new Inviteemails();
    	List<String> to = new ArrayList<String>();
    	to.add("sowmister@gmail.com");
    	to.add("sowmyaganesan_11@yahoo.com");
    	 inviteemails.setEmailaddress(to);
    	 inviteemails.setSenderemail("sowmister@gmail.com");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/friends/invitefriends");
        Response response;
		try {
			response = target.request().post(Entity.entity(inviteemails,"application/json"));
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	private static void addTrustscoretofriend()

    {
		TrustScoreCollection trustScoreCollection = new TrustScoreCollection();
		trustScoreCollection.setFriend("sowmyaganesan_11@yahoo.com");
		trustScoreCollection.setUser("sowmister@gmail.com");
		trustScoreCollection.setCategory("movies");
		trustScoreCollection.setExplicit("true");
		trustScoreCollection.setTrustscore(5);
		
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/friends/addTrustscoretofriend");
        Response response;
		try {
			response = target.request().post(Entity.entity(trustScoreCollection,"application/json"));
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	private static void updateTrustscoretofriend()

    {
		TrustScoreCollection trustScoreCollection = new TrustScoreCollection();
		trustScoreCollection.setFriend("sowmyaganesan_11@yahoo.com");
		trustScoreCollection.setUser("sowmister@gmail.com");
		trustScoreCollection.setCategory("movies");
		trustScoreCollection.setExplicit("true");
		trustScoreCollection.setTrustscore(4);
		
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/friends/updateTrustscoretofriend");
        Response response;
		try {
			response = target.request().post(Entity.entity(trustScoreCollection,"application/json"));
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	
	private static void removefriendfromtrustnw()

    {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/friends/removefriendfromtrustnw?user=sowmister@gmail.com&friend=sowmyaganesan_11@yahoo.com&category=Hotel");
        Response response;
		try {
			response = target.request().delete();
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	private static void signin()

    {
    	User user = new User();
    	user.setEmail("sowmister@gmail.com");
    	user.setPasswrd("1234");
        
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/login/signin");
        Response response;
		try {
			response = target.request().post(Entity.entity(user,"application/json"));
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	
	private static void updatebookmark()

    {
		Bookmarkcollection bookmarkcollection = new Bookmarkcollection();
		bookmarkcollection.setCategory("Farmer's Market");
		bookmarkcollection.setName("Farmer's2");
		bookmarkcollection.setLocation("San Jose2");
		bookmarkcollection.setEmail("vidya@gmail.com");
		bookmarkcollection.setStats("100 Likes");
		bookmarkcollection.setStatus("Tried");
		bookmarkcollection.setTried(true);
		
		
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/bookmark/updatebookmark");
        Response response;
		try {
			response = target.request().post(Entity.entity(bookmarkcollection,"application/json"));
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	private static void deletebookmark()

    {
        
		UserBookmark userbookmark = new UserBookmark();
		userbookmark.setBookmark("535bda7e9f55f135c6522a70");
		userbookmark.setEmail("sowmister@gmail.com");
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/bookmark/deletebookmark?bookmarkid=535bda7e9f55f135c6522a70&email=sowmister@gmail.com");
        Response response;
		try {
			response = target.request().delete();
			//Read output in string format
	        System.out.println(response.getStatus());
	        response.close(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	public static void addUser() {

		try
		{
			User user = new User();
			user.setCity("sanjose");
			user.setName("Sowmy");
			user.setEmail("sowmyaganesan_11@yahoo.com");
			user.setZip(95051);
			user.setPasswrd("1234");
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/restservice/adduser");
			Response response = target.request().post(Entity.entity(user, "application/json"));
			if (response.getStatus() != 200) {
				throw new Exception("Failed : HTTP error code : " + response.getStatus() +" "+ response.readEntity(String.class) + response.getLanguage() );
			}
			System.out.println("Server response : \n");
			System.out.println(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void editUser() {
		try
		{
			User user = new User();
			user.setCity("sanjose");
			user.setName("vallividhyaedited");
			user.setEmail("valli.vidhya@gmail.com");
			user.setZip(95051);
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/restservice/edituser");
			Response response = target.request().post(Entity.entity(user, "application/json"));
			if (response.getStatus() != 200) {
				throw new Exception("Failed : HTTP error code : " + response.getStatus() +" "+ response.readEntity(String.class) );
				}
			System.out.println("Server response : \n");
			System.out.println(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void deleteUser() {
		try
		{
			User user = new User();
			user.setEmail("sowmister@gmail.com");
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/restservice/deleteuser?email=sowmister@gmail.com");
			Response response = target.request().delete();
			if (response.getStatus() != 200) {
				throw new Exception("Failed : HTTP error code : " + response.getStatus() +" "+ response.readEntity(String.class) );
			}
			System.out.println("Server response : \n");
			System.out.println(response.readEntity(String.class));
			response.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public static void testGet() {

		try
		{
			User user = new User();
			user.setName("latchu");
			ResteasyClient client = new ResteasyClientBuilder().build();

			ResteasyWebTarget target = client.target("http://localhost:8080/TrustBasedRecommendation/jsonServices/print");

			
			Response response = target.request().get();

			if (response.getStatus() != 200) {

				throw new RuntimeException("Failed : HTTP error code : "

			                        + response.getStatus());

			}

			System.out.println("Server response : \n");

			System.out.println(response.readEntity(String.class));

			response.close();

		} catch (Exception e) {

			e.printStackTrace();

		}



	}


}
