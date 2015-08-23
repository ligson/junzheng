package junzheng;

import java.io.File;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.boful.common.file.utils.FileUtils;

public class DataTools {
	// 频道地址
	static String channelFullUrl = "/zxcp/jlrs/%";
	// 分类ID
	static int programCategoryId = 55;
	// 元数据标准Id
	static int directoryId = 1;
	// program最大的id加1
	private static long rmsProgramStartId = 4796;
	// serial最大的id加1
	private static long serailStartId = 4983;
	// master用户id
	private static long consumer_id = 1;

	public static List<Program> getList() throws Exception {
		Connection sqlServerConnection = ConnectPool.getSqlServerConnection();
		List<Program> programs = new ArrayList<>();

		String preSql = "select a.Title,a.Author,a.ID,a.Created,a.Description,a.ListKeys4 from Article a where a.ListKeys4 is not null and a.ListKeys4 <>''";
		String preSql2 = "select a.Title,a.Author,a.ID,a.Created,a.Description,a.ListKeys4 from Article a where a.ListKeys4 is not null and a.ListKeys4 <>'' and a.ChannelFullUrl like '"
				+ channelFullUrl + "'";
		PreparedStatement ps = sqlServerConnection
				.prepareStatement(preSql2);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String id = rs.getString(3);
			String title = rs.getString(1);
			String author = rs.getString(2);
			Date date = rs.getDate(4);
			String fileUrl = rs.getString(6);
			String description = rs.getString(5);
			Program p = new Program(id, title, author, date, fileUrl,
					description);
			programs.add(p);
		}
		rs.close();
		ps.close();

		return programs;
	}

	public static void insert() throws Exception {
		List<Program> programs = getList();
		int process = 1;
		// 导入rms
		for (Program program : programs) {
			System.out.println("插入进度:"+process*100.0/programs.size()+"%");
			process++;
			// 导入到bofulFile
			/*BofulFile bofulFile = new BofulFile(UUID.randomUUID().toString(),
					program.getFileUrl().substring(5), program.getFileUrl().substring(5), 0, "mp4");
			bofulFile.setCreate_date(DateUtils.format(program.getDate()));
			bofulFile.insert();*/
			
			// 导入program
			RmsProgram rmsProgram = new RmsProgram(rmsProgramStartId++,
					consumer_id, directoryId, program.getDate(),
					program.getDescription(), program.getTitle());
			rmsProgram.insert();

			// many
			ProgramCategoryPrograms programCategoryPrograms = new ProgramCategoryPrograms();
			programCategoryPrograms.setProgram_id(rmsProgram.getId());
			programCategoryPrograms.setProgram_category_id(programCategoryId);
			programCategoryPrograms.insert();
			ProgramProgramCategories programCategories = new ProgramProgramCategories();
			programCategories.setProgram_category_id(programCategoryId);
			programCategories.setProgram_id(rmsProgram.getId());
			programCategories.insert();
			
			// 导入serial
			Serial serial = new Serial(serailStartId++, rmsProgram.getId(),
					program.getFileUrl(), program.getFileUrl(), 0, "mp4",
					program.getTitle(), 1);
			serial.insert();
		}
	}

	public static void update() throws Exception {
		// 更新bofulfile
		List<BofulFile> bofulFiles = BofulFile.list();
		for (BofulFile bofulFile : bofulFiles) {
			String file_path = bofulFile.getFile_path();
			File file = new File(file_path);
			if (file.exists()) {
				String hash = FileUtils.getHexHash(file);
				bofulFile.setFile_hash(hash);
				bofulFile.setLogic_length(file.length());
				bofulFile.setFile_size(file.length());
				bofulFile.update();
			}

		}

		// 更新bofulfile
		List<Serial> serials = Serial.list();
		for (Serial serial : serials) {
			String file_path = serial.getFile_path();
			File file = new File(file_path);
			if (file.exists()) {
				String hash = FileUtils.getHexHash(file);
				serial.setFile_hash(hash);
				serial.setFile_size(file.length());
			}
		}
	}

	public static void main(String[] args) throws Exception {
		// 插入方法
		//insert();
		// 更新方法
		update();
	}
}
