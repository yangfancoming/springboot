package com.goat.domain.p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional("transactionManagerPrimary") // 使用 数据源1 的事务
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public void deleteUserById(Long id) {
		userRepository.deleteById(id);
	}
}
