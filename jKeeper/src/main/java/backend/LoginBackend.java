package backend;

public class LoginBackend {
	
	public LoginBackend() {
		
	}
	
	public boolean login(char[] attemptedPassword) {
		StringBuilder hi = new StringBuilder();
		for(int i = 0; i < attemptedPassword.length; i++) {
			hi.append(attemptedPassword[i]);
		}
		
		System.out.println(hi);
		return true;
	}
}
