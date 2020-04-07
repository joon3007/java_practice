package generic;

class GnrClass<T>{
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
class GnrMethod{
	public static <T> T function(T data) {
		T result = null;
		if (data instanceof Integer) {
			result = (T)"정수";
		}else if(data instanceof Double || data instanceof Float) {
			result = (T)"실수";
		}else if(data instanceof String) {
			result = (T)"문자열";
		}
		return result;
	}
}
public class GnrTest {
	public static void main(String[] args) {
		GnrClass<Integer> g = new GnrClass<Integer>();
		g.setData(10);
		System.out.println(g.getData());
		System.out.println(GnrMethod.function(10));
	}
	
}
