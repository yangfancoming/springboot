package com.goat.C.C05.item01;

/**部门经理类*/
public class DM extends Handler {

	@Override
	protected int getHandlerLevel() {
		return 2;
	}

	@Override
	protected Response echo(Request request) {
		System.out.println("员工的请求level是：" + request.getRequestLevel());
		System.out.println("部门经理的答复是：同意");
		return new Response();
	}

}
