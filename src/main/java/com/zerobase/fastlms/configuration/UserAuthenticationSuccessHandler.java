package com.zerobase.fastlms.configuration;

import java.time.LocalDateTime;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import com.zerobase.fastlms.admin.model.mapper.MemberMapper;

public class UserAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	private final MemberMapper memberMapper;
	private final MemberHistoryService memberHistoryService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String userId = authentication.getName();
		memberMapper.updateLoginAt(userId, LocalDateTime.now());
		
		String userAgent = request.getHeader("user-agent");
		String clientIp = "";
		try {
			clientIp = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		MemberHistoryInput historyInput = MemberHistoryInput.builder()
				.userId(userId)
				.loginDt(LocalDateTime.now())
				.userIp(clientIp)
				.userAgent(userAgent)
				.build();
		
		memberHistoryService.save(historyInput);	
		
		setDefaultTargetUrl("/");
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
