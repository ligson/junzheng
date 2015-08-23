package junzheng;

import java.sql.Connection;
import java.util.Date;

public class RmsProgram {
	// id
	private long id;
	// 版本
	private int version;
	// 作者
	private String actor;
	private boolean can_all_download = true;
	private boolean can_all_play = true;
	private boolean can_distribute = true;
	private boolean can_download = true;
	private boolean can_play = true;
	private boolean can_public = true;
	private boolean can_union = true;
	// 栏目
	private int category = 0;
	// 类库 Directory表中的一级目录 为了以后扩展目录树备用
	private long class_lib_id;
	private int collect_num = 0;
	private long consumer_id;
	private Date date_created = new Date();
	private Date date_deleted;
	private Date date_modified = new Date();
	private Date date_passed = new Date();
	private String description;
	// 导演，次要责任者，可能不用
	private String director;
	private long directory_id;
	private long download_num = 0;
	private int eidtion = 0;
	// 第一个分类的id, 方便寻找分面,上传路径
	private long first_category_id;
	private int frequency = 0;
	private long from_id;
	private long from_node_id;
	private String from_node_ip;
	private String from_node_name;
	private int from_state;
	private String guid;
	// 是否在各个分类首页显示 0-否 1-是
	private int is_category_show = 0;
	// 是否作为今日焦点 0-否 1-是
	private int is_focus = 0;
	private int is_index_show = 0;
	private String name;
	private int now_version;
	private Date open_date;
	private int other_option = 0;
	private long out_class_id;
	private int plan_count;
	private String poster_hash;
	private String poster_name;
	private String poster_path;
	private String poster_type;
	private int pre_version = 0;
	private int program_score = 0;
	private int recommend_num = 0;
	private int remark_num = 0;
	private int serial_num = 0;
	private long special_id;
	private String special_name;
	private int state = 1;
	private int transcode_state = 0;
	private int type = 0;
	private String vertical_poster_hash;
	private String vertical_poster_name;
	private String vertical_poster_path;
	private String vertical_poster_type;
	private int view_num = 0;
	private boolean recommend_state = false;

	public boolean isRecommend_state() {
		return recommend_state;
	}

	public void setRecommend_state(boolean recommend_state) {
		this.recommend_state = recommend_state;
	}

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

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public boolean isCan_all_download() {
		return can_all_download;
	}

	public void setCan_all_download(boolean can_all_download) {
		this.can_all_download = can_all_download;
	}

	public boolean isCan_all_play() {
		return can_all_play;
	}

	public void setCan_all_play(boolean can_all_play) {
		this.can_all_play = can_all_play;
	}

	public boolean isCan_distribute() {
		return can_distribute;
	}

	public void setCan_distribute(boolean can_distribute) {
		this.can_distribute = can_distribute;
	}

	public boolean isCan_download() {
		return can_download;
	}

	public void setCan_download(boolean can_download) {
		this.can_download = can_download;
	}

	public boolean isCan_play() {
		return can_play;
	}

	public void setCan_play(boolean can_play) {
		this.can_play = can_play;
	}

	public boolean isCan_public() {
		return can_public;
	}

	public void setCan_public(boolean can_public) {
		this.can_public = can_public;
	}

	public boolean isCan_union() {
		return can_union;
	}

	public void setCan_union(boolean can_union) {
		this.can_union = can_union;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public long getClass_lib_id() {
		return class_lib_id;
	}

	public void setClass_lib_id(long class_lib_id) {
		this.class_lib_id = class_lib_id;
	}

	public int getCollect_num() {
		return collect_num;
	}

	public void setCollect_num(int collect_num) {
		this.collect_num = collect_num;
	}

	public long getConsumer_id() {
		return consumer_id;
	}

	public void setConsumer_id(long consumer_id) {
		this.consumer_id = consumer_id;
	}

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDate_deleted() {
		return date_deleted;
	}

	public void setDate_deleted(Date date_deleted) {
		this.date_deleted = date_deleted;
	}

	public Date getDate_modified() {
		return date_modified;
	}

	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}

	public Date getDate_passed() {
		return date_passed;
	}

