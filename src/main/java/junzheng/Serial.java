package junzheng;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Serial {
	private long id;
	private int version = 0;
	private int band_width = 0;
	private Date date_created = new Date();
	private Date date_modified = new Date();
	private String description;
	private String end_time = "00:00:00";
	private String file_hash;
	private String file_path;
	private long file_size = 0;
	private String file_type;
	private String format_abstract;
	private String name;
	private String photo;
	private int process = 0;
	private int prog_type = 0;
	private long program_id;
	private int serial_no = 1;
	private String start_time = "00:00:00";
	private int state = 3;
	private String str_prog_type;
	private String svr_address;
	private int svr_port;
	private long time_length = 0;
	private int transcode_state = 0;
	private int url_type = 0;
	private String web_path;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public int getBand_width() {
		return band_width;
	}

	public void setBand_width(int band_width) {
		this.band_width = band_width;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getFile_hash() {
		return file_hash;
	}

	public void setFile_hash(String file_hash) {
		this.file_hash = file_hash;
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

	public String getFormat_abstract() {
		return format_abstract;
	}

	public void setFormat_abstract(String format_abstract) {
		this.format_abstract = format_abstract;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getProcess() {
		return process;
	}

	public void setProcess(int process) {
		this.process = process;
	}

	public int getProg_type() {
		return prog_type;
	}

	public void setProg_type(int prog_type) {
		this.prog_type = prog_type;
	}

	public long getProgram_id() {
		return program_id;
	}

	public void setProgram_id(long program_id) {
		this.program_id = program_id;
	}

	public int getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(int serial_no) {
		this.serial_no = serial_no;
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStr_prog_type() {
		return str_prog_type;
	}

	public void setStr_prog_type(String str_prog_type) {
		this.str_prog_type = str_prog_type;
	}

	public String getSvr_address() {
		return svr_address;
	}

	public void setSvr_address(String svr_address) {
		this.svr_address = svr_address;
	}

	public int getSvr_port() {
		return svr_port;
	}

	public void setSvr_port(int svr_port) {
		this.svr_port = svr_port;
	}

	public long getTime_length() {
		return time_length;
	}

	public void setTime_length(long time_length) {
		this.time_length = time_length;
	}

	public int getTranscode_state() {
		return transcode_state;
	}

	public void setTranscode_state(int transcode_state) {
		this.transcode_state = transcode_state;
	}

	public int getUrl_type() {
		return url_type;
	}

	public void setUrl_type(int url_type) {
		this.url_type = url_type;
	}

	public String getWeb_path() {
		return web_path;
	}

	public void setWeb_path(String web_path) {
		this.web_path = web_path;
	}

	public void insert() throws Exception {
		Connection connection = ConnectPool.getRmsConnection();
		SqlUtils.insert(this, "serial", connection);
	}

	public Serial() {
		super();
	}

	public Serial(long id, Long program_id, String file_hash, String file_path,
			long file_size, String file_type, String name, int serial_no) {
		super();
		this.id = id;
		this.program_id = program_id;
		this.file_hash = file_hash;
		this.file_path = file_path;
		this.file_size = file_size;
		this.file_type = file_type;
		this.name = name;
		this.serial_no = serial_no;
	}

	public void update() throws Exception {
		Connection connection = ConnectPool.getBmcConnection();
		SqlUtils.update(this, "serial", connection);
	}

	public static List<Serial> list() throws Exception {
		Connection connection = ConnectPool.getBmcConnection();
		List<Serial> list = SqlUtils.list(Serial.class, "serial", connection);
		return list;
	}

}
