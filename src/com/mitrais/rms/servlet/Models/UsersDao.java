package com.mitrais.rms.servlet.Models;

import java.util.List;
import java.util.Optional;

public interface UsersDao extends Dao<Users, Integer> {
	
	 Optional<Users>findByUserEmail(String email);
	 Users find(int id);
	 List<Users> authentication(String email,String password);
}
