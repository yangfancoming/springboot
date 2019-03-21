package com.goat.C.C05.example01;

/**项目经理  */

public class PM extends Handler {

	@Override
	protected int getHandlerLevel() {
		return 1;
	}

	@Override
	protected Response echo(Request request) {
		System.out.println("员工的请求level是：" 
				+ request.getRequestLevel());
		System.out.println("项目经理的答复是：同意");
		return new Response();
	}
}
