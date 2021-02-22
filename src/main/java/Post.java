import java.sql.Time;
import java.time.LocalDateTime;

public class Post {

	private String content;
	
	private Time timestamp;
	
	private long postId;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Time getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Time time) {
		this.timestamp = time;
	}

	public long getPostId() {
		return postId;
	}

	public void setPostId(long postId) {
		this.postId = postId;
	}

	public Post(String content, Time timestamp, long postId) {
		super();
		this.content = content;
		this.timestamp = timestamp;
		this.postId = postId;
	}

	public Post() {
		// TODO Auto-generated constructor stub
	}


	
}
