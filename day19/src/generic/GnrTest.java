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
		if(data instanceof Integer) {
			result = (T)"����";
		}else if(data instanceof Double || data instanceof Float) {
			result = (T)"�Ǽ�";
		}else if(data instanceof Character) {
			result = (T)"����";
		}else if(data instanceof String) {
			result = (T)"���ڿ�";
		}
		return result;
	}
}

public class GnrTest implements GnrInter<Double, Integer>{
	public static void main(String[] args) {
//		System.out.println(GnrMethod.function(3.14F));
//		GnrClass<Integer> g = new GnrClass();
//		g.setData(540);
//		System.out.println(g.getData());
	}

	@Override
	public Double add(Double data1, Double data2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double sub(Double data1, Integer data2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer mul(Integer data1, Integer data2) {
		// TODO Auto-generated method stub
		return null;
	}
}
