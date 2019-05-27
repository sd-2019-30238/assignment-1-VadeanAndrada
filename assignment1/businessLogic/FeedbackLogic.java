package businessLogic;

import java.sql.SQLException;

import dataAccess.Feedback;
import dataAccess.ManageFeedback;
import dataAccess.ManageUser;
import dataAccess.User;

public class FeedbackLogic {
	
	public void addFeedback(String text) throws SQLException {
		ManageUser onlineUser= new ManageUser();
		User user=onlineUser.getIsOnlineUserName();
		ManageFeedback feed=new ManageFeedback();
		Feedback f=new Feedback(user.getNameUser(),text);
		feed.addFeedback(f);
	}
	
	public void deleteAllFeedback() throws SQLException {

		ManageFeedback feed=new ManageFeedback();
		Feedback f=new Feedback();
		feed.deleteFeedbacks();
	}
}
