package com.xiao.service;

import java.util.List;

public interface InvitationService {
    List<List<String>> getInvitationListByStudentEdId(String id);
    List<List<String>> getInvitationListByStudentId(String id);
}
