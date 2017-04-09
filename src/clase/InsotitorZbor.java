package clase;

public class InsotitorZbor implements HandlerCheckin {

	private String numeInsotitorZbor;

	public InsotitorZbor(String numeInsotitorZbor) {
		super();
		this.numeInsotitorZbor = numeInsotitorZbor;
	}

	@Override
	public void checkin() {
		System.out.println(this.numeInsotitorZbor + ": pasagerul a fost verificat");
	}

	@Override
	public void checkout() {
		System.out.println(this.numeInsotitorZbor + ": pasagerul a coborat");
	}

}
