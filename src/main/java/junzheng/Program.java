package junzheng;

import java.sql.Date;

public class Program {
	private String id;
	private String title;
	private String author;
	private Date date;
	private String fileUrl;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Program(String id, String title, String author, Date date,
			String fileUrl, String description) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
		this.fileUrl = fileUrl;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Program [id=" + id + ", title=" + title + ", author=" + author
				+ ", date=" + date + ", fileUrl=" + fileUrl + ", description="
				+ description + "]";
	}

}
