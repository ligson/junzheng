package junzheng;

import java.sql.Connection;

public class ProgramCategoryPrograms {
	private long program_category_id;
	private long program_id;

	public long getProgram_category_id() {
		return program_category_id;
	}

	public void setProgram_category_id(long program_category_id) {
		this.program_category_id = program_category_id;
	}

	public long getProgram_id() {
		return program_id;
	}

	public void setProgram_id(long program_id) {
		this.program_id = program_id;
	}

	public void insert() throws Exception {
		Connection connection = ConnectPool.getRmsConnection();
		SqlUtils.insert(this, "program_category_programs", connection);
	}

}
