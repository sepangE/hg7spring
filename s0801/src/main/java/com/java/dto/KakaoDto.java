package com.java.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KakaoDto {
	public Long id;
	public String connected_at;
	public Properties properties;
	public Kakao_account kakao_account;
	
	@Data
	public class Properties{
		public String nickname;
	}
	
	@Data
	public class Kakao_account{
		public boolean profile_nickname_needs_agreement;
		public Profile profile;
		
	
		@Data
		public class Profile{
			public String nickname;
			public boolean is_default_nickname;
		}//Profile
	}//Kakao_account
	
}