	public void setDate_passed(Date date_passed) {
		this.date_passed = date_passed;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public long getDirectory_id() {
		return directory_id;
	}

	public void setDirectory_id(long directory_id) {
		this.directory_id = directory_id;
	}

	public long getDownload_num() {
		return download_num;
	}

	public void setDownload_num(long download_num) {
		this.download_num = download_num;
	}

	public int getEidtion() {
		return eidtion;
	}

	public void setEidtion(int eidtion) {
		this.eidtion = eidtion;
	}

	public long getFirst_category_id() {
		return first_category_id;
	}

	public void setFirst_category_id(long first_category_id) {
		this.first_category_id = first_category_id;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	public long getFrom_id() {
		return from_id;
	}

	public void setFrom_id(long from_id) {
		this.from_id = from_id;
	}

	public long getFrom_node_id() {
		return from_node_id;
	}

	public void setFrom_node_id(long from_node_id) {
		this.from_node_id = from_node_id;
	}

	public String getFrom_node_ip() {
		return from_node_ip;
	}

	public void setFrom_node_ip(String from_node_ip) {
		this.from_node_ip = from_node_ip;
	}

	public String getFrom_node_name() {
		return from_node_name;
	}

	public void setFrom_node_name(String from_node_name) {
		this.from_node_name = from_node_name;
	}

	public int getFrom_state() {
		return from_state;
	}

	public void setFrom_state(int from_state) {
		this.from_state = from_state;
	}

	public String getGuid() {
		return guid;
	}

	public void setGuid(String guid) {
		this.guid = guid;
	}

	public int getIs_category_show() {
		return is_category_show;
	}

	public void setIs_category_show(int is_category_show) {
		this.is_category_show = is_category_show;
	}

	public int getIs_focus() {
		return is_focus;
	}

	public void setIs_focus(int is_focus) {
		this.is_focus = is_focus;
	}

	public int getIs_index_show() {
		return is_index_show;
	}

	public void setIs_index_show(int is_index_show) {
		this.is_index_show = is_index_show;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNow_version() {
		return now_version;
	}

	public void setNow_version(int now_version) {
		this.now_version = now_version;
	}

	public Date getOpen_date() {
		return open_date;
	}

	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}

	public int getOther_option() {
		return other_option;
	}

	public void setOther_option(int other_option) {
		this.other_option = other_option;
	}

	public long getOut_class_id() {
		return out_class_id;
	}

	public void setOut_class_id(long out_class_id) {
		this.out_class_id = out_class_id;
	}

	public int getPlan_count() {
		return plan_count;
	}

	public void setPlan_count(int plan_count) {
		this.plan_count = plan_count;
	}

	public String getPoster_hash() {
		return poster_hash;
	}

	public void setPoster_hash(String poster_hash) {
		this.poster_hash = poster_hash;
	}

	public String getPoster_name() {
		return poster_name;
	}

	public void setPoster_name(String poster_name) {
		this.poster_name = poster_name;
	}

	public String getPoster_path() {
		return poster_path;
	}

	public void setPoster_path(String poster_path) {
		this.poster_path = poster_path;
	}

	public String getPoster_type() {
		return poster_type;
	}

	public void setPoster_type(String poster_type) {
		this.poster_type = poster_type;
	}

	public int getPre_version() {
		return pre_version;
	}

	public void setPre_version(int pre_version) {
		this.pre_version = pre_version;
	}

	public int getProgram_score() {
		return program_score;
	}

	public void setProgram_score(int program_score) {
		this.program_score = program_score;
	}

	public int getRecommend_num() {
		return recommend_num;
	}

	public void setRecommend_num(int recommend_num) {
		this.recommend_num = recommend_num;
	}

	public int getRemark_num() {
		return remark_num;
	}

	public void setRemark_num(int remark_num) {
		this.remark_num = remark_num;
	}

	public int getSerial_num() {
		return serial_num;
	}

	public void setSerial_num(int serial_num) {
		this.serial_num = serial_num;
	}

	public long getSpecial_id() {
		return special_id;
	}

	public void setSpecial_id(long special_id) {
		this.special_id = special_id;
	}

	public String getSpecial_name() {
		return special_name;
	}

	public void setSpecial_name(String special_name) {
		this.special_name = special_name;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getTranscode_state() {
		return transcode_state;
	}

	public void setTranscode_state(int transcode_state) {
		this.transcode_state = transcode_state;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getVertical_poster_hash() {
		return vertical_poster_hash;
	}

	public void setVertical_poster_hash(String vertical_poster_hash) {
		this.vertical_poster_hash = vertical_poster_hash;
	}

	public String getVertical_poster_name() {
		return vertical_poster_name;
	}

	public void setVertical_poster_name(String vertical_poster_name) {
		this.vertical_poster_name = vertical_poster_name;
	}

	public String getVertical_poster_path() {
		return vertical_poster_path;
	}

	public void setVertical_poster_path(String vertical_poster_path) {
		this.vertical_poster_path = vertical_poster_path;
	}

	public String getVertical_poster_type() {
		return vertical_poster_type;
	}

	public void setVertical_poster_type(String vertical_poster_type) {
		this.vertical_poster_type = vertical_poster_type;
	}

	public int getView_num() {
		return view_num;
	}

	public void setView_num(int view_num) {
		this.view_num = view_num;
	}

	/***
	 * 资源
	 * 
	 * @param id
	 *            资源id
	 * @param consumer_id
	 *            用户id
	 * @param directoryId
	 *            分类id
	 * @param date_created
	 *            创建日期
	 * @param description
	 *            描述
	 * @param name
	 *            资源名字
	 */
	public RmsProgram(long id, long consumer_id, long directoryId,
			Date date_created, String description, String name) {
		super();
		this.id = id;
		this.consumer_id = consumer_id;
		this.date_created = date_created;
		this.description = description;
		this.name = name;
		this.class_lib_id = directoryId;
		this.directory_id = directoryId;
	}

	public RmsProgram() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void insert() throws Exception {
		Connection connection = ConnectPool.getRmsConnection();
		SqlUtils.insert(this, "program", connection);
	}

}
