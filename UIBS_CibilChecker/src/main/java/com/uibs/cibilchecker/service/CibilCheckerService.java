package com.uibs.cibilchecker.service;

import com.uibs.cibilchecker.model.User;

public interface CibilCheckerService {

	public void checkCibil(User user);

	public User getCibilUser(long id);

}
