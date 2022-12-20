package com.security.root.services;

import java.util.List;

import com.security.dto.AccessInfo;
import com.security.dto.AccessInfo.Type;

public interface AccessInfoService {

	void create(String username, Type logout);
	List<AccessInfo> getInfo(String loginId);
	List<AccessInfo> getAllInfo();
}
