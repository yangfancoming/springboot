// Simple test program for service provider framework
package com.goat.effective.chapter02.item01;

public class Test {

    private static Provider DEFAULT_PROVIDER = ()->(IService) ()->"Default service";
    private static Provider COMP_PROVIDER = ()->(IService) ()->"Complementary service";
    private static Provider ARMED_PROVIDER = ()->(IService) ()->"Armed service";

	public static void main(String[] args) {
		// Providers would execute these lines
		Services.registerDefaultProvider(DEFAULT_PROVIDER);
		Services.registerProvider("comp", COMP_PROVIDER);
		Services.registerProvider("armed", ARMED_PROVIDER);

		// Clients would execute these lines
		IService s1 = Services.newInstance();
		IService s2 = Services.newInstance("comp");
		IService s3 = Services.newInstance("armed");
		System.out.printf( s1.sayHi() +  s2.sayHi() +  s3.sayHi() + "\n");

        IService s4 = Services.newInstance("asdf");
		System.out.printf(s4.sayHi());
	}


}
