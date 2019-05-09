// Service provider framework sketch - Service provider interface - Page 12
package com.goat.effective.chapter02.item01;

@FunctionalInterface
public interface Provider {
	IService newService();
}