

import java.util.List;

public interface UserDAO {
	
	List<Post> getChatTimelineByUserId(long id);
	
	void createNewUser(User newUser);
	
	User updateUser (User updatedUser);
	
	void deleteAccount (long userId);
	
	Post addPostToTimeline(String newPostContent);
	
	void deletePost (long postId);
	
	Post editPost (Post updatedPost);
}
