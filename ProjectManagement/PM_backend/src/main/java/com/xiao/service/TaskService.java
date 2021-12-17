package com.xiao.service;

import java.util.List;
import java.util.Map;

public interface TaskService {
    List<Map<String,Object>> getTeamTaskListByTId(String teamId);
}
