package dev.cbq.demo02.user.service;

import dev.cbq.demo02.user.domain.request.SignInVo;
import dev.cbq.demo02.user.domain.request.SignUpVo;

public interface SignService {
	String signIn(SignInVo vo);
	void signUp(SignUpVo vo);
}
