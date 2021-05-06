package spring5_component_scan_study.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ChangePasswordService {
	@Autowired
	private MemberDao memberDao;
	
	
	public void changePassword(String email, String oldPwd, String newPwd) {
		Member member = memberDao.selectByEmail(email);
		if(member == null) 
			throw new MemberNotFoundException();
			
			member.changePassword(oldPwd, newPwd);
			
			memberDao.update(member);
		
			
	}


	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
}
