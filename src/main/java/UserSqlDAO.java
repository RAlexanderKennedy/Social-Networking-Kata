import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSet;

public class UserSqlDAO implements UserDAO{
	
	private JdbcTemplate template;
	

	public List<Post> getChatTimelineByUserId(long id) {
		String sql = "Select * from timeline where user_id = ?";
		List<Post> timeline = new ArrayList<Post>();
		
		RowSet results = template.queryForRowSet(sql, id);
		
		while(results.next()) {
			Post thisPost = mapRowToPosts(results);
		}
		
		return timeline;
	}

	public void createNewUser(User newUser) {
		String name = newUser.getName();
		long id = newUser.getId();
		List<Post> timeline = newUser.getChatTimeline();
		String sql = "insert into users (user_name, user_id, timeline values (?,?,?)";
		template.update(sql, name, id, timeline);
	}

	public void changeUsername (User updatedUser) {
		String sql = "update users set name= ? where user_id= ?";
		template.update(sql, updatedUser.getName(), updatedUser.getId());
	}

	public void deleteAccount(long userId) {
		String sql = "delete from users where user_id = ?";
		template.update(sql, userId);
		
	}

	public void addPostToTimeline(String newPostContent, User userPosting) {
		Time currentTime = Time.valueOf(LocalTime.now());
		List<Post> thisTimeline = userPosting.getChatTimeline();
		Post newPost = null;
		newPost.setContent(newPostContent);
		newPost.setPostId(getNextPostId());
		newPost.setTimestamp(currentTime);
		
		thisTimeline.add(newPost);
		
		String sql = "update users set timeline = ? where user_id = ?";
		template.update(sql, thisTimeline, userPosting.getId());
	}


	public void deletePost(long postId) {
		// TODO Auto-generated method stub
		
	}

	public Post editPost(Post updatedPost) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Post mapRowToPosts(RowSet rs) {
        Post newPost = new Post();
        newPost.setContent(rs.getString("content"));
        newPost.setPostId(rs.getLong("post_id"));
        newPost.setTimestamp(rs.getTime("time"));
        return newPost;
    }

	private long getNextPostId() {
			RowSet nextIdResult = template.queryForRowSet("select nextval('seq_post_id')");
			if (nextIdResult.next()) {
				return nextIdResult.getLong(1);
			} else {
				throw new RuntimeException("Something has gone horribly, horribly wrong");
			}
		}
	
}
