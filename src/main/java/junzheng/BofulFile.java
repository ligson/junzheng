package junzheng;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BofulFile {
	private String id = UUID.randomUUID().toString().replaceAll("-", "");
	private int version;
	private String create_date = DateUtils.format(new Date());
	private String file_hash;
	private String file_name;
	private String file_path;
	private long file_size = 0;
	private String file_type;
	private long logic_length = 0;
	private int media_type = 1;
	private int process = 0;
	private int transcode_state = 0;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getFile_hash() {
		return file_hash;
	}

	public void setFile_hash(String file_hash) {
		this.file_hash = file_hash;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public long getFile_size() {
		return file_size;
	}

	public void setFile_size(long file_size) {
		this.file_size = file_size;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public long getLogic_length() {
		return logic_length;
	}

	public void setLogic_length(long logic_length) {
		this.logic_length = logic_length;
	}

	public int getMedia_type() {
		return media_type;
	}

	public void setMedia_type(int media_type) {
		this.media_type = media_type;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public int getTranscode_state() {
		return transcode_state;
	}

	public void setTranscode_state(int transcode_state) {
		this.transcode_state = transcode_state;
	}

	public BofulFile(String file_hash, String file_name, String file_path,
			long file_size, String file_type) {
		super();
		this.file_hash = file_hash;
		this.file_name = file_name;
		this.file_path = file_path;
		this.file_size = file_size;
		this.file_type = file_type;
	}

	public BofulFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert() throws Exception {
		Connection connection = ConnectPool.getBmcConnection();
		SqlUtils.insert(this, "boful_file", connection);
	}

	public void update() throws Exception {
		Connection connection = ConnectPool.getBmcConnection();
		SqlUtils.update(this, "boful_file", connection);
	}

	public static List<BofulFile> list() throws Exception {
		Connection connection = ConnectPool.getBmcConnection();
		List<BofulFile> list = SqlUtils.list(BofulFile.class, "boful_file",
				connection);
		return list;
	}

}
