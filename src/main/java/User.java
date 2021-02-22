import java.util.List;

public class User {

	private List<Post> chatTimeline;
	
	private String name;
	
	private long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Post> getChatTimeline() {
		return chatTimeline;
	}

	public void setChatTimeline(List<Post> chatTimeline) {
		this.chatTimeline = chatTimeline;
	}

	public User(List<Post> chatTimeline, String name, long id) {
		super();
		this.chatTimeline = chatTimeline;
		this.name = name;
		this.id = id;
	}

	
	
}
