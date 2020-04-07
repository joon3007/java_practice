package obj;

public class User {
	int num;

	public User() {
	}

	public User(int num) {
		super();
		this.num = num;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.num;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof User) {
			if (((User) obj).hashCode() == this.num) {
				return true;
			}
		}
		return false;
	}
}
