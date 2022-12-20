package com.security.root.services.implemation;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.security.dto.AccessInfo;
import com.security.dto.AccessInfo.Type;
import com.security.root.services.AccessInfoService;

@Service
public class AccessInfoServiceImpl implements AccessInfoService {

	private static final String SELECT_INFO = """
			SELECT a.id,a.login_id loginId,u.name username,a.type,a.access_time accessTimeStamp FROM access_info a
			 JOIN users u ON u.login = a.login_id WHERE a.login_id = ? ORDER BY a.access_time DESC
				""";
	private static final String SELECT_ALL_INFO = """
			SELECT a.id,a.login_id loginId,u.name username,a.type,a.access_time accessTimeStamp FROM access_info a
			 JOIN users u ON u.login = a.login_id  ORDER BY a.access_time DESC
				""";
	@Autowired
	@Qualifier("access")
	private SimpleJdbcInsert jdbc;
	private RowMapper<AccessInfo> mapper;

	public AccessInfoServiceImpl() {
		mapper = new BeanPropertyRowMapper<AccessInfo>(AccessInfo.class);
	}

	@Override
	public void create(String username, Type type) {

		if (!username.equals("admin")) {
			jdbc.execute(Map.of("login_id", username, "type", type.name()));

		}

	}

	public List<AccessInfo> getInfo(String loginId) {
		return jdbc.getJdbcTemplate().query(SELECT_INFO, stm -> stm.setString(1, loginId), mapper);
	}
	
	public List<AccessInfo> getAllInfo(){
		return jdbc.getJdbcTemplate().query(SELECT_ALL_INFO,mapper);
	}

}
